<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIA</title>
        <link href="assets/css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div id="c1"></div>
        <div id="c2"></div>
        <div id="header">
            <a href="index.jsp">
                <img src="assets/images/logo-SIA-300x241.png" style="width: auto;height: 100%">
            </a>
        </div>
        <div id="form">
            <form action="NIS.jsp">
                <table border="0">
                    <tbody>
                        <tr>
                            <th>Nama</th>
                            <td><input type="text" name="nama" value=""></td>
                        </tr>
                        <tr>
                            <th>Kode</th>
                            <td><input type="text" name="kode" value=""></td>
                        </tr>
                        <tr>
                            <th>Semester</th>
                            <td><input type="text" name="semester" value=""></td>
                        </tr>
                        <tr>
                            <th>Nilai Tugas</th>
                            <td><input type="text" name="nilai_tugas" value=""></td>
                        </tr>
                        <tr>
                            <th>Nilai Harian</th>
                            <td><input type="text" name="nilai_harian" value=""></td>
                        </tr>
                        <tr>
                            <th>Nilai UTS</th>
                            <td><input type="text" name="nilai_uts" value=""></td>
                        </tr>
                        <tr>
                            <th>Nilai UAS</th>
                            <td><input type="text" name="nilai_uas" value=""></td>
                        </tr>
                    </tbody>
                </table>
                <input type="submit" value="Simpan">
            </form>

            <%! public double nilai_semester(double tugas, double harian, double uts, double uas) {
                    return ((0.1 * tugas) + (0.2 * harian) + (0.3 * uts) + (0.4 * uas));
                }
            %>

            <%! public double nilai_akhir(double akhir1, double akhir2) {
                    return (akhir1 + akhir2) / 2;
                }
            %>

            <% String jdbcURL = null;
                String username = null;
                String password = null;

                Connection conn = null;
                try {
                    jdbcURL = "jdbc:oracle:thin:@172.23.9.185:1521:orcl";
                    username = "145314063";
                    password = "FUCKde96";
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    conn = DriverManager.getConnection(jdbcURL, username, password);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }%>
        </div>
    </body>
</html>
