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

public class NewGoodsAdapter extends DelegateAdapter.Adapter {
    private ArrayList<MainSingleBean.DataDTO.NewGoodsListDTO> goodslist;
    private GridLayoutHelper gridLayoutHelper;
    private Context context;

    public NewGoodsAdapter(ArrayList<MainSingleBean.DataDTO.NewGoodsListDTO> goodslist, GridLayoutHelper gridLayoutHelper, Context context) {
        this.goodslist = goodslist;
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
        View view=View.inflate(context, R.layout.newgood_item,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Holder holder1= (Holder) holder;
        Glide.with(context).load(goodslist.get(position).getList_pic_url()).into(holder1.img);
        holder1.name.setText(goodslist.get(position).getName());
        holder1.pri.setText("💵"+goodslist.get(position).getRetail_price()+"元");
    }

    @Override
    public int getItemCount() {
        return goodslist.size();
    }
    class Holder extends RecyclerView.ViewHolder {
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
