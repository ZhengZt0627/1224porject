package com.example.a1224porject.model;

import com.example.a1224porject.base.BaseModel;
import com.example.a1224porject.contract.MainSingleContract;
import com.example.a1224porject.presenter.MainSinglePresenter;
import com.example.a1224porject.utils.MainSingleCallBack;
import com.example.a1224porject.utils.RetrofitUtils;

public class MainSingleModel implements MainSingleContract.MainSingleModel {
    private MainSingleContract.MainSinglePresenter presenter;

    public MainSingleModel(MainSinglePresenter mainSinglePresenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void MainSingleModel(String url, MainSingleCallBack<T> callBack) {
        RetrofitUtils.getInstance().get(url,callBack);

    }
}
