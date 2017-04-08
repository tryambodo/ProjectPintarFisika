package id.sch.smktelkom_mlg.project2.xirpl305091429.pintarfisikasmasmk;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project2.xirpl305091429.pintarfisikasmasmk.adapter.Kelas12Adapter;
import id.sch.smktelkom_mlg.project2.xirpl305091429.pintarfisikasmasmk.model.Kelas12;

public class Kelas12Activity extends AppCompatActivity implements Kelas12Adapter.IKelas12Adapter {

    public static final String KELAS_12 = "KELAS12";
    ArrayList<Kelas12> kelas12List = new ArrayList<>();
    Kelas12Adapter kelas12Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelas12);

        RecyclerView recyclerView  =(RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        kelas12Adapter = new Kelas12Adapter(this,kelas12List);
        recyclerView.setAdapter(kelas12Adapter);

        fillData();
    }

    private void fillData() {
        Resources resources = getResources();
        String [] arJudul = resources.getStringArray(R.array.places_kelas12);
        String [] arDeskripsi = resources.getStringArray(R.array.desc_kelas12);

        TypedArray a = resources.obtainTypedArray(R.array.places_picture12);
        String [] arFoto = new String[a.length()];
        for (int i = 0; i < arFoto.length; i++)
        {
            int id = a.getResourceId(i,0);
            arFoto[i] = ContentResolver.SCHEME_ANDROID_RESOURCE+"://"
                    +resources.getResourcePackageName(id)+'/'
                    +resources.getResourceTypeName(id)+'/'
                    +resources.getResourceEntryName(id);
        }
        a.recycle();

        TypedArray b = resources.obtainTypedArray(R.array.materikelas12);
        String [] arMateri = new String[b.length()];
        for (int i = 0; i < arMateri.length; i++)
        {
            int id = b.getResourceId(i,1);
            arMateri[i] = ContentResolver.SCHEME_ANDROID_RESOURCE+"://"
                    +resources.getResourcePackageName(id)+'/'
                    +resources.getResourceTypeName(id)+'/'
                    +resources.getResourceEntryName(id);
        }
        b.recycle();

        for (int i = 0; i < arJudul.length; i++)
        {
            kelas12List.add(new Kelas12(arJudul[i], arDeskripsi[i], arMateri[i], arFoto[i]));
        }
        kelas12Adapter.notifyDataSetChanged();
    }

    @Override
    public void doClick(int pos) {
        Intent intent = new Intent(this, DetailActivityKelas12.class);
        intent.putExtra(KELAS_12,kelas12List.get(pos));
        startActivity(intent);
    }
}
