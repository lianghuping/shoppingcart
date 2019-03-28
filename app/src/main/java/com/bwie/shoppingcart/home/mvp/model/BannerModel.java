package com.bwie.shoppingcart.home.mvp.model;

import com.bwie.shoppingcart.home.bean.BannerBean;
import com.bwie.shoppingcart.home.bean.HomeBean;
import com.bwie.shoppingcart.home.mvp.api.ApiService;
import com.bwie.shoppingcart.home.mvp.api.CallBack;
import com.bwie.shoppingcart.home.mvp.contract.HomeContractClass;
import com.bwie.shoppingcart.home.mvp.util.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class BannerModel implements HomeContractClass.MianModel {


    private ApiService service;

    @Override
    public void getModel(final CallBack callBack) {

        service = RetrofitUtil.getInstance().create(ApiService.class);
        service.getBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<BannerBean>(){

                    @Override
                    public void onNext(BannerBean bannerBean) {
                        callBack.Success(bannerBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void getModelHome(final CallBack callBack) {
        service.getHome()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<HomeBean>(){

                    @Override
                    public void onNext(HomeBean homeBean) {
                        callBack.Success(homeBean);
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
