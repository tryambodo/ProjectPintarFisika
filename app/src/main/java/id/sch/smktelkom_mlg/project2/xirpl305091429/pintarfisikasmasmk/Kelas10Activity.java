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

import id.sch.smktelkom_mlg.project2.xirpl305091429.pintarfisikasmasmk.adapter.Kelas10Adapter;
import id.sch.smktelkom_mlg.project2.xirpl305091429.pintarfisikasmasmk.model.Kelas10;

public class Kelas10Activity extends AppCompatActivity implements Kelas10Adapter.IKelas10Adapter{

    public static final String KELAS_10 = "KELAS10";
    ArrayList<Kelas10> kelas10s = new ArrayList<>();
    Kelas10Adapter kelas10Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelas10);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        kelas10Adapter = new Kelas10Adapter(this,kelas10s);
        recyclerView.setAdapter(kelas10Adapter);

        fillData();
    }

    private void fillData() {
        Resources resources = getResources();
        String [] arJudul = resources.getStringArray(R.array.places_kelas10);
        String [] arDeskripsi = resources.getStringArray(R.array.desc_kelas10);

        TypedArray a = resources.obtainTypedArray(R.array.places_picture);
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

        TypedArray b = resources.obtainTypedArray(R.array.places_picture);
        String [] arMateri10 = new String[b.length()];
        for (int i = 0; i < arMateri10.length; i++)
        {
            int id = b.getResourceId(i,1);
            arMateri10[i] = ContentResolver.SCHEME_ANDROID_RESOURCE+"://"
                    +resources.getResourcePackageName(id)+'/'
                    +resources.getResourceTypeName(id)+'/'
                    +resources.getResourceEntryName(id);
        }
        b.recycle();

        for (int i = 0; i < arJudul.length; i++)
        {
            kelas10s.add(new Kelas10(arJudul[i], arDeskripsi[i], arMateri10[i], arFoto[i]));
        }
        kelas10Adapter.notifyDataSetChanged();
    }

    @Override
    public void doClick(int pos) {
        Intent intent = new Intent(this, DetailActivityKelas10.class);
        intent.putExtra(KELAS_10,kelas10s.get(pos));
        startActivity(intent);
    }
}
