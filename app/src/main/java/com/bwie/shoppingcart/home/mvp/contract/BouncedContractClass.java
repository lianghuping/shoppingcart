package com.bwie.shoppingcart.home.mvp.contract;

import com.bwie.shoppingcart.home.mvp.api.CallBack;

import java.util.HashMap;

public interface BouncedContractClass {


    interface MainView {
        void BouncedSuccess(Object result);
        void BouncedError(Object msg);
        void Bounced2Success(Object result);
        void Bounced2Error(Object msg);
    }

    //m
    interface MainModel {

        void getModelBounced(CallBack callBack);
        void getModel2Bounced(HashMap<String,String>params, CallBack callBack);
    }

    //p
    public abstract class MainPresenter{

        public abstract void getPresenterBounced();
        public abstract void getPresenterBounced2(HashMap<String,String>params);

    }





}
