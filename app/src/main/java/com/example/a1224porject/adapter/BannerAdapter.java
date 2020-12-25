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
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.a1224porject.R;
import com.example.a1224porject.bean.MainSingleBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class BannerAdapter extends DelegateAdapter.Adapter {
    private ArrayList<MainSingleBean.DataDTO.BannerDTO> bannerlist;
    private Context context;
    private SingleLayoutHelper singleLayoutHelper;

    public BannerAdapter(ArrayList<MainSingleBean.DataDTO.BannerDTO> bannerlist, Context context, SingleLayoutHelper singleLayoutHelper) {
        this.bannerlist = bannerlist;
        this.context = context;
        this.singleLayoutHelper = singleLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.banner_item,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Holder holder1= (Holder) holder;
        holder1.banner.setImages(bannerlist).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                MainSingleBean.DataDTO.BannerDTO data= (MainSingleBean.DataDTO.BannerDTO) path;
                Glide.with(context).load(data.getImage_url()).into(imageView);
            }
        }).start();
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    class Holder extends RecyclerView.ViewHolder {
        private Banner banner;
        public Holder(@NonNull View itemView) {
            super(itemView);
            banner=itemView.findViewById(R.id.banner);
        }
    }
}
