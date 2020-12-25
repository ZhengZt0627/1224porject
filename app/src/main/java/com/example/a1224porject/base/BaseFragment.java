package com.example.a1224porject.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.a1224porject.R;

public abstract class BaseFragment<T extends BasePersenter> extends Fragment implements BaseView{

    public T presenter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //  homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View view = inflater.inflate(getLayout(), container, false);

        if (presenter==null){
            presenter=getPresenter();
            presenter.attchView(this);
        }

        initView(view);
        initDate();
        return view;
    }

    protected abstract void initView(View view);
    protected abstract void initDate();

    protected abstract int getLayout();

    protected abstract T getPresenter();
}
