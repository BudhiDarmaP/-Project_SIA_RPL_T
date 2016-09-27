<%-- 
    Document   : Data_Awal
    Created on : Sep 27, 2016, 11:39:34 PM
    Author     : Lycorice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            <form action="Lihat.jsp">
                Nama : <br>
                Semester : <br> 
                Nilai Tugas : <br>
                Nilai Harian : <br>
                Nilai UTS : <br>
                Nilai UAS : <br>
                <input type="submit" value="Hitung Nilai Akhir">
            </form>
        </div>
    </body>
</html>
