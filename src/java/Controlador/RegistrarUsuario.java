/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Models.Perfil;
import Models.Usuario;
import SQL.RegistroUsuario;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 *
 * @author Gamcas
 */
@WebServlet(name = "RegistrarUsuario", urlPatterns = {"/RegistrarUsuario"})
@MultipartConfig(maxFileSize = 16177215)

public class RegistrarUsuario extends HttpServlet {

    RegistroUsuario registro = new RegistroUsuario();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrarUsuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrarUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario user = new Usuario();
        Perfil perfil = new Perfil();
        
        Part part = request.getPart("foto");
        InputStream file = part.getInputStream();
        
        String usuario = request.getParameter("user");
        String pass = request.getParameter("pass");
        int tipo = Integer.valueOf(request.getParameter("subject"));

        user.setPass(pass);
        user.setTipo(tipo);
        user.setUsuario(usuario);
        if (registro.crearUsuario(user) == true) {

            perfil.setNombre(request.getParameter("nombre"));
            perfil.setApellido(request.getParameter("LastName"));
            perfil.setDescripcion(request.getParameter("Descripcion"));
            perfil.setGustos(request.getParameter("Gustos"));
            perfil.setHobbies(request.getParameter("Hobbies"));
            perfil.setFoto(file);
            perfil.setUsuario(usuario);

            if (registro.crearPerfil(perfil) == true) {

                request.setAttribute("usuario", user);
                request.getRequestDispatcher("Controlador?accion=RegistroCorrecto").forward(request, response);

            } else {
                out.print("error");
            }

        } else {
            request.setAttribute("error", true);
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
