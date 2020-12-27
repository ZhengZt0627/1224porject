package com.example.a1224porject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.a1224porject.R;
import com.example.a1224porject.bean.MainSingleBean;

import java.util.ArrayList;
import java.util.List;

public class CateAdapter extends DelegateAdapter.Adapter {
    private SingleLayoutHelper singleLayoutHelper;
    private Context context;
    private ArrayList<MainSingleBean.DataDTO.CategoryListDTO> list;

    public CateAdapter(SingleLayoutHelper singleLayoutHelper, Context context, ArrayList<MainSingleBean.DataDTO.CategoryListDTO> list) {
        this.singleLayoutHelper = singleLayoutHelper;
        this.context = context;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cate_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Holder holder1 = (Holder) holder;
        holder1.rlv.setLayoutManager(new LinearLayoutManager(context));
//        MainSingleBean.DataDTO.CategoryListDTO data = list.get(position);
        CategoodAdapter categoodAdapter = new CategoodAdapter(list, context);
        holder1.rlv.setAdapter(categoodAdapter);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class Holder extends RecyclerView.ViewHolder {
        private RecyclerView rlv;

        public Holder(@NonNull View itemView) {
            super(itemView);
            rlv = itemView.findViewById(R.id.rlv_1);
        }
    }


//    private SingleLayoutHelper singleLayoutHelper;
//    private Context context;
//    private ArrayList<MainSingleBean.DataDTO.CategoryListDTO> catList;
//    private List<MainSingleBean.DataDTO.CategoryListDTO.GoodsListDTO> goodsList;
//
//    public CateAdapter(SingleLayoutHelper singleLayoutHelper, Context context, ArrayList<MainSingleBean.DataDTO.CategoryListDTO> catList) {
//        this.singleLayoutHelper = singleLayoutHelper;
//        this.context = context;
//        this.catList = catList;
//    }
//
//    @Override
//    public LayoutHelper onCreateLayoutHelper() {
//        return singleLayoutHelper;
//    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view=View.inflate(context, R.layout.cate_item,null);
//        return new Holder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        MainSingleBean.DataDTO.CategoryListDTO listDTO = catList.get(position);
//        Holder holder1= (Holder) holder;
//        holder1.tv.setText(listDTO.getName()+"");
//        holder1.rlv.setLayoutManager(new GridLayoutManager(context,2));
//        goodsList = listDTO.getGoodsList();
//        CategoodAdapter categoodAdapter = new CategoodAdapter(context, goodsList);
//        holder1.rlv.setAdapter(categoodAdapter);
//    }
//
//    @Override
//    public int getItemCount() {
//        return catList.size();
//    }
//    class Holder extends RecyclerView.ViewHolder {
//        private TextView tv;
//        private RecyclerView rlv;
//        public Holder(@NonNull View itemView) {
//            super(itemView);
//            tv=itemView.findViewById(R.id.tv);
//            rlv=itemView.findViewById(R.id.rlv_1);
//        }
//    }
}
