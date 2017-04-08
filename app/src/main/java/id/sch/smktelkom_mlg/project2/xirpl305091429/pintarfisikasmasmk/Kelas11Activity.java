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

import id.sch.smktelkom_mlg.project2.xirpl305091429.pintarfisikasmasmk.adapter.Kelas11Adapter;
import id.sch.smktelkom_mlg.project2.xirpl305091429.pintarfisikasmasmk.model.Kelas11;

public class Kelas11Activity extends AppCompatActivity implements Kelas11Adapter.IKelas11Adapter {

    public static final String KELAS_11 = "KELAS11";
    ArrayList<Kelas11> kelas11List = new ArrayList<>();
    Kelas11Adapter kelas11Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelas11);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        kelas11Adapter = new Kelas11Adapter(this, kelas11List);
        recyclerView.setAdapter(kelas11Adapter);

        fillData();
    }

    private void fillData() {
        Resources resources = getResources();
        String [] arJudul = resources.getStringArray(R.array.places_kelas11);
        String [] arDeskripsi = resources.getStringArray(R.array.desc_kelas11);

        TypedArray a = resources.obtainTypedArray(R.array.places_picture11);
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

        TypedArray b = resources.obtainTypedArray(R.array.materikelas11);
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
            kelas11List.add(new Kelas11(arJudul[i], arDeskripsi[i], arFoto[i], arMateri[i]));
        }
        kelas11Adapter.notifyDataSetChanged();
    }

    @Override
    public void doClick(int pos) {
        Intent intent = new Intent(this,DetailActivityKelas11.class);
        intent.putExtra(KELAS_11,kelas11List.get(pos));
        startActivity(intent);
    }
}
