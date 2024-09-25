package com.example.servlet;

import com.example.model.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/crearProducto")
public class ProductoServlet extends HttpServlet {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadPersistenciaP");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nombre = req.getParameter("nombre");
        String descripcion = req.getParameter("descripcion");

        //Creamos el objeto de nuevo producto
        Producto producto = new Producto(nombre, descripcion);

        //Persistimos el usuario en la base de datos
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(producto);
        em.getTransaction().commit();
        em.close();

        //Redirigimos a la página de éxito
        req.setAttribute("producto", producto);
        req.getRequestDispatcher("indexp.jsp").forward(req, resp);

    }

}
