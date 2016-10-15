<%@page import="Servlet.DatabaseConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="Model.Siswa"%>
<%@page import="Servlet.DataSiswa"%>
<%@page import="Servlet.DataNilai"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <form action="DataNilai" method="POST">
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
                    
                <%--<%!--%>  public void status(double akhir) {
                <!--int semester;-->
                <!--if (semester == 2) {-->
                    <!--if(akhir>)-->
<!--//                }-->
            <!--}-->
        <!--%>-->
        
    </body>
</html>
