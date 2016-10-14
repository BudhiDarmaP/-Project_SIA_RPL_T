<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIA</title>
        <link href="assets/css/style.css" rel="stylesheet" type="text/css">
    </head>

    <body>
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
        
        <div id="c1"></div>
        <div id="c2"></div>
        <div id="header">
            <a href="index.jsp">
                <img src="assets/images/logo-SIA-300x241.png" style="width: auto;height: 100%">
            </a>
        </div>
                <%! public void status(double akhir) {
                int semester;
                
                if (semester == 2) {
                    if(akhir>)
//                }
            }
        %>
        <div id="form">
            <form action="NIS.jsp">
                NIM :<br>
                Nama :<br>
                Status :<br>
                <input type="submit" value="Kembali">
            </form>
        </div>
    </body>
</html>
