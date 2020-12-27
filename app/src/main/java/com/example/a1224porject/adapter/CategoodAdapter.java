package com.example.a1224porject.adapter;

import android.content.Context;
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

public class CategoodAdapter extends RecyclerView.Adapter<CategoodAdapter.Holder> {
    private Context context;
    private List<MainSingleBean.DataDTO.CategoryListDTO.GoodsListDTO> goodsList;

    public CategoodAdapter(Context context, List<MainSingleBean.DataDTO.CategoryListDTO.GoodsListDTO> goodsList) {
        this.context = context;
        this.goodsList = goodsList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.categood_item,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(context).load(goodsList.get(position).getList_pic_url()).into(holder.img);
        holder.name.setText(goodsList.get(position).getName());
        holder.pri.setText(goodsList.get(position).getRetail_price());
    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name;
        private TextView pri;

        public Holder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.iv_brand);
            name = itemView.findViewById(R.id.tv_name_brand);
            pri = itemView.findViewById(R.id.tv_price_brand);
        }
    }
}
