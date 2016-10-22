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
<!--            <br> Lihat Nilai : <br>-->
<!--            <form action="Sem1.jsp"> 
                <input type="hidden" name="nis" value="<%=nis%>">
                <input type="hidden" name="semester" value="1">
                <input type="submit" value="Semester 1" name="Sem1">
            </form>
            <form action="Sem2.jsp">
                <input type="hidden" name="nis" value="<%=nis%>">
                <input type="hidden" name="semester" value="2">
                <input type="submit" value="Semester 2" name="Sem2">
            </form>-->
            <form action="menu.jsp" > 
            <table border="1" style="text-align: left;background-color: white;">
                        <tr>
                            <th rowspan="2" style="text-align: center">Mata Pelajaran</th>
                            <th colspan="5" style="text-align: center">Semester 1</th>
                            <th colspan="5" style="text-align: center">Semester 2</th>
                            <th rowspan="2" style="text-align: center">Nilai Akhir</th>
                        </tr>
                        <tr>
                            <th style="text-align: center">Nilai Tugas</th>
                            <th style="text-align: center">Nilai Harian</th>
                            <th style="text-align: center">Nilai UTS</th>
                            <th style="text-align: center">Nilai UAS</th>
                            <th style="text-align: center">Nilai Semester</th>
                            <th style="text-align: center">Nilai Tugas</th>
                            <th style="text-align: center">Nilai Harian</th>
                            <th style="text-align: center">Nilai UTS</th>
                            <th style="text-align: center">Nilai UAS</th>
                            <th style="text-align: center">Nilai Semester</th>
                        </tr>
                        <%
                            String[] daftarMataPelajaran = {
                                "Ilmu Pengetahuan Alam", "Ilmu Pengetahuan Sosial",
                                "Matematika", "Agama dan Budi Pekerti",
                                "Bahasa Indonesia", "Bahasa Inggris",
                                "Pancasila & Kewarganegaraan", "Pendidikan Jasmani & Kesehatan",
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
                            int kelas = Integer.parseInt(String.valueOf(idkelas.charAt(0)));
                            String[] daftarKelas = new String[daftarMataPelajaran.length];
                            if ((kelas-1)==7) {
                                for (int i = 0; i < daftarKelas.length; i++) {
                                    daftarKelas[i] = daftarKode1[i];
                                }
                            } else if (kelas==9&&new DataNilai().checkTabelIsEmpty(nis)) {
                                for (int i = 0; i < daftarKelas.length; i++) {
                                    daftarKelas[i] = daftarKode2[i];
                                }
                            } else if (kelas==9&&!new DataNilai().checkTabelIsEmpty(nis)) {
                                for (int i = 0; i < daftarKelas.length; i++) {
                                    daftarKelas[i] = daftarKode3[i];
                                }
                            }
                            ArrayList<Nilai> nilaiList = new DataNilai().cariNilai2(nis);
                            double nilai0 = 0, nilai1 = 0, nilai2 = 0, nilai3 = 0, nilai4=0,
                                    nilai5 = 0, nilai6 = 0, nilai7 = 0, nilai8 = 0, nilai9=0, nilai10=0;
                            for (int i = 0; i < daftarMataPelajaran.length; i++) {
                                for (Nilai nilai : nilaiList) {
                                    if (nilai.getKode().equals(daftarKelas[i]) && nilai.getSemester() == 1) {
                                        nilai0 = nilai.getNilaiTugas();
                                        nilai1 = nilai.getNilaiHarian();
                                        nilai2 = nilai.getNilaiUts();
                                        nilai3 = nilai.getNilaiUas();
                                        nilai4 = nilai.getNilaiSemester();
                                    }
                                    if (nilai.getKode().equals(daftarKelas[i]) && nilai.getSemester() == 2) {
                                        nilai5 = nilai.getNilaiTugas();
                                        nilai6 = nilai.getNilaiHarian();
                                        nilai7 = nilai.getNilaiUts();
                                        nilai8 = nilai.getNilaiUas();
                                        nilai9 = nilai.getNilaiSemester();
                                        nilai10 = nilai.getNilaiAkhir();
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
                                        + "</td>"
                                        + "<td>"
                                        + nilai5
                                        + "</td>"
                                        + "<td>"
                                        + nilai6
                                        + "</td>"
                                        + "<td>"
                                        + nilai7
                                        + "</td>"
                                        + "<td>"
                                        + nilai8
                                        + "</td>"
                                        + "<td>"
                                        + nilai9
                                        + "</td>"
                                        + "<td>"
                                        + nilai10
                                        + "</td>"
                                        + "");
                            }
                            
                        %>
                    </table>
                    <table align="center">                 
                        <tr>
                    <%
                out.print("Status:");
                            
                int[] tempStatus = new int[10];
                for (int i = 0; i < 10; i++) {
                    if ((kelas-1)==7) {
                        tempStatus[i] = new DataNilai().panggilStatusPerMapel(nis, daftarKode1[i], new DataNilai().panggilKKM(daftarKode1[i]));
                    } else if (kelas==9&&new DataNilai().checkTabelIsEmpty(nis)) {
                        tempStatus[i] = new DataNilai().panggilStatusPerMapel(nis, daftarKode2[i], new DataNilai().panggilKKM(daftarKode2[i]));
                    } else if (kelas==9&&!new DataNilai().checkTabelIsEmpty(nis)) {
                        tempStatus[i] = new DataNilai().panggilStatusPerMapel(nis, daftarKode3[i], new DataNilai().panggilKKM(daftarKode2[i]));
                    }
                }
                int stat=new DataNilai().checkStatus(tempStatus);
                if (stat == 1) {
                    if ((kelas-1)==7 || ((kelas-1)==8&&new DataNilai().checkTabelIsEmpty(nis))) {
                        out.print("Naik Kelas");
                    } else if (kelas==9&&!new DataNilai().checkTabelIsEmpty(nis)) {
                        out.print("Lulus");    
                    }
                } else if (stat == 0) {
                    if ((kelas-1)==7 || ((kelas-1)==8&&new DataNilai().checkTabelIsEmpty(nis))) {
                        out.print("Tidak Naik Kelas");
                    } else if (kelas==9&&!new DataNilai().checkTabelIsEmpty(nis)) {
                        out.print("Tidak Lulus");    
                    }
                }
            %>
                        </tr>
                        <tr style=""><th>
            <input type="submit" value="Back">
                            </th>
                        </tr>
                    </table>
            </form>
        </div>
    </body>
</html>
