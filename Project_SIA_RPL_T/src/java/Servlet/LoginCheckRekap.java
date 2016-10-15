/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lycorice
 */
public class LoginCheckRekap extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//
////        int n = 0;
////        String page = request.getParameter("page");
////
////        if (page.equalsIgnoreCase("login")) {
//        String nis = request.getParameter("nis");
//        ArrayList<Siswa> siswaList = null;
//        DataSiswa dataSiswa = new DataSiswa();
//        try {
//            siswaList = dataSiswa.list();
//
//            for (Siswa siswa : siswaList) {
////                n++;
//                if (siswa.getNis().equals(nis)) {
//                    response.sendRedirect("Input.jsp");
//                } else if (!siswa.getNis().equals(nis)) {
//                    response.sendRedirect("awal.jsp?error=1");
////                    return;
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(SiswaServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
////        }
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
        String nis = request.getParameter("nis");
        try {
            if (new DataSiswa().find(nis))response.sendRedirect("Status.jsp?nis="+nis);
            else response.sendRedirect("awal2.jsp?error=1");
        } catch (SQLException ex) {
            Logger.getLogger(LoginCheckRekap.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        processRequest(request, response);
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

//
////        int n = 0;
////        String page = request.getParameter("page");
////
////        if (page.equalsIgnoreCase("login")) {
//        String nis = request.getParameter("nis");
//        ArrayList<Siswa> siswaList = null;
//        DataSiswa dataSiswa = new DataSiswa();
//        try {
//            siswaList = dataSiswa.list();
//
//            for (Siswa siswa : siswaList) {
////                n++;
//                if (siswa.getNis().equals(nis)) {
//                    response.sendRedirect("Input.jsp");
//                } else if (!siswa.getNis().equals(nis)) {
//                    response.sendRedirect("awal.jsp?error=1");
////                    return;
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(SiswaServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
