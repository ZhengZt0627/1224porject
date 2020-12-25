package com.example.a1224porject.adapter;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.a1224porject.R;
import com.example.a1224porject.bean.MainSingleBean;

import java.util.ArrayList;

public class MainSingleAdapter extends DelegateAdapter.Adapter{

    private GridLayoutHelper gridLayoutHelper;
    private Context context;
    private ArrayList<MainSingleBean.DataDTO.ChannelDTO> singlelist;

    public MainSingleAdapter(GridLayoutHelper gridLayoutHelper, Context context, ArrayList<MainSingleBean.DataDTO.ChannelDTO> singlelist) {
        this.gridLayoutHelper = gridLayoutHelper;
        this.context = context;
        this.singlelist = singlelist;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.mainsingle_item, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Holder holder1 = (Holder) holder;
       Glide.with(context).load(singlelist.get(position).getIcon_url()).into(holder1.img);
        holder1.tv.setText(singlelist.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return singlelist.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tv;

        public Holder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tv = itemView.findViewById(R.id.tv);
        }
    }


}
