package id.sch.smktelkom_mlg.project2.xirpl305091429.pintarfisikasmasmk.model;

import java.io.Serializable;

/**
 * Created by Ifan on 30/03/2017.
 */
public class Kelas10 implements Serializable{
    public String judul;
    public String deskripsi;
    public String kelas10;
    public String foto;

    public Kelas10(String judul,String deskripsi,String kelas10, String foto)
    {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.kelas10 = kelas10;
        this.foto = foto;
    }
}
