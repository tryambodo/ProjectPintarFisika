package id.sch.smktelkom_mlg.project2.xirpl305091429.pintarfisikasmasmk.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project2.xirpl305091429.pintarfisikasmasmk.R;
import id.sch.smktelkom_mlg.project2.xirpl305091429.pintarfisikasmasmk.model.Kelas10;

/**
 * Created by Ifan on 30/03/2017.
 */
public class Kelas10Adapter extends RecyclerView.Adapter<Kelas10Adapter.ViewHolder>
{
    ArrayList<Kelas10> kelas10List;
    IKelas10Adapter mIKelas10Adapter;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Kelas10 kelas10 = kelas10List.get(position);
        holder.tvJudul.setText(kelas10.judul);
        holder.tvDeskripsi.setText(kelas10.deskripsi);
        holder.ivFoto.setImageURI(Uri.parse(kelas10.foto));
    }

    @Override
    public int getItemCount() {
        if (kelas10List!=null)
            return kelas10List.size();
        return 0;
    }

    public Kelas10Adapter(Context context, ArrayList<Kelas10> kelas10List)
    {
        this.kelas10List = kelas10List;
        mIKelas10Adapter = (IKelas10Adapter) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivFoto;
        TextView tvJudul;
        TextView tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mIKelas10Adapter.doClick(getAdapterPosition());
                }
            });
        }
    }
    public interface IKelas10Adapter
    {
        void doClick(int pos);
    }
}
