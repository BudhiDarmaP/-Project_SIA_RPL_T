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
        System.out.println(new DataNilai().checkSemester("16063"));
        System.out.println(new CheckInputNilai().CheckTandaBaca("a,a"));
        if (new CheckInputNilai().CheckTypeDataInteger("1.1")) {
            System.out.println("a");
        }
        else System.out.println("b");
    }
}
