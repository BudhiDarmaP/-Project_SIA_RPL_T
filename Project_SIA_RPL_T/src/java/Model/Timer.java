package Model;

import java.util.Date;
import java.text.SimpleDateFormat;


public class Timer {
    private String waktuSekarang;
    
    public String getWaktuSekarang() {
        return waktuSekarang;
    }

    public void setWaktuSekarang(String waktuSekarang) {
        this.waktuSekarang = waktuSekarang;
    }

    public void waktuSekarang() {
        Date tanggal = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        tanggal.toString();
        setWaktuSekarang(String.valueOf(sdf.format(tanggal)));
    }
}
