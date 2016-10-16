/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.Nilai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lycorice
 */
public class DataNilai {

    Connection connection = null;
    DatabaseConnection database = new DatabaseConnection();

    public ArrayList<Nilai> list() throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Nilai> nilaiList = new ArrayList<Nilai>();
        try {
            connection = database.getConnection();
            statement = connection.prepareStatement("select * from nilai"
                    //                    + "where alamat is not null and tempat_tanggal_lahir is not null;"
                    + "");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Nilai nilai = new Nilai();
                nilai.setSemester(Integer.parseInt(resultSet.getString("semester")));
                nilai.setNilaiTugas(Double.parseDouble(resultSet.getString("nilai_tugas")));
                nilai.setNilaiHarian(Double.parseDouble(resultSet.getString("nilai_harian")));
                nilai.setNilaiUts(Double.parseDouble(resultSet.getString("nilai_uts")));
                nilai.setNilaiUas(Double.parseDouble(resultSet.getString("nilai_uas")));
                nilai.setNilaiSemester(Double.parseDouble(resultSet.getString("nilai_semester")));
                nilai.setNilaiAkhir(Double.parseDouble(resultSet.getString("nilai_akhir")));
                nilai.setNis(resultSet.getString("nis"));
                nilai.setKode(resultSet.getString("kode"));
                nilaiList.add(nilai);
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
        return nilaiList;
    }

    public void inputNilai(int semester, double nilaiTugas, double nilaiHarian,
            double nilaiUts, double nilaiUas, String nis, String idKelas) throws SQLException, Exception {
        connection = database.getConnection();
        PreparedStatement statement = connection.prepareStatement(""
                + "insert into NILAI(semester, nilai_tugas, nilai_harian, "
                + "nilai_UTS, nilai_UAS, NIS, KODE) "
                + "values (?,?,?,?,?,?,?)"
        );
        statement.setString(1, String.valueOf(semester));
        try {
            double iNilaiTugas = nilaiTugas;
            double iNilaiHarian = nilaiHarian;
            double iNilaiUts = nilaiUts;
            double iNilaiUas = nilaiUas;
            statement.setString(2, String.valueOf(iNilaiTugas));
            statement.setString(3, String.valueOf(iNilaiHarian));
            statement.setString(4, String.valueOf(iNilaiUts));
            statement.setString(5, String.valueOf(iNilaiUas));
        } catch (NumberFormatException ex) {
            throw new Exception("awal.jsp?error=1");
        }
        statement.setString(6, nis);
        statement.setString(7, idKelas);
        ResultSet resultSet = statement.executeQuery();
    }

    public double cariNilai(String nis, String kode, int index) throws SQLException {
        for (Nilai nilai : new DataNilai().list()) {
            if (nilai.getNis().equals(nis) && nilai.getKode().equals(kode)) {
                if (index == 0) {
                    return nilai.getNilaiTugas();
                } else if (index == 1) {
                    return nilai.getNilaiHarian();
                } else if (index == 2) {
                    return nilai.getNilaiUts();
                } else if (index == 3) {
                    return nilai.getNilaiUas();
                }
            }
        }
        return 0;
    }

    public ArrayList<Nilai> cariNilai2(String nis) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Nilai> nilaiList = new ArrayList<Nilai>();
        try {
            connection = database.getConnection();
            statement = connection.prepareStatement("select * from nilai "
                    + "where nis = " + nis
                    + "");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Nilai nilai = new Nilai();
                nilai.setSemester(Integer.parseInt(resultSet.getString("semester")));
                nilai.setNilaiTugas(Double.parseDouble(resultSet.getString("nilai_tugas")));
                nilai.setNilaiHarian(Double.parseDouble(resultSet.getString("nilai_harian")));
                nilai.setNilaiUts(Double.parseDouble(resultSet.getString("nilai_uts")));
                nilai.setNilaiUas(Double.parseDouble(resultSet.getString("nilai_uas")));
                nilai.setNilaiSemester(Double.parseDouble(resultSet.getString("nilai_semester")));
                nilai.setNilaiAkhir(Double.parseDouble(resultSet.getString("nilai_akhir")));
                nilai.setNis(resultSet.getString("nis"));
                nilai.setKode(resultSet.getString("kode"));
                nilaiList.add(nilai);
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
        return nilaiList;
    }

    public int checkSemester(String nis, int semester) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Nilai> nilaiList = new ArrayList<Nilai>();
        try {
            connection = database.getConnection();
            statement = connection.prepareStatement("select * from nilai "
                    + "where nis = " + nis
                    + "");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Nilai nilai = new Nilai();
                nilai.setSemester(Integer.parseInt(resultSet.getString("semester")));
                nilai.setNilaiTugas(Double.parseDouble(resultSet.getString("nilai_tugas")));
                nilai.setNilaiHarian(Double.parseDouble(resultSet.getString("nilai_harian")));
                nilai.setNilaiUts(Double.parseDouble(resultSet.getString("nilai_uts")));
                nilai.setNilaiUas(Double.parseDouble(resultSet.getString("nilai_uas")));
                nilai.setNilaiSemester(Double.parseDouble(resultSet.getString("nilai_semester")));
                nilai.setNilaiAkhir(Double.parseDouble(resultSet.getString("nilai_akhir")));
                nilai.setNis(resultSet.getString("nis"));
                nilai.setKode(resultSet.getString("kode"));
                nilaiList.add(nilai);
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
        if (nilaiList.isEmpty() && semester == 1) {
            return 1;
        }
        for (Nilai nilai : nilaiList) {
            if (nilai.getNis().equals(nis)) {
                if (nilai.getSemester() == 1 && semester == 1) {
                    return 2;
                } else if (nilai.getSemester() == 1 && semester == 2) {
                    return 1;
                } else if (nilai.getSemester() == 2 && semester == 1) {
                    return 2;
                } else if (nilai.getSemester() == 2 && semester == 2) {
                    return 2;
                }
            }
        }
        return 0;
    }

    public void hitungNilaiSemester(String nis, String kode, int semester,
            double nilaiTugas, double nilaiHarian, double nilaiUTS, double nilaiUAS) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = database.getConnection();
            double nilaiSemester = ((0.1 * nilaiTugas)
                    + (0.2 * nilaiHarian)
                    + (0.3 * nilaiUTS)
                    + (0.4 * nilaiUAS));
            System.out.println("a");
//        statement = connection.prepareStatement("update nilai set nilai_semester= " + String.valueOf(nilaiSemester)
//                + " where kode =" + kode + " and nis =" + nis + " and semester ="+String.valueOf(semester));
            statement = connection.prepareStatement("update nilai set NILAI_SEMESTER =" + nilaiSemester + ""
                    + " where nis='" + nis + "' and semester=" + String.valueOf(semester) + " and kode='" + kode + "'");
            System.out.println("b");
            resultSet = statement.executeQuery();
            System.out.println("c");
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
    }
}
