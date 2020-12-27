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
import com.example.a1224porject.adapter.BannerAdapter;
import com.example.a1224porject.adapter.FindAdapter;
import com.example.a1224porject.adapter.HotGoodsAdapter;
import com.example.a1224porject.adapter.MainSingleAdapter;
import com.example.a1224porject.adapter.MonAdapter;
import com.example.a1224porject.adapter.NewGoodsAdapter;
import com.example.a1224porject.adapter.NextSingleAdapter;
import com.example.a1224porject.adapter.TextAdapter;
import com.example.a1224porject.adapter.ploAdapter;
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
    private List<View> views = new ArrayList<>();
    private ArrayList<MainSingleBean.DataDTO.ChannelDTO> singlelist;
    private MainSingleAdapter mainSingleAdapter;
    private ArrayList<MainSingleBean.DataDTO.BrandListDTO> nextlist;
    private NextSingleAdapter nextSingleAdapter;
    private TextAdapter textAdapter;
    private ArrayList<MainSingleBean.DataDTO.BannerDTO> bannerlist;
    private BannerAdapter bannerAdapter;
    private FindAdapter findAdapter;
    private MonAdapter monAdapter;
    private ArrayList<MainSingleBean.DataDTO.NewGoodsListDTO> goodslist;
    private NewGoodsAdapter newGoodsAdapter;
    private com.example.a1224porject.adapter.ploAdapter ploAdapter;
    private ArrayList<MainSingleBean.DataDTO.HotGoodsListDTO> hotlist;
    private DelegateAdapter delegateAdapter;
    private HotGoodsAdapter hotGoodsAdapter;


    protected void initView(View view) {
        rlv = view.findViewById(R.id.rlv);

        //创建Vlayout对象
        vmanager = new VirtualLayoutManager(getActivity());

        RecyclerView.RecycledViewPool pool = new RecyclerView.RecycledViewPool();
        rlv.setRecycledViewPool(pool);
        pool.setMaxRecycledViews(0, 20);
        //设置总体适配器
        delegateAdapter = new DelegateAdapter(vmanager);
        //搜索框
        initSearch();
        //banner
        initBanner();
        //专题行
        initZhuanti();
        //对应的文字和网格
        initNext();
        //放最后
        rlv.setAdapter(delegateAdapter);
        rlv.setLayoutManager(vmanager);

    }



    private void initSearch() {
        SingleLayoutHelper singleLayoutHelper2 = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper2.setMargin(10, 10, 10, 10);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper2.setAspectRatio(4);// 设置设置布局内每行布局的宽与高的比
        singleLayoutHelper2.setItemCount(1);// 设置布局里Item个数
        findAdapter = new FindAdapter(singleLayoutHelper2, getActivity());
        delegateAdapter.addAdapter(findAdapter);

    }
    private void initBanner() {
        bannerlist = new ArrayList<>();
        //定义文字
        SingleLayoutHelper singleLayoutHelper1 = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper1.setItemCount(1);// 设置布局里Item个数

        bannerAdapter = new BannerAdapter(bannerlist,getActivity(),singleLayoutHelper1);
        delegateAdapter.addAdapter(bannerAdapter);
    }

    private void initZhuanti() {

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
        mainSingleAdapter = new MainSingleAdapter(gridLayoutHelper, getActivity(), singlelist);
        //设置适配器2
        delegateAdapter.addAdapter(mainSingleAdapter);

    }

    private void initNext() {
        //定义文字
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        textAdapter = new TextAdapter(singleLayoutHelper, getActivity());
        delegateAdapter.addAdapter(textAdapter);
        //直供
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
        //定义文字
        SingleLayoutHelper singleLayoutHelper4 = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper4.setItemCount(1);// 设置布局里Item个数
        monAdapter = new MonAdapter(singleLayoutHelper4, getActivity());
        delegateAdapter.addAdapter(monAdapter);
        //周一周日网格：
        goodslist = new ArrayList<>();
        ///< 网格布局 - 构造中传入相应的列的数量
        GridLayoutHelper gridLayoutHelper2 = new GridLayoutHelper(4);
        //gridLayoutHelper1.setMarginTop(30);
        gridLayoutHelper2.setSpanCount(2);
        //设置垂直方向条目的间隔
        gridLayoutHelper2.setVGap(5);
        //设置水平方向条目的间隔
        gridLayoutHelper2.setHGap(5);
        gridLayoutHelper2.setMarginLeft(30);
        gridLayoutHelper2.setMarginRight(30);
        //  gridLayoutHelper1.setMarginBottom(30);
        //自动填充满布局，在设置完权重，若没有占满，自动填充满布局
        gridLayoutHelper2.setAutoExpand(true);
        newGoodsAdapter = new NewGoodsAdapter(goodslist, gridLayoutHelper2, getActivity());
        delegateAdapter.addAdapter(newGoodsAdapter);
        //定义文字：人气推荐
        SingleLayoutHelper singleLayoutHelper5 = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper5.setItemCount(1);// 设置布局里Item个数
        ploAdapter = new ploAdapter(singleLayoutHelper5,getActivity());
        delegateAdapter.addAdapter(ploAdapter);
        //人气推荐网格：
        hotlist = new ArrayList<>();
        GridLayoutHelper gridLayoutHelper3 = new GridLayoutHelper(3);
        gridLayoutHelper3.setSpanCount(1);
        gridLayoutHelper3.setItemCount(4);
        hotGoodsAdapter = new HotGoodsAdapter(gridLayoutHelper3,getActivity(),hotlist);
        delegateAdapter.addAdapter(hotGoodsAdapter);

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
        bannerlist.addAll(mainSingleBean.getData().getBanner());
        goodslist.addAll(mainSingleBean.getData().getNewGoodsList());
        hotlist.addAll(mainSingleBean.getData().getHotGoodsList());
        bannerAdapter.notifyDataSetChanged();
        nextSingleAdapter.notifyDataSetChanged();
        mainSingleAdapter.notifyDataSetChanged();
        findAdapter.notifyDataSetChanged();
        monAdapter.notifyDataSetChanged();
        newGoodsAdapter.notifyDataSetChanged();
        ploAdapter.notifyDataSetChanged();
        hotGoodsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFeil(String msg) {

    }

}