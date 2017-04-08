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
import id.sch.smktelkom_mlg.project2.xirpl305091429.pintarfisikasmasmk.model.Kelas12;

/**
 * Created by Ifan on 07/04/2017.
 */
public class Kelas12Adapter extends RecyclerView.Adapter<Kelas12Adapter.ViewHolder> {

    ArrayList<Kelas12> kelas12List;
    IKelas12Adapter mIKelas12Adapter;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Kelas12 kelas12 = kelas12List.get(position);
        holder.tvJudul.setText(kelas12.judul);
        holder.tvDeskripsi.setText(kelas12.deskripsi);
        holder.ivFoto.setImageURI(Uri.parse(kelas12.foto));
    }

    @Override
    public int getItemCount() {
        if (kelas12List!=null)
            return kelas12List.size();
        return 0;
    }

    public Kelas12Adapter(Context context, ArrayList<Kelas12> kelas12List)
    {
        this.kelas12List = kelas12List;
        mIKelas12Adapter = (IKelas12Adapter) context;
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
                    mIKelas12Adapter.doClick(getAdapterPosition());
                }
            });
        }
    }

    public interface IKelas12Adapter
    {
        void doClick(int pos);
    }
}
