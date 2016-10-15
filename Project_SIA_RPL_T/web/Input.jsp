<%@page import="Servlet.DatabaseConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="Model.Siswa"%>
<%@page import="Servlet.DataSiswa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String error = request.getParameter("error");%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIA</title>
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
        <div id="form">
            <div id="form-insert-score">
                <form action="InputNilai" method="POST">
                    <table style="text-align: left; ">
                        <tr>
                            <th>
                                NIS
                            </th>
                            <td>
                                : 
                            </td>
                            <td>
                                <%//panggil NIS
                                out.print(nis);
                                %>
                                <input type="hidden" name="nis" value="<%=nis%>">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Nama Siswa
                            </th>
                            <td>
                                : 
                            </td>
                            <td>
                                <%//panggil nama siswa
                                out.print(new DataSiswa().findNama(nis));
                                %>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Semester
                            </th>
                            <td>
                                : 
                            </td>
                            <td>
                                <select name="semester">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                </select>
                            </td>
                        </tr>
                    </table>
                    <br>
                    Masukan Data siswa
                    <table border="1" style="text-align: left;background-color: white;">
                        <tr>
                            <th>Mata Pelajaran</th>
                            <th>Nilai Tugas</th>
                            <th>Nilai Harian</th>
                            <th>Nilai UTS</th>
                            <th>Nilai UAS</th>
                        </tr>
                        <tr>
                            <th>
                                Ilmu Pengetahuan Alam
                            </th>
                            <td>
                                <input type="text" name="a1" value="">
                            </td>
                            <td>
                                <input type="text" name="a2" value="">
                            </td>
                            <td>
                                <input type="text" name="a3" value="">
                            </td>
                            <td>
                                <input type="text" name="a4" value="">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Ilmu Pengetahuan Sosial
                            </th>
                            <td>
                                <input type="text" name="b1" value="">
                            </td>
                            <td>
                                <input type="text" name="b2" value="">
                            </td>
                            <td>
                                <input type="text" name="b3" value="">
                            </td>
                            <td>
                                <input type="text" name="b4" value="">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Matematika
                            </th>
                            <td>
                                <input type="text" name="c1" value="">
                            </td>
                            <td>
                                <input type="text" name="c2" value="">
                            </td>
                            <td>
                                <input type="text" name="c3" value="">
                            </td>
                            <td>
                                <input type="text" name="c4" value="">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Agama dan Budi Pekerti
                            </th>
                            <td>
                                <input type="text" name="d1" value="">
                            </td>
                            <td>
                                <input type="text" name="d2" value="">
                            </td>
                            <td>
                                <input type="text" name="d3" value="">
                            </td>
                            <td>
                                <input type="text" name="d4" value="">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Bahasa Indonesia
                            </th>
                            <td>
                                <input type="text" name="e1" value="">
                            </td>
                            <td>
                                <input type="text" name="e2" value="">
                            </td>
                            <td>
                                <input type="text" name="e3" value="">
                            </td>
                            <td>
                                <input type="text" name="e4" value="">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Bahasa Inggris
                            </th>
                            <td>
                                <input type="text" name="f1" value="">
                            </td>
                            <td>
                                <input type="text" name="f2" value="">
                            </td>
                            <td>
                                <input type="text" name="f3" value="">
                            </td>
                            <td>
                                <input type="text" name="f4" value="">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Pancasila dan Kewarganegaraan
                            </th>
                            <td>
                                <input type="text" name="g1" value="">
                            </td>
                            <td>
                                <input type="text" name="g2" value="">
                            </td>
                            <td>
                                <input type="text" name="g3" value="">
                            </td>
                            <td>
                                <input type="text" name="g4" value="">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Pendidikan Jasmani dan Kesehatan
                            </th>
                            <td>
                                <input type="text" name="h1" value="">
                            </td>
                            <td>
                                <input type="text" name="h2" value="">
                            </td>
                            <td>
                                <input type="text" name="h3" value="">
                            </td>
                            <td>
                                <input type="text" name="h4" value="">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Prakarya
                            </th>
                            <td>
                                <input type="text" name="i1" value="">
                            </td>
                            <td>
                                <input type="text" name="i2" value="">
                            </td>
                            <td>
                                <input type="text" name="i3" value="">
                            </td>
                            <td>
                                <input type="text" name="i4" value="">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Seni Budaya
                            <td>
                                <input type="text" name="j1" value="">
                            </td>
                            <td>
                                <input type="text" name="j2" value="">
                            </td>
                            <td>
                                <input type="text" name="j3" value="">
                            </td>
                            <td>
                                <input type="text" name="j4" value="">
                            </td>
                    </table>
                    <input type="submit" value="Simpan">
                </form>
            </div>

        </div>
    </body>
</html>
