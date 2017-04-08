package id.sch.smktelkom_mlg.project2.xirpl305091429.pintarfisikasmasmk;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import id.sch.smktelkom_mlg.project2.xirpl305091429.pintarfisikasmasmk.model.Kelas12;
import uk.co.senab.photoview.PhotoViewAttacher;

public class DetailActivityKelas12 extends AppCompatActivity {

    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_activity_kelas12);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Kelas12 kelas12 = (Kelas12) getIntent().getSerializableExtra(Kelas12Activity.KELAS_12);
        setTitle(kelas12.judul);
        ImageView Materi = (ImageView) findViewById(R.id.place_detail);
        Materi.setImageURI(Uri.parse(kelas12.kelas12));

        imgView = (ImageView) findViewById(R.id.place_detail);
        PhotoViewAttacher photoView = new PhotoViewAttacher(imgView);
        photoView.update();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
