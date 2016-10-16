<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--<!DOCTYPE html>-->
<%String error = request.getParameter("error");%>
<html>
    <head>
        <title>SIA</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="assets/css/style.css" rel="stylesheet" type="text/css">
        <script type="text/javascript">
            <% if ("1".equals(error)) {%>
            alert("NIS yang anda masukkan salah");
            <%}%>
        </script>
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
            <br>
            <form action="LoginCheck" id="form-find-nim-insert" method="GET"> 
                <br>
                Silahkan Masukkan NIS : 
                <br>
                <input type="text" name="nis" value="" size="5">
                <input type="submit" value="Cari"> 
                <p></p> 
            </form>
        </div>
    </body>
</html>
