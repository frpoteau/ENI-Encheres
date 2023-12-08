<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8" />
    <link href="css/style.css" rel="stylesheet" />
    <script src="https://cdn.tailwindcss.com"></script>
  </head>
  <body>
    <div class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
      <div class="flex h-20 items-center justify-end">
        <div class="flex">
          <<form action="ServletConnectDB" method="post">
            <input
              placeholder="Email"
              class="border py-1.5 rounded-md px-2 shadow-sm text-sm"
              type="email" id="email" name="email"  required
            />
            <input
              placeholder="Mot de passe"
 type="password" id="password" name="password" required
              class="border py-1.5 rounded-md px-2 shadow-sm text-sm"
            />
            <button
              type="submit"
              class="bg-black text-white py-1.5 px-4 rounded-full text-sm"
            >
              Se connecter
            </button>
          </form>
          <button
            href="register.jsp"
            class="bg-black text-white py-1.5 px-4 rounded-full ml-1 text-sm"
          >
            S'inscrire
          </button>
        </div>
      </div>
      <div class="flex items-center justify-end">
        <a href="reinitpassword.jsp" class="text-sm underline -mt-2"
          >Mot de passe oublié ?</a
        >
      </div>
    </div>
  </body>
</html>
