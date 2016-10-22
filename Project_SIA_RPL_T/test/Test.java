
import Servlet.DataNilai;
import Servlet.DataSiswa;
import static java.lang.System.out;
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
//        int data = new DataNilai().panggilStatusPerMapel("16001", "9IPA", 75);
//        if (data == 3) {
//            System.out.println("Lulus");
//        }
//        if (data == 4) {
//            System.out.println("Tidak Lulus");
//        } else if (data == 2) {
//            System.out.println("Naik Kelas");
//        }
//        else if (data == 1) {
//            System.out.println("Tidak Naik Kelas");
//        }
//        else if (data == 0) {
//            System.out.println("-");
//        }

        String[] daftarMataPelajaran = {
            "Ilmu Pengetahuan Alam", "Ilmu Pengetahuan Sosial",
            "Matematika", "Agama dan Budi Pekerti",
            "Bahasa Indonesia", "Bahasa Inggris",
            "Pancasila & Kewarganegaraan", "Pendidikan Jasmani & Kesehatan",
            "Prakarya", "Seni Budaya"
        };
        String[] daftarKode1 = {
            "7IPA", "7IPS", "7MTK", "7AGM", "7IND", "7ING", "7KWN", "7PJO", "7PRK", "7SEN"
        };
        String[] daftarKode2 = {
            "8IPA", "8IPS", "8MTK", "8AGM", "8IND", "8ING", "8KWN", "8PJO", "8PRK", "8SEN"
        };
        String[] daftarKode3 = {
            "9IPA", "9IPS", "9MTK", "9AGM", "9IND", "9ING", "9KWN", "9PJO", "9PRK", "9SEN"
        };

        String nis = "16001";

        String idkelas = new DataSiswa().findIdKelas(nis);
        int kelas = Integer.parseInt(String.valueOf(idkelas.charAt(0)));
        String[] daftarKelas = new String[daftarMataPelajaran.length];
        if ((kelas - 1) == 7) {
            for (int i = 0; i < daftarKelas.length; i++) {
                daftarKelas[i] = daftarKode1[i];
            }
        } else if (kelas == 9 && new DataNilai().checkTabelIsEmpty(nis)) {
            for (int i = 0; i < daftarKelas.length; i++) {
                daftarKelas[i] = daftarKode2[i];
            }
        } else if (kelas == 9 && !new DataNilai().checkTabelIsEmpty(nis)) {
            for (int i = 0; i < daftarKelas.length; i++) {
                daftarKelas[i] = daftarKode3[i];
            }
        }
        int[] tempStatus = new int[10];
        for (int i = 0; i < 10; i++) {
            if ((kelas - 1) == 7) {
                tempStatus[i] = new DataNilai().panggilStatusPerMapel(nis, daftarKode1[i], new DataNilai().panggilKKM(daftarKode1[i]));
            } else if (kelas == 9 && new DataNilai().checkTabelIsEmpty(nis)) {
                tempStatus[i] = new DataNilai().panggilStatusPerMapel(nis, daftarKode2[i], new DataNilai().panggilKKM(daftarKode2[i]));
            } else if (kelas == 9 && !new DataNilai().checkTabelIsEmpty(nis)) {
                tempStatus[i] = new DataNilai().panggilStatusPerMapel(nis, daftarKode3[i], new DataNilai().panggilKKM(daftarKode2[i]));
            }
        }
        int stat = new DataNilai().checkStatus(tempStatus);
        if (stat == 1) {
            System.out.println("a");
            if (kelas == 7 || kelas == 8 && new DataNilai().checkTabelIsEmpty(nis)) {
                System.out.println("b");
                System.out.print("Naik Kelas");
            } else if (kelas == 9 && !new DataNilai().checkTabelIsEmpty(nis)) {
                System.out.println("c");
                System.out.print("Lulus");
            }
        } else if (stat == 0) {
            System.out.println("g");
            if ((kelas - 1) == 7 || ((kelas - 1) == 8 && new DataNilai().checkTabelIsEmpty(nis))) {
                System.out.print("Tidak Naik Kelas");
            } else if (kelas == 9 && !new DataNilai().checkTabelIsEmpty(nis)) {
                System.out.print("Tidak Lulus");
            }
        }
    }
}
