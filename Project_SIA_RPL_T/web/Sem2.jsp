<%@page import="java.sql.Connection"%>
<%@page import="Servlet.DatabaseConnection"%>
<%@page import="Model.Nilai"%>
<%@page import="Servlet.DataNilai"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Servlet.DataSiswa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>SIA</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="assets/css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%
            DatabaseConnection database = new DatabaseConnection();
            Connection connection = database.getConnection();
            String nis = request.getParameter("nis");
            String semester = "2";

        %>
        <div id="c1"></div>
        <div id="c2"></div>
        <div id="header">
            <a href="index.jsp">
                <img src="assets/images/logo-SIA-300x241.png" style="width: auto;height: 100%">
            </a>
        </div>
        <div id="form">
            <div id="form-insert-score">
                <form action="TampilRekap.jsp">
                    <table style="text-align: left; ">
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
                        <tr>
                            <th>Semester</th>
                            <td>: </td>
                            <td><%=semester%></td>
                        </tr>
                    </table>
                    Data siswa
                    <table border="1" style="text-align: left;background-color: white;">
                        <tr>
                            <th>Mata Pelajaran</th>
                            <th>Nilai Tugas</th>
                            <th>Nilai Harian</th>
                            <th>Nilai UTS</th>
                            <th>Nilai UAS</th>
                            <th>Nilai Akhir</th>
                        </tr>
                        <%
                                String[] daftarMataPelajaran = {
                                    "Ilmu Pengetahuan Alam", "Ilmu Pengetahuan Sosial",
                                    "Matematika", "Agama dan Budi Pekerti",
                                    "Bahasa Indonesia", "Bahasa Inggris",
                                    "Pancasila dan Kewarganegaraan", "Pendidikan Jasmani dan Kesehatan",
                                    "Prakarya", "Seni Budaya"
                                };
                                String[] daftarKode1 = {
                                    "7IPA", "7IPS", "7MTK", "7AGM", "7IND", "7ING", "7KWN", "7PJO", "7PRK", "7SEN"
                                };
                                String[] daftarKode2 = {
                                    "8IPA", "8IPS", "8MTK", "8AGM", "8IND", "8ING", "8KWN", "8PJO", "8PRK", "8SEN"
                                };
                                String[] daftarKode3 = {
                                    "9IPA", "9IPS", "9MTK", "9AGM", "9IND", "9ING", "9KWN", "9PJO", "9PRK", "9SEN"
                                };
                                String idkelas = new DataSiswa().findIdKelas(nis);
                                String kelas = String.valueOf(idkelas.charAt(0));
                                String[] daftarKelas = new String[daftarMataPelajaran.length];
                                if (kelas.equals("7")) {
                                    for (int i = 0; i < daftarKelas.length; i++) {
                                        daftarKelas[i] = daftarKode1[i];
                                    }
                                } else if (kelas.equals("8")) {
                                    for (int i = 0; i < daftarKelas.length; i++) {
                                        daftarKelas[i] = daftarKode2[i];
                                    }
                                } else if (kelas.equals("9")) {
                                    for (int i = 0; i < daftarKelas.length; i++) {
                                        daftarKelas[i] = daftarKode3[i];
                                    }
                                }
                                ArrayList<Nilai> nilaiList = new DataNilai().cariNilai2(nis);
                                double nilai0 = 0, nilai1 = 0, nilai2 = 0, nilai3 = 0, nilai4 = 0;
                                for (int i = 0; i < daftarMataPelajaran.length; i++) {
                                    for (Nilai nilai : nilaiList) {
                                        if (nilai.getKode().equals(daftarKelas[i]) && nilai.getSemester() == Integer.parseInt(semester)) {
                                            nilai0 = nilai.getNilaiTugas();
                                            nilai1 = nilai.getNilaiHarian();
                                            nilai2 = nilai.getNilaiUts();
                                            nilai3 = nilai.getNilaiUas();
                                            nilai4 = nilai.getNilaiAkhir();
                                        }
                                    }
                                    out.print(""
                                            + "<tr>"
                                            + "<th>"
                                            + daftarMataPelajaran[i]
                                            + "</th>"
                                            + "<td>"
                                            + nilai0
                                            + "</td>"
                                            + "<td>"
                                            + nilai1
                                            + "</td>"
                                            + "<td>"
                                            + nilai2
                                            + "</td>"
                                            + "<td>"
                                            + nilai3
                                            + "</td>"
                                            + "<td>"
                                            + nilai4
                                            + "</td>");
                                }
                        %>
                    </table>
                    <input type="hidden" name="nis" value="<%=nis%>">
                    <input type="submit" value="Back">
                </form>
            </div>
        </div>
    </body> 
</html>
