package com.example.a1224porject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a1224porject.R;
import com.example.a1224porject.bean.MainSingleBean;

import java.util.ArrayList;
import java.util.List;

public class CategoodAdapter extends RecyclerView.Adapter<CategoodAdapter.Holder> {
    private ArrayList<MainSingleBean.DataDTO.CategoryListDTO> list;
    private Context context;

    public CategoodAdapter(ArrayList<MainSingleBean.DataDTO.CategoryListDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoodAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.categood_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoodAdapter.Holder holder, int position) {
        MainSingleBean.DataDTO.CategoryListDTO data = list.get(position);
        holder.name.setText(data.getName());
        holder.recy.setLayoutManager(new GridLayoutManager(context, 2));
        CategoodItemAdapter categoodItemAdapter = new CategoodItemAdapter(data.getGoodsList(), context);
        holder.recy.setAdapter(categoodItemAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final RecyclerView recy;

        public Holder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_categood);
            recy = itemView.findViewById(R.id.recy_categood);
        }
    }


//    private Context context;
//    private List<MainSingleBean.DataDTO.CategoryListDTO.GoodsListDTO> goodsList;
//
//    public CategoodAdapter(Context context, List<MainSingleBean.DataDTO.CategoryListDTO.GoodsListDTO> goodsList) {
//        this.context = context;
//        this.goodsList = goodsList;
//    }
//
//    @NonNull
//    @Override
//    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view=View.inflate(context, R.layout.categood_item,null);
//        return new Holder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull Holder holder, int position) {
//        Glide.with(context).load(goodsList.get(position).getList_pic_url()).into(holder.img);
//        holder.name.setText(goodsList.get(position).getName()+"");
//        holder.pri.setText(goodsList.get(position).getRetail_price()+"");
//    }
//
//    @Override
//    public int getItemCount() {
//        return goodsList.size();
//    }
//
//    public class Holder extends RecyclerView.ViewHolder {
//        private ImageView img;
//        private TextView name;
//        private TextView pri;
//
//        public Holder(@NonNull View itemView) {
//            super(itemView);
//            img = itemView.findViewById(R.id.iv_brand);
//            name = itemView.findViewById(R.id.tv_name_brand);
//            pri = itemView.findViewById(R.id.tv_price_brand);
//        }
//    }
}
