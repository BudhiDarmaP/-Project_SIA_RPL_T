
import Servlet.DataNilai;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author budhidarmap
 */
public class Test {

    public static void main(String[] args) throws SQLException {
        int data = new DataNilai().panggilStatus("16001", "9IPA", 75);
        if (data == 3) {
            System.out.println("Lulus");
        }
        if (data == 4) {
            System.out.println("Tidak Lulus");
        } else if (data == 2) {
            System.out.println("Naik Kelas");
        }
        else if (data == 1) {
            System.out.println("Tidak Naik Kelas");
        }
        else if (data == 0) {
            System.out.println("-");
        }
    }
}
