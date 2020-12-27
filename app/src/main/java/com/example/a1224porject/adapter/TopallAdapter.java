package com.example.a1224porject.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.a1224porject.R;
import com.example.a1224porject.bean.MainSingleBean;
import com.google.android.material.transition.Hold;

import java.util.ArrayList;

public class TopallAdapter  extends DelegateAdapter.Adapter {
    private SingleLayoutHelper singleLayoutHelper;
    private Context context;
    private ArrayList<MainSingleBean.DataDTO.TopicListDTO> toplist;

    public TopallAdapter(SingleLayoutHelper singleLayoutHelper, Context context, ArrayList<MainSingleBean.DataDTO.TopicListDTO> toplist) {
        this.singleLayoutHelper = singleLayoutHelper;
        this.context = context;
        this.toplist = toplist;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= View.inflate(context, R.layout.rlv_top_item,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Holder holder1= (Holder) holder;
        RecyclerView rlv1=holder1.rlv;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        rlv1.setLayoutManager(linearLayoutManager);
        TopAdapter adapter = new TopAdapter(context,toplist);
        rlv1.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    class Holder extends RecyclerView.ViewHolder {
        private RecyclerView rlv;
        public Holder(@NonNull View itemView) {
            super(itemView);
            rlv=itemView.findViewById(R.id.rlv_top);
        }
    }
}
