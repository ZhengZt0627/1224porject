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

public class HotGoodsAdapter extends DelegateAdapter.Adapter {
    private GridLayoutHelper gridLayoutHelper;
    private Context context;
    private ArrayList<MainSingleBean.DataDTO.HotGoodsListDTO> hotlist;

    public HotGoodsAdapter(GridLayoutHelper gridLayoutHelper, Context context, ArrayList<MainSingleBean.DataDTO.HotGoodsListDTO> hotlist) {
        this.gridLayoutHelper = gridLayoutHelper;
        this.context = context;
        this.hotlist = hotlist;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.hotgood_item,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Holder holder1= (Holder) holder;
        Glide.with(context).load(hotlist.get(position).getList_pic_url()).into(holder1.img);
        holder1.tv1.setText(hotlist.get(position).getName()+"");
        holder1.tv2.setText(hotlist.get(position).getGoods_brief()+"");
        holder1.tv3.setText("$"+hotlist.get(position).getRetail_price()+"");
    }

    @Override
    public int getItemCount() {
        return hotlist.size();
    }
    class Holder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;

        public Holder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
        }
    }
}
