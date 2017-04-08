package id.sch.smktelkom_mlg.project2.xirpl305091429.pintarfisikasmasmk;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {


    public FragmentHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View activityView = inflater.inflate(R.layout.fragment_fragment_home, container, false);
        ImageButton a = (ImageButton) activityView.findViewById(R.id.kelas10);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Kelas10Activity.class);
                startActivity(intent);
            }
        });
        ImageButton b = (ImageButton) activityView.findViewById(R.id.kelas11);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Kelas11Activity.class);
                startActivity(intent);
            }
        });
        ImageButton c = (ImageButton) activityView.findViewById(R.id.kelas12);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Kelas12Activity.class);
                startActivity(intent);
            }
        });

        return activityView;
    }

}
