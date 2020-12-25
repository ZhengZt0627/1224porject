package com.example.a1224porject.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.example.a1224porject.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView rlv;
    private VirtualLayoutManager vmanager;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      //  homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
       return view;
    }

    private void initView(View view) {
        rlv = view.findViewById(R.id.rlv);
        //创建Vlayout对象
        vmanager = new VirtualLayoutManager(getActivity());

        RecyclerView.RecycledViewPool pool = new RecyclerView.RecycledViewPool();
        rlv.setRecycledViewPool(pool);
        pool.setMaxRecycledViews(0,100);
    }
}