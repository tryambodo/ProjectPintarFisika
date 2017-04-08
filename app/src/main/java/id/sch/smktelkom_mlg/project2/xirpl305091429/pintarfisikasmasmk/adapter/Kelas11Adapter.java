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
import id.sch.smktelkom_mlg.project2.xirpl305091429.pintarfisikasmasmk.model.Kelas11;

/**
 * Created by Ifan on 07/04/2017.
 */
public class Kelas11Adapter extends RecyclerView.Adapter<Kelas11Adapter.ViewHolder> {

    ArrayList<Kelas11> kelas11List;
    IKelas11Adapter mIKelas11Adapter;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Kelas11 kelas11 = kelas11List.get(position);
        holder.tvJudul.setText(kelas11.judul);
        holder.tvDeskripsi.setText(kelas11.deskripsi);
        holder.ivFoto.setImageURI(Uri.parse(kelas11.foto));
    }

    @Override
    public int getItemCount() {
        if (kelas11List!=null)
            return kelas11List.size();
        return 0;
    }

    public Kelas11Adapter(Context context, ArrayList<Kelas11> kelas11List)
    {
        this.kelas11List = kelas11List;
        mIKelas11Adapter = (IKelas11Adapter) context;
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
                    mIKelas11Adapter.doClick(getAdapterPosition());
                }
            });
        }
    }

    public interface IKelas11Adapter
    {
        void doClick(int pos);
    }
}
