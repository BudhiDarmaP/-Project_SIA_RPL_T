/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.MataPelajaran;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lycorice
 */
public class DataMataPelajaran {
    Connection connection = null;
    DatabaseConnection database = new DatabaseConnection();
    public ArrayList<MataPelajaran> list() throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<MataPelajaran> mataPelajaranList = new ArrayList<MataPelajaran>();
        try {
            connection = database.getConnection();
            statement = connection.prepareStatement("select nis, nama, tempat_tanggal_lahir,"
                    + "alamat, id_kelas from siswa"
                    //                    + "where alamat is not null and tempat_tanggal_lahir is not null;"
                    + "");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                MataPelajaran mataPelajaran = new MataPelajaran();
                mataPelajaran.setKode(resultSet.getString("KODE"));
                mataPelajaran.setNama(resultSet.getString("NAMA"));
                mataPelajaran.setKkm(Double.parseDouble(resultSet.getString("KKM")));
                mataPelajaranList.add(mataPelajaran);
            }
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ignore) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ignore) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignore) {
                }
            }
        }
        return mataPelajaranList;
    }
    
}
