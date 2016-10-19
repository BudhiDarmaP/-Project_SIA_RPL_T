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
                Memasukkan Nilai Siswa
                <form action="awal.jsp">
                    <br>
                    <input type="submit" value="Nilai Siswa">
                </form>
                ------------------------------------------------------
                <br>
                Melihat Rekap Siswa
                <form action="awal2.jsp">
                    <br>
                    <input type="submit" value="Rekap Siswa">
                </form>
            </div>
        </div>
    </body>
</html>
