package id.sch.smktelkom_mlg.project2.xirpl305091429.pintarfisikasmasmk.model;

import java.io.Serializable;

/**
 * Created by Ifan on 07/04/2017.
 */
public class Kelas11 implements Serializable{
    public String judul;
    public String deskripsi;
    public String kelas11;
    public String foto;

    public Kelas11(String judul, String deskripsi, String kelas11, String foto)
    {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.kelas11 = kelas11;
        this.foto = foto;
    }
}
