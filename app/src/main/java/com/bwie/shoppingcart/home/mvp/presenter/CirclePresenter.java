package com.bwie.shoppingcart.home.mvp.presenter;

import com.bwie.shoppingcart.home.mvp.api.CallBack;
import com.bwie.shoppingcart.home.mvp.contract.CircleContractClass;
import com.bwie.shoppingcart.home.mvp.model.CircleModel;

import java.util.HashMap;

public class CirclePresenter extends CircleContractClass.MainPresenter {


    private CircleContractClass.MainView mainView;
    private CircleModel mModel;

    public CirclePresenter(CircleContractClass.MainView mainView){
        this.mainView = mainView ;
        mModel = new CircleModel();
    }

    @Override
    public void getPresenterCircle(HashMap<String, String> params) {
        mModel.getModelCircle(params, new CallBack() {
            @Override
            public void Success(Object result) {
                mainView.CircleSuccess(result);
            }

            @Override
            public void Error(Object msg) {
                mainView.CircleError(msg);
            }
        });
    }


    public void onDestroy(){
        if(mModel!=null){
            mModel = null;
        }else if(mainView!=null){
            mainView = null;
        }
    }


}
