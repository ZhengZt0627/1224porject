package com.example.a1224porject.contract;

import com.example.a1224porject.bean.MainSingleBean;
import com.example.a1224porject.utils.MainSingleCallBack;


public class MainSingleContract {
    public interface MainSingleView{
        void onScuess(MainSingleBean mainSingleBean);
        void onFeil(String msg);
    }
    public interface MainSingleModel{
        <T> void MainSingleModel(String url, MainSingleCallBack<T> callBack);
    }
    public interface MainSinglePresenter{
        void getdata();
    }
}
