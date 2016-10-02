/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.Siswa;
import Servlet.DataInput;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lycorice
 */
public class test {
    public static void main(String[] args) throws SQLException {
        DataSiswa data = new DataSiswa();
        for (Siswa siswa : data.list()){
            System.out.println(siswa.getNis());
            if (siswa.getNis().equals("16042"))System.out.println("ada");
        }
    }
}
