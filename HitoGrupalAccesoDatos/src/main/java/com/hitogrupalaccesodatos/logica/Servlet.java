package com.hitogrupalaccesodatos.logica;

import java.io.*;
import java.util.List;

import com.hitogrupalaccesodatos.model.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    private String message;

    //Constructor
    public Servlet()
    {
        super();
    }

    //Mensaje servlet
    public void init() {
        message = "Acceso a las recomendaciones";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    //doPost
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //Parámetros recogidos del formulario de index.jsp
        String nombre = request.getParameter("user");
        String pass = request.getParameter("pass");

        //Objeto LogicaBD
        LogicaBD logicaBD = new LogicaBD();

        //Utilizamos la función comprobarUser
        Usuario userBuscado = logicaBD.comprobarUser(nombre, pass);

        //Comprobar usuario
        if (userBuscado != null) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("user", userBuscado);
            response.sendRedirect("recomendaciones.jsp");
        } else if (userBuscado==null) {
            response.sendRedirect("redirect.jsp");
        }
        else {
            System.out.println("Error de login");
        }

    }

}