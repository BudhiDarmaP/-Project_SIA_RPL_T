<%@page import="Model.Timer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String error = request.getParameter("error");%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIA</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="assets/css/style.css" rel="stylesheet" type="text/css">
        <script>//
//            <% if ("1".equals(error)) {%>
//            alert("Maaf, nilai anda belum dapat diakses sekarang!");
//            <%}%>
//        </script>
    </head>
    <body>
        <div id="c1"></div>
        <div id="c2"></div>
        <div id="header">
            <a href="index.jsp">
                <img src="assets/images/logo-SIA-300x241.png" style="width: auto;height: 100%">
                <br>
            </a>
        </div>
        <div id="form">
            <div id="form-menu">
                <br>
                <p style="font-size: 25; font-family: britanic; font-style: bold">
                    Memasukkan Nilai Siswa</p>
                <form action="awal.jsp">
                    <br>
                    <input type="submit" value="Nilai Siswa" 
                           style="font-size: 20; font-family: britanic; font-style: bold">
                </form>
                ------------------------------------------------------
                <br>
                <p style="font-size: 25; font-family: britanic; font-style: bold">                
                    Melihat Rekap Siswa</p>
                <form action="awal2.jsp">
                    <br>
                    <input type="submit" value="Rekap Siswa" 
                           style="font-size: 20; font-family: britanic; font-style: bold">
                </form>
            </div>
        </div>
    </body>
</html>
