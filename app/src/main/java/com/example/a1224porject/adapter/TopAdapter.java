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
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.a1224porject.R;
import com.example.a1224porject.bean.MainSingleBean;

import java.util.ArrayList;

public class TopAdapter extends RecyclerView.Adapter<TopAdapter.Viewholder>{
    private Context context;
    private ArrayList<MainSingleBean.DataDTO.TopicListDTO> toplist;

    public TopAdapter(Context context, ArrayList<MainSingleBean.DataDTO.TopicListDTO> toplist) {
        this.context = context;
        this.toplist = toplist;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= View.inflate(context, R.layout.top_item,null);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        Glide.with(context).load(toplist.get(position).getItem_pic_url()).into(holder.img);
        holder.tv1.setText(toplist.get(position).getTitle()+"");
        holder.tv2.setText(toplist.get(position).getSubtitle()+"");
    }

    @Override
    public int getItemCount() {
        return toplist.size();
    }
    class Viewholder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tv1;
        private TextView tv2;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }
}
