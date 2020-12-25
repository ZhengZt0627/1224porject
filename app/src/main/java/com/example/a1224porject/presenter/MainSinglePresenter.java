package com.example.a1224porject.presenter;

import com.example.a1224porject.bean.MainSingleBean;
import com.example.a1224porject.contract.MainSingleContract;
import com.example.a1224porject.model.MainSingleModel;
import com.example.a1224porject.utils.MainSingleCallBack;
import com.example.a1224porject.utils.URLcontract;

public class MainSinglePresenter implements MainSingleContract.MainSinglePresenter {
    private MainSingleContract.MainSingleView view;
    private MainSingleContract.MainSingleModel model;

    public MainSinglePresenter(MainSingleContract.MainSingleView view) {
        this.view = view;
        model=new MainSingleModel(this);
    }

    @Override
    public void getdata() {
        model.MainSingleModel(URLcontract.Mainsingle_url, new MainSingleCallBack<MainSingleBean>() {
            @Override
            public void onScuess(MainSingleBean mainSingleBean) {
                view.onScuess(mainSingleBean);
            }

            @Override
            public void onFeil(String msg) {
                view.onFeil(msg);
            }
        });
    }
}
