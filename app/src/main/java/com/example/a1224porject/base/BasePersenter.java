package com.example.a1224porject.base;

public abstract class BasePersenter<V extends BaseView,M extends BaseModel> {

    public V iView;
    public M iModel;

    public void attchView(V v){
        iView=v;
        iModel=getiModel();
    }

    protected abstract M getiModel();

}
