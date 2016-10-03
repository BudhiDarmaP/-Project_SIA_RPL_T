/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.sql.SQLException;

/**
 *
 * @author Lycorice
 */
public class test {
    public static void main(String[] args) throws SQLException {
//        DataSiswa data = new DataSiswa();
        String nis = "16001";
        String idkelas= new DataSiswa().findIdKelas(nis);
        System.out.println(idkelas);
        String kelas=String.valueOf(idkelas.charAt(0)) ;
        System.out.println(kelas);
        String asd="IPS";
//        System.out.println(new );
        if (new DataSiswa().find("16041")){
            System.out.println("ok");
        }
        else System.out.println("bad");
    }
}
