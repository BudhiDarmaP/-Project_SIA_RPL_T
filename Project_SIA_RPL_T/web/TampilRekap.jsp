<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>SIA</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
            <br>
            Nama &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
        <br> NIS &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
        <br> Lihat Nilai : <br>
        <form action="Sem1.jsp"> <input type="submit" value="Semester 1" name="Sem1"> </form>
        <form action="Sem2.jsp"> <input type="submit" value="Semester 2" name="Sem2"> </form>
        <form action="LoginCheck" id="form-find-nim-insert"> 
            --STATUS--
        </form>
        </div>
    </body>
</html>
