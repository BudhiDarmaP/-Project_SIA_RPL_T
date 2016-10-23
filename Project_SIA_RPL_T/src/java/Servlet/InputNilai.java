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
            String kelas = String.valueOf(idKelas.charAt(0));
//            JOptionPane.showMessageDialog(null, idKelas);
//            String idKelas = "7A";
            CheckInputNilai check = new CheckInputNilai();
            String[] code = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
            for (int i = 0; i < 10; i++) {
                if (!check.CheckTypeDataInteger(check.CheckTandaBaca(request.getParameter(code[i] + "1")))) {
                    response.sendRedirect("Input.jsp?nis=" + nis + "&error=1");
                }
                if (!check.CheckTypeDataInteger(check.CheckTandaBaca(request.getParameter(code[i] + "2")))) {
                    response.sendRedirect("Input.jsp?nis=" + nis + "&error=1");
                }
                if (!check.CheckTypeDataInteger(check.CheckTandaBaca(request.getParameter(code[i] + "3")))) {
                    response.sendRedirect("Input.jsp?nis=" + nis + "&error=1");
                }
                if (!check.CheckTypeDataInteger(check.CheckTandaBaca(request.getParameter(code[i] + "4")))) {
                    response.sendRedirect("Input.jsp?nis=" + nis + "&error=1");
                }
                if (check.ChedckNilai((request.getParameter(code[i] + "1")),
                        (request.getParameter(code[i] + "2")),
                        (request.getParameter(code[i] + "3")),
                        (request.getParameter(code[i] + "4"))) == 1) {
                    response.sendRedirect("Input.jsp?nis=" + nis + "&error=1");
                }
            }
            int checkSemester = new DataNilai().checkSemester(nis, Integer.parseInt(semester), kelas);
            if (checkSemester == 0) {
                response.sendRedirect("Input.jsp?nis=" + nis + "&error=3");
            } else if (checkSemester == 2) {
                response.sendRedirect("Input.jsp?nis=" + nis + "&error=2");
            } //ipa
            else {
                new DataNilai().inputNilai(Integer.parseInt(semester),
                        Double.parseDouble(request.getParameter("a1")),
                        Double.parseDouble(request.getParameter("a2")),
                        Double.parseDouble(request.getParameter("a3")),
                        Double.parseDouble(request.getParameter("a4")),
                        nis, kelas + "IPA");
                new DataNilai().hitungNilaiSemester(nis, kelas + "IPA",
                        Integer.parseInt(semester),
                        Double.parseDouble(request.getParameter("a1")),
                        Double.parseDouble(request.getParameter("a2")),
                        Double.parseDouble(request.getParameter("a3")),
                        Double.parseDouble(request.getParameter("a4")));
                //ips
                new DataNilai().inputNilai(Integer.parseInt(semester),
                        Double.parseDouble(request.getParameter("b1")),
                        Double.parseDouble(request.getParameter("b2")),
                        Double.parseDouble(request.getParameter("b3")),
                        Double.parseDouble(request.getParameter("b4")),
                        nis, kelas + "IPS");
                new DataNilai().hitungNilaiSemester(nis, kelas + "IPS",
                        Integer.parseInt(semester),
                        Double.parseDouble(request.getParameter("b1")),
                        Double.parseDouble(request.getParameter("b2")),
                        Double.parseDouble(request.getParameter("b3")),
                        Double.parseDouble(request.getParameter("b4")));
                //MTK
                new DataNilai().inputNilai(Integer.parseInt(semester),
                        Double.parseDouble(request.getParameter("c1")),
                        Double.parseDouble(request.getParameter("c2")),
                        Double.parseDouble(request.getParameter("c3")),
                        Double.parseDouble(request.getParameter("c4")),
                        nis, kelas + "MTK");
                new DataNilai().hitungNilaiSemester(nis, kelas + "MTK",
                        Integer.parseInt(semester),
                        Double.parseDouble(request.getParameter("c1")),
                        Double.parseDouble(request.getParameter("c2")),
                        Double.parseDouble(request.getParameter("c3")),
                        Double.parseDouble(request.getParameter("c4")));
                //AGM
                new DataNilai().inputNilai(Integer.parseInt(semester),
                        Double.parseDouble(request.getParameter("d1")),
                        Double.parseDouble(request.getParameter("d2")),
                        Double.parseDouble(request.getParameter("d3")),
                        Double.parseDouble(request.getParameter("d4")),
                        nis, kelas + "AGM");
                new DataNilai().hitungNilaiSemester(nis, kelas + "AGM",
                        Integer.parseInt(semester),
                        Double.parseDouble(request.getParameter("d1")),
                        Double.parseDouble(request.getParameter("d2")),
                        Double.parseDouble(request.getParameter("d3")),
                        Double.parseDouble(request.getParameter("d4")));
                //IND
                new DataNilai().inputNilai(Integer.parseInt(semester),
                        Double.parseDouble(request.getParameter("e1")),
                        Double.parseDouble(request.getParameter("e2")),
                        Double.parseDouble(request.getParameter("e3")),
                        Double.parseDouble(request.getParameter("e4")),
                        nis, kelas + "IND");
                new DataNilai().hitungNilaiSemester(nis, kelas + "IND",
                        Integer.parseInt(semester),
                        Double.parseDouble(request.getParameter("e1")),
                        Double.parseDouble(request.getParameter("e2")),
                        Double.parseDouble(request.getParameter("e3")),
                        Double.parseDouble(request.getParameter("e4")));
                //ING
                new DataNilai().inputNilai(Integer.parseInt(semester),
                        Double.parseDouble(request.getParameter("f1")),
                        Double.parseDouble(request.getParameter("f2")),
                        Double.parseDouble(request.getParameter("f3")),
                        Double.parseDouble(request.getParameter("f4")),
                        nis, kelas + "ING");
                new DataNilai().hitungNilaiSemester(nis, kelas + "ING",
                        Integer.parseInt(semester),
                        Double.parseDouble(request.getParameter("f1")),
                        Double.parseDouble(request.getParameter("f2")),
                        Double.parseDouble(request.getParameter("f3")),
                        Double.parseDouble(request.getParameter("f4")));
                //KWN
                new DataNilai().inputNilai(Integer.parseInt(semester),
                        Double.parseDouble(request.getParameter("g1")),
                        Double.parseDouble(request.getParameter("g2")),
                        Double.parseDouble(request.getParameter("g3")),
                        Double.parseDouble(request.getParameter("g4")),
                        nis, kelas + "KWN");
                new DataNilai().hitungNilaiSemester(nis, kelas + "KWN",
                        Integer.parseInt(semester),
                        Double.parseDouble(request.getParameter("g1")),
                        Double.parseDouble(request.getParameter("g2")),
                        Double.parseDouble(request.getParameter("g3")),
                        Double.parseDouble(request.getParameter("g4")));
                //PJO
                new DataNilai().inputNilai(Integer.parseInt(semester),
                        Double.parseDouble(request.getParameter("h1")),
                        Double.parseDouble(request.getParameter("h2")),
                        Double.parseDouble(request.getParameter("h3")),
                        Double.parseDouble(request.getParameter("h4")),
                        nis, kelas + "PJO");
                new DataNilai().hitungNilaiSemester(nis, kelas + "PJO",
                        Integer.parseInt(semester),
                        Double.parseDouble(request.getParameter("h1")),
                        Double.parseDouble(request.getParameter("h2")),
                        Double.parseDouble(request.getParameter("h3")),
                        Double.parseDouble(request.getParameter("h4")));
                //PRK
                new DataNilai().inputNilai(Integer.parseInt(semester),
                        Double.parseDouble(request.getParameter("i1")),
                        Double.parseDouble(request.getParameter("i2")),
                        Double.parseDouble(request.getParameter("i3")),
                        Double.parseDouble(request.getParameter("i4")),
                        nis, kelas + "PRK");
                new DataNilai().hitungNilaiSemester(nis, kelas + "PRK",
                        Integer.parseInt(semester),
                        Double.parseDouble(request.getParameter("i1")),
                        Double.parseDouble(request.getParameter("i2")),
                        Double.parseDouble(request.getParameter("i3")),
                        Double.parseDouble(request.getParameter("i4")));
                //SEN
                new DataNilai().inputNilai(Integer.parseInt(semester),
                        Double.parseDouble(request.getParameter("j1")),
                        Double.parseDouble(request.getParameter("j2")),
                        Double.parseDouble(request.getParameter("j3")),
                        Double.parseDouble(request.getParameter("j4")),
                        nis, kelas + "SEN");
                new DataNilai().hitungNilaiSemester(nis, kelas + "SEN",
                        Integer.parseInt(semester),
                        Double.parseDouble(request.getParameter("j1")),
                        Double.parseDouble(request.getParameter("j2")),
                        Double.parseDouble(request.getParameter("j3")),
                        Double.parseDouble(request.getParameter("j4")));
            }
