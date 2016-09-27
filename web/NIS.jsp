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
                <br>
            </a>
        </div>
        <div id="form">
        
        <% //if(nis==){%>
            Silahkan Pilih :
            <form action="Input.jsp">
                <input type="submit" value="Input"> <br> </form>
            <form action="Data_Awal.jsp">
                <input type="submit" value="Lihat Nilai"> </form>
            <form action="Status.jsp">
                <input type="submit" value="Lihat Status"> </form>
            
            <% //    }
//            else{%>
            Maaf, NIS yang anda masukkan tidak ditemukan
            <form action="Awal.html">
                <input type="submit" value="Back"> </form>
            <% //}%>
        </div>
    </body>
</html>
