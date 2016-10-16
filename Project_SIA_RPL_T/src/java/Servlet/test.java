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
//        System.out.println(new CheckInputNilai().ChedckNilai("a,a", "100.00", "10.10", "1.1"));
        new DataNilai().hitungNilaiSemester("16001", "7IPA", 1, 88, 88, 88, 10);
    }
}
