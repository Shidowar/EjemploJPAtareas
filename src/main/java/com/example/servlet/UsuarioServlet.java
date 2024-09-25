package com.example.servlet;

import com.example.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/crearUsuario")
public class UsuarioServlet extends HttpServlet {
 private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadPersistencia");

 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  String nombre = req.getParameter("nombre");
  String email = req.getParameter("email");

  //Creamos el objeto de nuevo usuario
  Usuario usuario = new Usuario(nombre, email);

  //Persistimos el usuario en la base de datos
  EntityManager em = emf.createEntityManager();
  em.getTransaction().begin();
  em.persist(usuario);
  em.getTransaction().commit();
  em.close();

  //Redirigimos a la página de éxito
  req.setAttribute("usuario", usuario);
  req.getRequestDispatcher("index.jsp").forward(req, resp);

 }

}
