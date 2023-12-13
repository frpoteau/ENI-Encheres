package fr.eni.encheres.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import fr.eni.encheres.dal.jdbc.DBManager;

@MultipartConfig
@WebServlet("/AddArticleServlet")
public class AddArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récupérer 'userId' depuis la session
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userID");

		// Récupérer les données du formulaire
		String nomArticle = request.getParameter("nomArticle");
		String desc = request.getParameter("desc");
		String categorie = request.getParameter("categorie"); // Récupérer le libellé de la catégorie
		String dateD = request.getParameter("dateD");
		String heureD = request.getParameter("heureD");
		String dateF = request.getParameter("dateF");
		String heureF = request.getParameter("heureF");
		String prixInit = request.getParameter("prixInit");
		String adresseRetrait = request.getParameter("adresseRetrait");
		Part imagePart = request.getPart("imageFile");

		// Récupérez les données binaires de l'image
		if (imagePart != null) {
			try {
				InputStream imageInputStream = imagePart.getInputStream();
				byte[] imageData = imageInputStream.readAllBytes();

				System.out.println("Données binaires de l'image récupérées avec succès.");

				// ... votre code pour stocker les données binaires dans l'emplacement souhaité
				// (0x) ...

				Connection connection = null;
				PreparedStatement preparedStatement = null;

				try {
					// Ajoutez des impressions pour vérifier les valeurs
					System.out.println("nomArticle: " + nomArticle);
					System.out.println("desc: " + desc);
					System.out.println("categorie: " + categorie);
					System.out.println("dateD: " + dateD);
					System.out.println("heureD: " + heureD);
					System.out.println("dateF: " + dateF);
					System.out.println("heureF: " + heureF);
					System.out.println("prixInit: " + prixInit);
					System.out.println("adresseRetrait: " + adresseRetrait);

					// Obtenez une connexion à la base de données en utilisant la classe DBManager
					connection = DBManager.getConnection();

					// Récupérer le no_categorie correspondant au libellé
					int categorieId = DBManager.getCategoryIdByLabel(categorie);

					// Ajoutez des logs pour vérifier les valeurs
					System.out.println("categorie: " + categorie);
					System.out.println("categorieId: " + categorieId);

					// Vérifier si la catégorie existe
					if (categorieId == -1) {
						// La catégorie n'existe pas, renvoyer un message d'erreur ou rediriger vers une
						// page d'erreur
						System.out.println("La catégorie n'existe pas.");
						response.sendRedirect("error.jsp");
						return;
					}

					// Conversion des chaînes en objets java.sql.Date et java.sql.Time
					Date dateDebut = convertStringToDate(dateD);
					Time formattedHeureDebut = convertStringToTime(heureD);
					Date dateFin = convertStringToDate(dateF);
					Time formattedHeureFin = convertStringToTime(heureF);

					// Requête SQL pour l'insertion d'un nouvel article
					String insertQuery = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, heure_debut_encheres, date_fin_encheres, heure_fin_encheres, prix_initial, adresse_retrait, no_utilisateur, no_categorie, image_data) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

					// Préparation de la requête avec les valeurs du formulaire
					preparedStatement = connection.prepareStatement(insertQuery);
					preparedStatement.setString(1, nomArticle);
					preparedStatement.setString(2, desc);
					preparedStatement.setDate(3, dateDebut);
					preparedStatement.setTime(4, formattedHeureDebut);
					preparedStatement.setDate(5, dateFin);
					preparedStatement.setTime(6, formattedHeureFin);
					preparedStatement.setString(7, prixInit);
					preparedStatement.setString(8, adresseRetrait);
					preparedStatement.setInt(9, userId); // 'no_utilisateur'
					preparedStatement.setInt(10, categorieId); // 'no_categorie'

					preparedStatement.setBytes(11, imageData);
					System.out.println("Requête SQL préparée avec succès.");

					// Exécution de la requête d'insertion
					preparedStatement.executeUpdate();

					// Définir l'attribut de session pour le message de confirmation
					session.setAttribute("confirmationMessage", "Votre article a été ajouté avec succès !");

					// Redirection vers la page de confirmation après l'ajout réussi
					response.sendRedirect("form_add_new_item.jsp");
				} catch (SQLException e) {
					// Gestion des erreurs de base de données
					e.printStackTrace();

					// Ajoutez des logs pour suivre l'exception
					System.out.println("SQLException: " + e.getMessage());

					// Vous pouvez rediriger vers une page d'erreur spécifique si nécessaire
					System.out.println("Redirection vers la page d'erreur.");
					response.sendRedirect("error.jsp");
				} catch (ParseException e) {
					// Gestion des erreurs de conversion de date
					e.printStackTrace();
					System.out.println("Erreur de conversion de date.");
					response.sendRedirect("error.jsp");
				} finally {
					// Assurez-vous de fermer la connexion et la déclaration dans tous les cas
					if (connection != null) {
						try {
							connection.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					if (preparedStatement != null) {
						try {
							preparedStatement.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Erreur lors de la récupération des données binaires de l'image.");
				response.sendRedirect("error.jsp");
			}
		} else {
			// Gérer le cas où l'image n'a pas été fournie
			System.out.println("L'image n'a pas été fournie.");
			response.sendRedirect("error.jsp");
		}
	}

	private Date convertStringToDate(String dateStr) throws ParseException {
		System.out.println("Date string before conversion: " + dateStr);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.FRENCH);
		java.util.Date parsedDate = dateFormat.parse(dateStr);
		Date sqlDate = new Date(parsedDate.getTime());

		System.out.println("Date after conversion: " + sqlDate);

		return sqlDate;
	}

	private Time convertStringToTime(String heureStr) throws ParseException {
		System.out.println("Heure string before conversion: " + heureStr);

		SimpleDateFormat heureFormat = new SimpleDateFormat("HH:mm", Locale.FRENCH);
		java.util.Date parsedTime = heureFormat.parse(heureStr);

		Time sqlTime = new Time(parsedTime.getTime());

		System.out.println("Heure after conversion: " + sqlTime);

		return sqlTime;
	}
}