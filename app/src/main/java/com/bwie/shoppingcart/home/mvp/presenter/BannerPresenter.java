package com.bwie.shoppingcart.home.mvp.presenter;

import com.bwie.shoppingcart.home.mvp.api.CallBack;
import com.bwie.shoppingcart.home.mvp.contract.HomeContractClass;
import com.bwie.shoppingcart.home.mvp.model.BannerModel;

public class BannerPresenter extends HomeContractClass.MainPresenter {

    private HomeContractClass.MainView mainView;
    private BannerModel bannerModel;

    public BannerPresenter(HomeContractClass.MainView mainView){
        this.mainView = mainView ;
        bannerModel = new BannerModel();
    }

    @Override
    public void getPresenter() {
        bannerModel.getModel(new CallBack() {
            @Override
            public void Success(Object result) {
                mainView.Success(result);
            }

            @Override
            public void Error(Object msg) {

            }
        });
    }

    @Override
    public void getPresenterHome() {
        bannerModel.getModelHome(new CallBack() {
            @Override
            public void Success(Object result) {
                mainView.HomeSuccess(result);
            }

            @Override
            public void Error(Object msg) {

            }
        });
    }




    public void onDestroy(){
        if(bannerModel !=null){
            bannerModel = null;
        }else if(mainView!=null){
            mainView = null;
        }
    }
}
