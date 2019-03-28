package com.bwie.shoppingcart.home.mvp.model;

import android.util.Log;

import com.bwie.shoppingcart.home.bean.DetailsBean;
import com.bwie.shoppingcart.home.mvp.api.ApiService;
import com.bwie.shoppingcart.home.mvp.api.CallBack;
import com.bwie.shoppingcart.home.mvp.contract.DetailsContractClass;
import com.bwie.shoppingcart.home.mvp.util.RetrofitUtil;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class DetailsModel implements DetailsContractClass.MainModel {

    private ApiService service;

    @Override
    public void getModelDetails(HashMap<String, String> params, final CallBack callBack) {
        service = RetrofitUtil.getInstance().create(ApiService.class);
        service.getXiang(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<DetailsBean>(){
                    @Override
                    public void onNext(DetailsBean detailsBean) {

                        callBack.Success(detailsBean);
                        Log.i("sss", "SWEE "+ detailsBean.getResult().toString());

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
