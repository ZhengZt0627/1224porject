package com.example.a1224porject.ui.home;

import android.graphics.Color;
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
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.a1224porject.R;
import com.example.a1224porject.adapter.MainSingleAdapter;
import com.example.a1224porject.adapter.NextSingleAdapter;
import com.example.a1224porject.adapter.TextAdapter;
import com.example.a1224porject.base.BaseFragment;
import com.example.a1224porject.base.BasePersenter;
import com.example.a1224porject.bean.MainSingleBean;
import com.example.a1224porject.contract.MainSingleContract;
import com.example.a1224porject.presenter.MainSinglePresenter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment<MainSinglePresenter> implements MainSingleContract.MainSingleView {

    private HomeViewModel homeViewModel;
    private RecyclerView rlv;
    private VirtualLayoutManager vmanager;
    private ViewPager vp;
    private int images[] ={R.mipmap.p1,R.mipmap.p2,R.mipmap.p3};
    private List<View> views=new ArrayList<>();
    private ArrayList<MainSingleBean.DataDTO.ChannelDTO> singlelist;
    private MainSingleAdapter mainSingleAdapter;
    private ArrayList<MainSingleBean.DataDTO.BrandListDTO> nextlist;
    private NextSingleAdapter nextSingleAdapter;
    private TextAdapter textAdapter;


    protected void initView(View view) {
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
        DelegateAdapter delegateAdapter = new DelegateAdapter(vmanager);


        /**
         设置Grid布局
         */
        singlelist = new ArrayList<>();
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper.setItemCount(5);// 设置布局里Item个数
        gridLayoutHelper.setPadding(10, 10, 10, 10);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper.setMargin(10, 10, 10, 10);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{20, 20, 20, 20, 20});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(5);// 设置每行多少个网格
        mainSingleAdapter = new MainSingleAdapter(gridLayoutHelper,getActivity(),singlelist);
        //设置适配器2
        delegateAdapter.addAdapter(mainSingleAdapter);


        //定义文字
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
//        singleLayoutHelper.setPadding(10, 10, 10, 10);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        singleLayoutHelper.setMargin(10, 10, 10, 10);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(4);// 设置设置布局内每行布局的宽与高的比
        textAdapter = new TextAdapter(singleLayoutHelper,getActivity());
       delegateAdapter.addAdapter(textAdapter);


        //列表展示：
        nextlist = new ArrayList<>();
        ///< 网格布局 - 构造中传入相应的列的数量
        GridLayoutHelper gridLayoutHelper1 = new GridLayoutHelper(4);
      //gridLayoutHelper1.setMarginTop(30);
        gridLayoutHelper1.setSpanCount(2);
        //设置垂直方向条目的间隔
        gridLayoutHelper1.setVGap(5);
        //设置水平方向条目的间隔
        gridLayoutHelper1.setHGap(5);
        gridLayoutHelper1.setMarginLeft(30);
        gridLayoutHelper1.setMarginRight(30);
      //  gridLayoutHelper1.setMarginBottom(30);
        //自动填充满布局，在设置完权重，若没有占满，自动填充满布局
        gridLayoutHelper1.setAutoExpand(true);
        nextSingleAdapter = new NextSingleAdapter(nextlist, gridLayoutHelper1, getActivity());
        //设置适配器2
        delegateAdapter.addAdapter(nextSingleAdapter);

        //放最后
        rlv.setAdapter(delegateAdapter);
        rlv.setLayoutManager(vmanager);

    }

    @Override
    protected void initDate() {
        presenter.getdata();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected MainSinglePresenter getPresenter() {
        return new MainSinglePresenter();
    }

    //第层专题选择数据请求
    @Override
    public void onScuess(MainSingleBean mainSingleBean) {
        singlelist.addAll(mainSingleBean.getData().getChannel());
        nextlist.addAll(mainSingleBean.getData().getBrandList());
        nextSingleAdapter.notifyDataSetChanged();
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