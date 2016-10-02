<%@page import="java.util.ArrayList"%>
<%@page import="Model.Siswa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;
              charset=UTF-8">
        <title>Siswa Page</title>
    </head>
    <body>
        <% ArrayList<Siswa> siswaList = (ArrayList<Siswa>) request.getAttribute("siswaList");
        %><table>
            <% // for (int i = 0; i < siswaList.size(); i++) {%>
            <tr>
                
                <td><% out.println(siswaList.get(1).getNis());%></td>
                <td><% out.println(siswaList.get(1).getNama());%></td>
                <td><% out.println(siswaList.get(1).getAlamat());%></td>
                <td><% out.println(siswaList.get(1).getTempatTanggalLahir());%></td>
            </tr>
            <% // }%>
        </table>        
    </body>
</html>
