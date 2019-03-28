package com.bwie.shoppingcart.home.mvp.model;

import android.util.Log;

import com.bwie.shoppingcart.circle.bean.CircleBean;
import com.bwie.shoppingcart.home.mvp.api.ApiService;
import com.bwie.shoppingcart.home.mvp.api.CallBack;
import com.bwie.shoppingcart.home.mvp.contract.CircleContractClass;
import com.bwie.shoppingcart.home.mvp.util.RetrofitUtil;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class CircleModel implements CircleContractClass.MainModel {

    private ApiService service;

    @Override
    public void getModelCircle(HashMap<String, String> params, final CallBack callBack) {
        service = RetrofitUtil.getInstance().create(ApiService.class);
        service.getQuan(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<CircleBean>(){
                    @Override
                    public void onNext(CircleBean circleBean) {

                        callBack.Success(circleBean);
                        Log.i("sss", "SWEE "+ circleBean.getResult().toString());

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.Error(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