////////
            if (semester.equals("1")) {
                new DataNilai().hitungNilaiAkhir(nis, kelas + "IPA", Integer.parseInt(semester),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "IPA"),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "IPA"));
                new DataNilai().hitungNilaiAkhir(nis, kelas + "IPS", Integer.parseInt(semester),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "IPS"),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "IPS"));
                new DataNilai().hitungNilaiAkhir(nis, kelas + "AGM", Integer.parseInt(semester),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "AGM"),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "AGM"));
                new DataNilai().hitungNilaiAkhir(nis, kelas + "MTK", Integer.parseInt(semester),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "MTK"),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "MTK"));
                new DataNilai().hitungNilaiAkhir(nis, kelas + "IND", Integer.parseInt(semester),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "IND"),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "IND"));
                new DataNilai().hitungNilaiAkhir(nis, kelas + "ING", Integer.parseInt(semester),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "ING"),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "ING"));
                new DataNilai().hitungNilaiAkhir(nis, kelas + "KWN", Integer.parseInt(semester),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "KWN"),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "KWN"));
                new DataNilai().hitungNilaiAkhir(nis, kelas + "PRK", Integer.parseInt(semester),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "PRK"),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "PRK"));
                new DataNilai().hitungNilaiAkhir(nis, kelas + "PJO", Integer.parseInt(semester),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "PJO"),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "PJO"));
                new DataNilai().hitungNilaiAkhir(nis, kelas + "SEN", Integer.parseInt(semester),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "SEN"),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "SEN"));
            }
            if (semester.equals("2")) {
                new DataNilai().hitungNilaiAkhir(nis, kelas + "IPA", Integer.parseInt(semester),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "IPA"),
                        new DataNilai().panggilNilaiSemesterDua(nis, kelas + "IPA"));
                new DataNilai().hitungNilaiAkhir(nis, kelas + "IPS", Integer.parseInt(semester),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "IPS"),
                        new DataNilai().panggilNilaiSemesterDua(nis, kelas + "IPS"));
                new DataNilai().hitungNilaiAkhir(nis, kelas + "AGM", Integer.parseInt(semester),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "AGM"),
                        new DataNilai().panggilNilaiSemesterDua(nis, kelas + "AGM"));
                new DataNilai().hitungNilaiAkhir(nis, kelas + "MTK", Integer.parseInt(semester),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "MTK"),
                        new DataNilai().panggilNilaiSemesterDua(nis, kelas + "MTK"));
                new DataNilai().hitungNilaiAkhir(nis, kelas + "IND", Integer.parseInt(semester),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "IND"),
                        new DataNilai().panggilNilaiSemesterDua(nis, kelas + "IND"));
                new DataNilai().hitungNilaiAkhir(nis, kelas + "ING", Integer.parseInt(semester),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "ING"),
                        new DataNilai().panggilNilaiSemesterDua(nis, kelas + "ING"));
                new DataNilai().hitungNilaiAkhir(nis, kelas + "KWN", Integer.parseInt(semester),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "KWN"),
                        new DataNilai().panggilNilaiSemesterDua(nis, kelas + "KWN"));
                new DataNilai().hitungNilaiAkhir(nis, kelas + "PRK", Integer.parseInt(semester),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "PRK"),
                        new DataNilai().panggilNilaiSemesterDua(nis, kelas + "PRK"));
                new DataNilai().hitungNilaiAkhir(nis, kelas + "PJO", Integer.parseInt(semester),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "PJO"),
                        new DataNilai().panggilNilaiSemesterDua(nis, kelas + "PJO"));
                new DataNilai().hitungNilaiAkhir(nis, kelas + "SEN", Integer.parseInt(semester),
                        new DataNilai().panggilNilaiSemesterSatu(nis, kelas + "SEN"),
                        new DataNilai().panggilNilaiSemesterDua(nis, kelas + "SEN"));

            }
            if (semester.equals("2")) {
                String[] daftarKode1 = {
                    "7IPA", "7IPS", "7MTK", "7AGM", "7IND", "7ING", "7KWN", "7PJO", "7PRK", "7SEN"
                };
                String[] daftarKode2 = {
                    "8IPA", "8IPS", "8MTK", "8AGM", "8IND", "8ING", "8KWN", "8PJO", "8PRK", "8SEN"
                };
                System.out.println("a");
                int[] tempStatus = new int[10];
                for (int i = 0; i < 10; i++) {
                    if (kelas.equals("7")) {
                        tempStatus[i] = new DataNilai().panggilStatusPerMapel(nis, daftarKode1[i], new DataNilai().panggilKKM(daftarKode1[i]));
                    } else if (kelas.equals("8")) {
                        tempStatus[i] = new DataNilai().panggilStatusPerMapel(nis, daftarKode2[i], new DataNilai().panggilKKM(daftarKode2[i]));
                    }
                }
                int stat = new DataNilai().checkStatus(tempStatus);
                if (stat == 1) {
                    if (kelas.equals("7") || kelas.equals("8")) {
                        new DataSiswa().updateKelas(nis, idKelas);
                        System.out.println("a");
                    }
                }
            }
            response.sendRedirect("tampilNilai1.jsp?nis=" + nis + "&semester=" + semester);
        } catch (SQLException ex) {
            Logger.getLogger(InputNilai.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(InputNilai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
