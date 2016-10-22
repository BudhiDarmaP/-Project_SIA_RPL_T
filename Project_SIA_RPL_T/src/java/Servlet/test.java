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

    public static void main(String[] args) throws SQLException, Exception {
//        if (new DataNilai().checkTabelIsEmpty("16001")){
//            System.out.println("ya");
//        }
//        else System.out.println("a");
        new DataSiswa().updateKelas("16001", "6A");
//        System.out.println(new DataNilai().checkSemester("16001", 1, "7"));
    }
}
