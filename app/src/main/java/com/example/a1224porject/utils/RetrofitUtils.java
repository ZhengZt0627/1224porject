package com.example.a1224porject.utils;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitUtils implements MainSinglerInterface {

    private static RetrofitUtils retrofitUtils;
    private  ApiService apiService;

    public RetrofitUtils(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URLcontract.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService=retrofit.create(ApiService.class);
    }

    public static RetrofitUtils getInstance(){
        if (retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if (retrofitUtils==null){
                    retrofitUtils=new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    @Override
    public <T> void get(String url, MainSingleCallBack<T> callBack) {
        apiService.getdata(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        try {
                            String string = value.string();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] types = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type type=types[0];
                            Gson gson = new Gson();
                            T json = gson.fromJson(string, type);
                            callBack.onScuess(json);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
