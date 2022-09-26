package jti.polinema.ac.id.a04androidrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.PlayerViewHolder>{
    private ArrayList<Buku> dataList;

    public Adapter(ArrayList<Buku> dataList) {
        this.dataList = dataList;
    }
    @NonNull
    @Override
    public Adapter.PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup , int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.list, viewGroup, false);
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.PlayerViewHolder holder, int i) {
        holder.txtJudul.setText(dataList.get(i).getJudul());
        holder.txtPengarang.setText(dataList.get(i).getPengarang());

    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class PlayerViewHolder extends RecyclerView.ViewHolder {
        private TextView txtJudul, txtPengarang;

        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            txtJudul = (TextView) itemView.findViewById(R.id.judul);
            txtPengarang = (TextView) itemView.findViewById(R.id.pengarang);
        }

    }
}