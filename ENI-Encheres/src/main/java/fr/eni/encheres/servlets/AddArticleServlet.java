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

import fr.eni.encheres.DateTimeConverter;
import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bo.Article;

@MultipartConfig
@WebServlet("/AddArticleServlet")
public class AddArticleServlet extends HttpServlet 
{
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
		int prixInit = Integer.valueOf(request.getParameter("prixInit"));
		int prixVente = 0;
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

					// Récupérer le no_categorie correspondant au libellé
					int categorieId = CategorieManager.getInstance().getCategoryIdByLabel(categorie);

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
					Date dateDebut = DateTimeConverter.convertStringToDate(dateD);
					Time formattedHeureDebut = DateTimeConverter.convertStringToTime(heureD);
					Date dateFin = DateTimeConverter.convertStringToDate(dateF);
					Time formattedHeureFin = DateTimeConverter.convertStringToTime(heureF);

					Article a = new Article(nomArticle, desc, dateDebut, formattedHeureDebut, dateFin,
							formattedHeureFin, prixInit, prixVente, userId, categorieId, adresseRetrait);

					ArticleManager.getInstance().ajouterArticle(a);

					System.out.println("Requête SQL préparée avec succès.");

					// Définir l'attribut de session pour le message de confirmation
					session.setAttribute("confirmationMessage", "Votre article a été ajouté avec succès !");

					// Redirection vers la page de confirmation après l'ajout réussi
					response.sendRedirect("form_add_new_item.jsp");

				} catch (ParseException e) {
					// Gestion des erreurs de conversion de date
					e.printStackTrace();
					System.out.println("Erreur de conversion de date.");
					response.sendRedirect("error.jsp");
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

}