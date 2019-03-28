package com.bwie.shoppingcart.home.mvp.model;

import android.util.Log;

import com.bwie.shoppingcart.home.bean.SearchBean;
import com.bwie.shoppingcart.home.mvp.api.ApiService;
import com.bwie.shoppingcart.home.mvp.api.CallBack;
import com.bwie.shoppingcart.home.mvp.contract.SearchContractClass;
import com.bwie.shoppingcart.home.mvp.util.RetrofitUtil;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class SearchModel implements SearchContractClass.MianModel {


    private ApiService service;
    @Override
    public void getModelSearch(HashMap<String, String> params, final CallBack callBack) {

        service = RetrofitUtil.getInstance().create(ApiService.class);
        service.getSou(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<SearchBean>(){
                    @Override
                    public void onNext(SearchBean searchBean) {
                        Log.i("lhp", "M is going success=="+ searchBean.getResult());
                        callBack.Success(searchBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("lhp", "M is going fail==1111" );
                    }

                    @Override
                    public void onComplete() {
                       // Log.i("lhp", "M is going fail==" );
                    }
                });
    }
}
