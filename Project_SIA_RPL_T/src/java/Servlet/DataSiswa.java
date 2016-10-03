package Servlet;

import Model.Siswa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lycorice
 */
public class DataSiswa {

    Connection connection = null;

    DatabaseConnection database = new DatabaseConnection();

    public ArrayList<Siswa> list() throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Siswa> siswaList = new ArrayList<Siswa>();
        try {
            connection = database.getConnection();
            statement = connection.prepareStatement("select nis, nama, tempat_tanggal_lahir,"
                    + "alamat, id_kelas from siswa"
                    //                    + "where alamat is not null and tempat_tanggal_lahir is not null;"
                    + "");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Siswa siswa = new Siswa();
                siswa.setNis(resultSet.getString("nis"));
                siswa.setNama(resultSet.getString("nama"));
                siswa.setTempatTanggalLahir(resultSet.getString("tempat_tanggal_lahir"));
                siswa.setAlamat(resultSet.getString("alamat"));
                siswa.setIdKelas(resultSet.getString("id_kelas"));
                siswaList.add(siswa);
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
        return siswaList;
    }

    public boolean find(String key) throws SQLException {
        connection = database.getConnection();
//        PreparedStatement statement = connection.prepareStatement("select nis from siswa");
//        ResultSet resultSet = statement.executeQuery();
        
        for (Siswa siswa : new DataSiswa().list()) {
            if (siswa.getNis().equals(key)) {
                return true;
            }
//            else return false;
        }
        return false;
    }
    
    public String findNama(String key) throws SQLException{
        connection = database.getConnection();
//        PreparedStatement statement = connection.prepareStatement("select nis,nama from siswa");
//        ResultSet resultSet = statement.executeQuery();
        String hasil;
        for (Siswa siswa : new DataSiswa().list()) {
            if (siswa.getNis().equals(key)) {
                return siswa.getNama();
            }
        }
        return key;
    }
    
    public String findIdKelas(String key) throws SQLException{
        connection = database.getConnection();
//        PreparedStatement statement = connection.prepareStatement("select nis,id_kelas from siswa where nis = "+key);
//        ResultSet resultSet = statement.executeQuery();
        String hasil;
        for (Siswa siswa : new DataSiswa().list()) {
            if (siswa.getNis().equals(key)) {
                return siswa.getIdKelas();
            }
        }
        return key;
    }
    
    
}
