package com.example.a1224porject.presenter;

import com.example.a1224porject.base.BasePersenter;
import com.example.a1224porject.bean.MainSingleBean;
import com.example.a1224porject.contract.MainSingleContract;
import com.example.a1224porject.model.MainSingleModel;
import com.example.a1224porject.utils.MainSingleCallBack;
import com.example.a1224porject.utils.URLcontract;

public class MainSinglePresenter extends BasePersenter<MainSingleContract.MainSingleView,MainSingleContract.MainSingleModel> implements MainSingleContract.MainSinglePresenter {

    @Override
    public void getdata() {
        iModel.MainSingleModel(URLcontract.Mainsingle_url, new MainSingleCallBack<MainSingleBean>() {
            @Override
            public void onScuess(MainSingleBean mainSingleBean) {
                iView.onScuess(mainSingleBean);
            }

            @Override
            public void onFeil(String msg) {
                iView.onFeil(msg);
            }
        });
    }

    @Override
    protected MainSingleContract.MainSingleModel getiModel() {
        return new MainSingleModel(this);
    }
}
