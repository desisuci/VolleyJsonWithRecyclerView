package com.desisuci.volleyjsonwithrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    private ArrayList<Users> dataList;

    public UsersAdapter(ArrayList<Users> dataList) {
        this.dataList = dataList;
    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cardview, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, int position) {
        holder.txtId.setText(dataList.get(position).getId());
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtUserName.setText(dataList.get(position).getUserName());
        holder.txtEmail.setText(dataList.get(position).getEmail());
        holder.txtAddress.setText(dataList.get(position).getAddress());
        holder.txtNoHp.setText(dataList.get(position).getAddress());

    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class UsersViewHolder extends RecyclerView.ViewHolder{
        private TextView txtId, txtNama,txtUserName, txtEmail, txtAddress, txtNoHp;

        public UsersViewHolder(View itemView) {
            super(itemView);
            txtId = (TextView) itemView.findViewById(R.id.txt_id);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama);
            txtUserName = (TextView) itemView.findViewById(R.id.txt_username);
            txtEmail = (TextView) itemView.findViewById(R.id.txt_email);
            txtAddress = (TextView) itemView.findViewById(R.id.txt_address);
            txtNoHp = (TextView) itemView.findViewById(R.id.txt_noHp);
        }
    }
}
