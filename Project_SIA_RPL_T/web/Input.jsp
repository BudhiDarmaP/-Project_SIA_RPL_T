<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
            <div id="form-insert-score">
                <form action="NIS.jsp">
                    <table style="text-align: left; ">
                        <tr>
                            <th>
                                NIS
                            </th>
                            <td>
                                : 
                            </td>
                            <td>
                                --Nis siswa--<%//panggil NIS%>
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
                                --Nama siswa--<%//panggil nama siswa%>
                            </td>
                        </tr>
                    </table>
                    <br>
                    Masukkan Data siswa
                    <table border="1" style="text-align: left;background-color: white;">
                        <tr>
                            <th>Mata Pelajaran</th>
                            <th>Nilai Tugas</th>
                            <th>Nilai Harian</th>
                            <th>Nilai UTS</th>
                            <th>Mata UAS</th>
                        </tr>
                        <tr>
                            <th>
                                Ilmu Pengetahuan Alam
                            </th>
                            <td>
                                <select>
                                    <option value="none">pilih</option>
                                    <%
                                        for(int i=0; i<=10;i++){
                                            out.print("<option value=\""+i+"\">"+i+"</option>");
                                        }
                                    %>
                                </select>
                                .
                                <select>
                                    <option value="none">pilih</option>
                                    <%
                                        for(int i=0; i<100;i=i+=5){
                                            out.print("<option value=\""+i+"\">"+i+"</option>");
                                        }
                                    %>
                                </select>
                            </td>
                            <td>
                                <select>
                                    <option value="none">pilih</option>
                                    <%
                                        for(int i=0; i<=10;i++){
                                            out.print("<option value=\""+i+"\">"+i+"</option>");
                                        }
                                    %>
                                </select>
                                .
                                <select>
                                    <option value="none">pilih</option>
                                    <%
                                        for(int i=0; i<100;i=i+=5){
                                            out.print("<option value=\""+i+"\">"+i+"</option>");
                                        }
                                    %>
                                </select>
                            </td>
                            <td>
                                <select>
                                    <option value="none">pilih</option>
                                    <%
                                        for(int i=0; i<=10;i++){
                                            out.print("<option value=\""+i+"\">"+i+"</option>");
                                        }
                                    %>
                                </select>
                                .
                                <select>
                                    <option value="none">pilih</option>
                                    <%
                                        for(int i=0; i<100;i=i+=5){
                                            out.print("<option value=\""+i+"\">"+i+"</option>");
                                        }
                                    %>
                                </select>
                            </td>
                            <td>
                                <select>
                                    <option value="none">pilih</option>
                                    <%
                                        for(int i=0; i<=10;i++){
                                            out.print("<option value=\""+i+"\">"+i+"</option>");
                                        }
                                    %>
                                </select>
                                .
                                <select>
                                    <option value="none">pilih</option>
                                    <%
                                        for(int i=0; i<100;i=i+=5){
                                            out.print("<option value=\""+i+"\">"+i+"</option>");
                                        }
                                    %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            
                        </tr>
                        <tr>
                            
                        </tr>
                        <tr>
                            
                        </tr>
                        <tr>
                            
                        </tr>
                        <tr>
                            
                        </tr>
                        <tr>
                            
                        </tr>
                        <tr>
                            
                        </tr>
                        <tr>
                            
                        </tr>
                    </table>
                    <input type="submit" value="Simpan">
                </form>
            </div>

            <%! public double nilai_semester(double tugas, double harian, double uts, double uas) {
                    return ((0.1 * tugas) + (0.2 * harian) + (0.3 * uts) + (0.4 * uas));
                }
            %>

            <%! public double nilai_akhir(double akhir1, double akhir2) {
                    return (akhir1 + akhir2) / 2;
                }
            %>

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
                }
            //insert into nilai (nilai_tugas, nilai_harian, nilai_uts, nilai_uas, nilai_semester, status_kenaikan, nilai_akhir)
//            value ()%>
        </div>
    </body>
</html>
