/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.Siswa;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lycorice
 */
public class SiswaServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse respone)
            throws ServletException, IOException {
        try {
            DataSiswa dataSiswa = new DataSiswa();
            ArrayList<Siswa> siswaList = dataSiswa.list();
            request.setAttribute("siswaList", siswaList);
            request.getRequestDispatcher("ListSiswa.jsp").forward(request, respone);
        } catch (SQLException ex) {
            throw new ServletException("Cannot obtain products from DB", ex);
        }
    }
}
