package id.sch.smktelkom_mlg.project2.xirpl305091429.pintarfisikasmasmk.model;

import java.io.Serializable;

/**
 * Created by Ifan on 07/04/2017.
 */
public class Kelas12 implements Serializable {
    public String judul;
    public String deskripsi;
    public String kelas12;
    public String foto;

    public Kelas12(String judul, String deskripsi, String kelas12, String foto)
    {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.kelas12 = kelas12;
        this.foto = foto;
    }
}
