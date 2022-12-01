package com.hitogrupalaccesodatos.logica;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import com.hitogrupalaccesodatos.model.Recomendacion;
import com.hitogrupalaccesodatos.model.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(name = "Servlet2", value = "/Servlet2")
public class Servlet2 extends HttpServlet {
    private String message;

    //Constructor
    public Servlet2()
    {
        super();
    }

    //Mensaje servlet2
    public void init() {
        message = "Insertar recomendaciones";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    //doPost
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

        //Parámetros del formulario recomendaciones.jsp
        String juego = request.getParameter("game");
        String genero = request.getParameter("genre");
        Integer valoracion = Integer.valueOf(request.getParameter("rating"));

        //Objeto LogicaBD
        LogicaBD logicaBD = new LogicaBD();

        //Objeto sesión (recogemos los atributos del usuario en la String user)
        HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("user");

        //Parámetros a pasar en la función Insertar
        logicaBD.Insertar(user, juego, genero, valoracion);

        //Comprobar recomendación insertada
        if (user != null) {
            response.sendRedirect("correcto.jsp");
        } else if (user==null) {
            response.sendRedirect("redirect.jsp");
        }
        else {
            System.out.println("Error al insertar");
        }
    }

}