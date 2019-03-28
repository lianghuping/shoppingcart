package com.bwie.shoppingcart.home.mvp.model;

import android.util.Log;

import com.bwie.shoppingcart.home.bean.AttributionBean;
import com.bwie.shoppingcart.home.mvp.api.ApiService;
import com.bwie.shoppingcart.home.mvp.api.CallBack;
import com.bwie.shoppingcart.home.mvp.contract.AttributionContractClass;
import com.bwie.shoppingcart.home.mvp.util.RetrofitUtil;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class AttributionModel implements AttributionContractClass.MainModel {

    private ApiService service;


    @Override
    public void getModelAttribution(HashMap<String, String> params, final CallBack callBack) {
        service = RetrofitUtil.getInstance().create(ApiService.class);
        service.getGuiShu(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<AttributionBean>(){
                    @Override
                    public void onNext(AttributionBean attributionBean) {
                        Log.i("sss", "onNext: "+ attributionBean.getResult());
                        callBack.Success(attributionBean);
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
