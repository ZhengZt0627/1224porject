package com.example.a1224porject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a1224porject.R;
import com.example.a1224porject.bean.MainSingleBean;

import java.util.List;

public class CategoodItemAdapter extends RecyclerView.Adapter {
    private List<MainSingleBean.DataDTO.CategoryListDTO.GoodsListDTO> list;
    private Context context;

    public CategoodItemAdapter(List<MainSingleBean.DataDTO.CategoryListDTO.GoodsListDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_categooditem, parent, false);
        return new CategoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CategoodViewHolder viewHolder = (CategoodViewHolder) holder;
        MainSingleBean.DataDTO.CategoryListDTO.GoodsListDTO data = list.get(position);
        Glide.with(context).load(data.getList_pic_url()).into(viewHolder.img);
        viewHolder.tv1.setText(data.getName());
        viewHolder.tv2.setText("$"+data.getRetail_price());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CategoodViewHolder extends RecyclerView.ViewHolder {
        private final ImageView img;
        private TextView tv1;
        private TextView tv2;
        public CategoodViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tv1=itemView.findViewById(R.id.tv1);
            tv2=itemView.findViewById(R.id.tv2);
        }
    }
}
