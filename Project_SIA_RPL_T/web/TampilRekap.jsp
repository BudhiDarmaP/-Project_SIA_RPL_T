<%@page import="Model.Nilai"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Servlet.DataNilai"%>
<%@page import="Servlet.DataSiswa"%>
<%@page import="java.sql.Connection"%>
<%@page import="Servlet.DatabaseConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Tampil Rekap Nilai</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="assets/css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%
            DatabaseConnection database = new DatabaseConnection();
            Connection connection = database.getConnection();
            String nis = request.getParameter("nis");
        %>
        <div id="c1"></div>
        <div id="c2"></div>
        <div id="header">
            <a href="index.jsp">
                <img src="assets/images/logo-SIA-300x241.png" style="width: auto;height: 100%">
            </a>
        </div>
        <div id="form-rekap-score">
            <br>
            <form action="menu.jsp" tyle="align-content: center; ">
                <table style="text-align: left;">
                    <tr>
                        <th>NIS</th>
                        <td>: </td>
                        <td><%//panggil NIS
                            out.print(nis);
                            %>
                        </td>
                    </tr>
                    <tr>
                        <th>Nama Siswa</th>
                        <td>: </td>
                        <td><%//panggil nama siswa
                            out.print(new DataSiswa().findNama(nis));
                            %>
                        </td>
                    </tr>
                </table>
            </form>
            <br> Lihat Nilai : <br>
            <form action="Sem1.jsp"> 
                <input type="hidden" name="nis" value="<%=nis%>">
                <!--<input type="hidden" name="semester" value="1">-->
                <input type="submit" value="Semester 1" name="Sem1">
            </form>
            <form action="Sem2.jsp">
                <input type="hidden" name="nis" value="<%=nis%>">
                <!--<input type="hidden" name="semester" value="2">-->
                <input type="submit" value="Semester 2" name="Sem2">
            </form>
            <form action="LoginCheck" id="form-find-nim-insert"> 
            <%
                String[] daftarKode1 = {
                    "7IPA", "7IPS", "7MTK", "7AGM", "7IND", "7ING", "7KWN", "7PJO", "7PRK", "7SEN"
                };
                String[] daftarKode2 = {
                    "8IPA", "8IPS", "8MTK", "8AGM", "8IND", "8ING", "8KWN", "8PJO", "8PRK", "8SEN"
                };
                String[] daftarKode3 = {
                    "9IPA", "9IPS", "9MTK", "9AGM", "9IND", "9ING", "9KWN", "9PJO", "9PRK", "9SEN"
                };
                String kelas = String.valueOf(new DataSiswa().findIdKelas(nis).charAt(0));
                int[] tempStatus = new int[10];
                for (int i = 0; i < 10; i++) {
                    if (kelas.equals("7")) {
                        tempStatus[i] = new DataNilai().panggilStatus(nis, daftarKode1[i], new DataNilai().panggilKKM(daftarKode1[i]));
                    } else if (kelas.equals("8")) {
                        tempStatus[i] = new DataNilai().panggilStatus(nis, daftarKode1[i], new DataNilai().panggilKKM(daftarKode1[i]));
                    } else if (kelas.equals("9")) {
                        tempStatus[i] = new DataNilai().panggilStatus(nis, daftarKode1[i], new DataNilai().panggilKKM(daftarKode1[i]));
                    }
                }
                int stat = 1;
                for (int i = 0; i < 10; i++) {
                    if (tempStatus[i] == 4 || tempStatus[i] == 1) {
                        stat = 0;
                    }
                }
                if (stat == 1) {
                    if (kelas.equals("7") || kelas.equals("8")) {
                        out.print("Naik Kelas");
                    } else if (kelas.equals("9")) {
                        out.print("Lulus");    
                    }
                } else if (stat == 0) {
                    if (kelas.equals("7") || kelas.equals("8")) {
                        out.print("Tidak Naik Kelas");
                    } else if (kelas.equals("9")) {
                        out.print("Tidak Lulus");    
                    }
                }
            %>
            </form>
        </div>
    </body>
</html>
