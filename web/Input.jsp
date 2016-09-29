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
                Nama : <input type="text" name="nama" value=""><br>
                Kode : <input type="text" name="kode" value=""><br>
                Semester : <input type="text" name="semester" value=""><br> 
                Nilai Tugas : <input type="text" name="nilai_tugas" value=""><br>
                Nilai Harian : <input type="text" name="nilai_harian" value=""><br>
                Nilai UTS : <input type="text" name="nilai_uts" value=""><br>
                Nilai UAS : <input type="text" name="nilai_uas" value=""><br>
            <input type="submit" value="Simpan">
            </form>
            
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
                } %>
        </div>
    </body>
</html>
