package id.sch.smktelkom_mlg.project2.xirpl305091429.pintarfisikasmasmk;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import id.sch.smktelkom_mlg.project2.xirpl305091429.pintarfisikasmasmk.model.Kelas10;

public class DetailActivityKelas10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_activity_kelas10);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Kelas10 kelas10 = (Kelas10) getIntent().getSerializableExtra(Kelas10Activity.KELAS_10);
        setTitle(kelas10.judul);
        ImageView deskripsi = (ImageView) findViewById(R.id.place_detail);
        deskripsi.setImageURI(Uri.parse(kelas10.kelas10));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
