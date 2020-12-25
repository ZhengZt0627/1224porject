package com.example.a1224porject.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.a1224porject.R;
import com.example.a1224porject.bean.MainSingleBean;

import java.util.ArrayList;

public class NextSingleAdapter extends DelegateAdapter.Adapter{
    private ArrayList<MainSingleBean.DataDTO.BrandListDTO> nextlist;
    private GridLayoutHelper gridLayoutHelper;
    private Context context;

    public NextSingleAdapter(ArrayList<MainSingleBean.DataDTO.BrandListDTO> nextlist, GridLayoutHelper gridLayoutHelper, Context context) {
        this.nextlist = nextlist;
        this.gridLayoutHelper = gridLayoutHelper;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.nextsingle_item,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Holder holder1= (Holder) holder;
        Glide.with(context).load(nextlist.get(position).getList_pic_url()).into(holder1.img);
        holder1.name.setText(nextlist.get(position).getName());
        holder1.pri.setText(nextlist.get(position).getFloor_price());
    }

    @Override
    public int getItemCount() {
        return nextlist.size();
    }
    class Holder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name;
        private TextView pri;

        public Holder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            pri = itemView.findViewById(R.id.pri);
        }
    }
}
