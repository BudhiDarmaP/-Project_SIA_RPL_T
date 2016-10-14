/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class InputNilai extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
        String nis = request.getParameter("nis");
        String semester = request.getParameter("semester");
        try {
            String idKelas = new DataSiswa().findIdKelas(nis);
            String kelas=String.valueOf(idKelas.charAt(0)) ;
//            String idKelas = "7A";
            CheckInputNilai check = new CheckInputNilai();
            String[] code= {"a","b","c","d","e","f","g","h","i","j"};
            for (int i = 0; i < 10; i++) {
                if (!check.CheckTypeDataInteger(check.CheckTandaBaca(request.getParameter(code[i]+"1"))))
                    response.sendRedirect("Input.jsp?nis="+nis+"&error=1");
                if (!check.CheckTypeDataInteger(check.CheckTandaBaca(request.getParameter(code[i]+"2"))))
                    response.sendRedirect("Input.jsp?nis="+nis+"&error=1");
                if (!check.CheckTypeDataInteger(check.CheckTandaBaca(request.getParameter(code[i]+"3"))))
                    response.sendRedirect("Input.jsp?nis="+nis+"&error=1");
                if (!check.CheckTypeDataInteger(check.CheckTandaBaca(request.getParameter(code[i]+"4"))))
                    response.sendRedirect("Input.jsp?nis="+nis+"&error=1");
                if (check.ChedckNilai((request.getParameter(code[i]+"1")), 
                        (request.getParameter(code[i]+"2")), 
                        (request.getParameter(code[i]+"3")), 
                        (request.getParameter(code[i]+"4")))==1) {
                    response.sendRedirect("Input.jsp?nis="+nis+"&error=1");
                    
                }
            }
            new DataNilai().inputNilai(Integer.parseInt(semester), 
                    Double.parseDouble(request.getParameter("a1")),
                    Double.parseDouble(request.getParameter("a2")),
                    Double.parseDouble(request.getParameter("a3")),
                    Double.parseDouble(request.getParameter("a4")),
                    nis, kelas+"IPA");
            new DataNilai().inputNilai(Integer.parseInt(semester), 
                    Double.parseDouble(request.getParameter("b1")),
                    Double.parseDouble(request.getParameter("b2")),
                    Double.parseDouble(request.getParameter("b3")),
                    Double.parseDouble(request.getParameter("b4")),
                    nis, kelas+"IPS");
            new DataNilai().inputNilai(Integer.parseInt(semester), 
                    Double.parseDouble(request.getParameter("c1")),
                    Double.parseDouble(request.getParameter("c2")),
                    Double.parseDouble(request.getParameter("c3")),
                    Double.parseDouble(request.getParameter("c4")),
                    nis, kelas+"MTK");
            new DataNilai().inputNilai(Integer.parseInt(semester), 
                    Double.parseDouble(request.getParameter("d1")),
                    Double.parseDouble(request.getParameter("d2")),
                    Double.parseDouble(request.getParameter("d3")),
                    Double.parseDouble(request.getParameter("d4")),
                    nis, kelas+"AGM");
            new DataNilai().inputNilai(Integer.parseInt(semester), 
                    Double.parseDouble(request.getParameter("e1")),
                    Double.parseDouble(request.getParameter("e2")),
                    Double.parseDouble(request.getParameter("e3")),
                    Double.parseDouble(request.getParameter("e4")),
                    nis, kelas+"IND");
            new DataNilai().inputNilai(Integer.parseInt(semester), 
                    Double.parseDouble(request.getParameter("f1")),
                    Double.parseDouble(request.getParameter("f2")),
                    Double.parseDouble(request.getParameter("f3")),
                    Double.parseDouble(request.getParameter("f4")),
                    nis, kelas+"ING");
            new DataNilai().inputNilai(Integer.parseInt(semester), 
                    Double.parseDouble(request.getParameter("g1")),
                    Double.parseDouble(request.getParameter("g2")),
                    Double.parseDouble(request.getParameter("g3")),
                    Double.parseDouble(request.getParameter("g4")),
                    nis, kelas+"KWN");
            new DataNilai().inputNilai(Integer.parseInt(semester), 
                    Double.parseDouble(request.getParameter("h1")),
                    Double.parseDouble(request.getParameter("h2")),
                    Double.parseDouble(request.getParameter("h3")),
                    Double.parseDouble(request.getParameter("h4")),
                    nis, kelas+"PJO");
            new DataNilai().inputNilai(Integer.parseInt(semester), 
                    Double.parseDouble(request.getParameter("i1")),
                    Double.parseDouble(request.getParameter("i2")),
                    Double.parseDouble(request.getParameter("i3")),
                    Double.parseDouble(request.getParameter("i4")),
                    nis, kelas+"PRK");
            new DataNilai().inputNilai(Integer.parseInt(semester), 
                    Double.parseDouble(request.getParameter("j1")),
                    Double.parseDouble(request.getParameter("j2")),
                    Double.parseDouble(request.getParameter("j3")),
                    Double.parseDouble(request.getParameter("j4")),
                    nis, kelas+"SEN");
            response.sendRedirect("tampilNilai1.jsp?nis="+nis+"&semester="+semester);
        } catch (SQLException ex) {
            Logger.getLogger(InputNilai.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(InputNilai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
