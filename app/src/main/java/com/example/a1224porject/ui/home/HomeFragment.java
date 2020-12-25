package com.example.a1224porject.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.a1224porject.R;
import com.example.a1224porject.adapter.MainSingleAdapter;
import com.example.a1224porject.bean.MainSingleBean;
import com.example.a1224porject.contract.MainSingleContract;
import com.example.a1224porject.presenter.MainSinglePresenter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements MainSingleContract.MainSingleView {

    private HomeViewModel homeViewModel;
    private RecyclerView rlv;
    private VirtualLayoutManager vmanager;
    private ViewPager vp;
    private int images[] ={R.mipmap.p1,R.mipmap.p2,R.mipmap.p3};
    private List<View> views=new ArrayList<>();
    private ArrayList<MainSingleBean.DataDTO.ChannelDTO> singlelist;
    private MainSingleAdapter mainSingleAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      //  homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);

        return view;
    }

    private void initView(View view) {
        rlv = view.findViewById(R.id.rlv);
        vp = view.findViewById(R.id.vp);

        //将images数组中的图片放入ImageView
        for (int i = 0; i < images.length; i++) {
            ImageView imageView=new ImageView(getActivity());
            imageView.setImageResource(images[i]);
            views.add(imageView);
        }
        vp.setAdapter(new MyAdapter());

        //创建Vlayout对象
        vmanager = new VirtualLayoutManager(getActivity());

        RecyclerView.RecycledViewPool pool = new RecyclerView.RecycledViewPool();
        rlv.setRecycledViewPool(pool);
        pool.setMaxRecycledViews(0,20);
//设置适配器1
        DelegateAdapter delegateAdapter = new DelegateAdapter(vmanager, true);

        //第二行

        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        singleLayoutHelper.setPadding(10, 10, 10, 10);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setMargin(10, 10, 10, 10);
        singleLayoutHelper.setAspectRatio(4);// 设置设置布局内每行布局的宽与高的比
        singlelist = new ArrayList<>();
        mainSingleAdapter = new MainSingleAdapter(singleLayoutHelper,getActivity(),singlelist);


        MainSinglePresenter presenter = new MainSinglePresenter(this);
        presenter.getdata();
        //设置适配器2
        delegateAdapter.addAdapter(mainSingleAdapter);

        //放最后
        rlv.setAdapter(delegateAdapter);
        rlv.setLayoutManager(vmanager);

    }
//第层专题选择数据请求
    @Override
    public void onScuess(MainSingleBean mainSingleBean) {
        singlelist.addAll(mainSingleBean.getData().getChannel());
        mainSingleAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFeil(String msg) {

    }

    //图片
    class MyAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return views.size();
        }
        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==object;
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v=views.get(position);
            container.addView(v);
            return v;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View v=views.get(position);
            //前一张图片划过后删除该View
            container.removeView(v);
        }
    }
}