package com.bwie.shoppingcart.home.mvp.model;

import android.util.Log;

import com.bwie.shoppingcart.home.bean.Bounced2Bean;
import com.bwie.shoppingcart.home.bean.BouncedBean;
import com.bwie.shoppingcart.home.mvp.api.ApiService;
import com.bwie.shoppingcart.home.mvp.api.CallBack;
import com.bwie.shoppingcart.home.mvp.contract.BouncedContractClass;
import com.bwie.shoppingcart.home.mvp.util.RetrofitUtil;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class BouncedModel implements BouncedContractClass.MainModel {

    private ApiService service;


    @Override
    public void getModelBounced(final CallBack callBack) {
        service = RetrofitUtil.getInstance().create(ApiService.class);
        service.getPop()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<BouncedBean>(){
                    @Override
                    public void onNext(BouncedBean bouncedBean) {
                        Log.i("sss", "onNext: "+ bouncedBean.getResult());
                        callBack.Success(bouncedBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("报错了6666666666666666666666666666666666666"+e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getModel2Bounced(HashMap<String, String> params, final CallBack callBack) {
        service.getPop2(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<Bounced2Bean>(){
                    @Override
                    public void onNext(Bounced2Bean bounced2Bean) {
                        Log.i("sss", "onNext: "+ bounced2Bean.getResult());
                        callBack.Success(bounced2Bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("报错了6666666666666666666666666666666666666"+e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
