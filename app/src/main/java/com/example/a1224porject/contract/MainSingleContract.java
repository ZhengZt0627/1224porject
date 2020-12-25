package com.example.a1224porject.contract;

import com.example.a1224porject.base.BaseModel;
import com.example.a1224porject.base.BaseView;
import com.example.a1224porject.bean.MainSingleBean;
import com.example.a1224porject.utils.MainSingleCallBack;


public class MainSingleContract {
    public interface MainSingleView extends BaseView {
        void onScuess(MainSingleBean mainSingleBean);
        void onFeil(String msg);
    }
    public interface MainSingleModel extends BaseModel {
        <T> void MainSingleModel(String url, MainSingleCallBack<T> callBack);
    }
    public interface MainSinglePresenter extends BaseView{
        void getdata();
    }
}
