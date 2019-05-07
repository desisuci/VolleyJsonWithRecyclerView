package com.desisuci.volleyjsonwithrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class KontakAdapter extends RecyclerView.Adapter<KontakAdapter.KontakViewHolder> {
    private ArrayList<Kontak> dataList;

    public KontakAdapter(ArrayList<Kontak> dataList) {
        this.dataList = dataList;
    }

    @Override
    public KontakAdapter.KontakViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cardview, parent, false);
        return new KontakAdapter.KontakViewHolder(view);
    }

    @Override
    public void onBindViewHolder(KontakAdapter.KontakViewHolder holder, int position) {
        holder.txtId.setText(dataList.get(position).getId());
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtEmail.setText(dataList.get(position).getEmail());
        holder.txtAddress.setText(dataList.get(position).getAddress());
        holder.txtNoHp.setText(dataList.get(position).getNoHp());
    }


    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class KontakViewHolder extends RecyclerView.ViewHolder{
        private TextView txtId, txtNama, txtEmail, txtAddress, txtNoHp;

        public KontakViewHolder(View itemView) {
            super(itemView);
            txtId = (TextView) itemView.findViewById(R.id.txt_id);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama);
            txtEmail = (TextView) itemView.findViewById(R.id.txt_email);
            txtAddress = (TextView) itemView.findViewById(R.id.txt_address);
            txtNoHp = (TextView) itemView.findViewById(R.id.txt_noHp);
        }
    }
}
