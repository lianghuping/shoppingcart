package com.bwie.shoppingcart.home.mvp.contract;

import com.bwie.shoppingcart.home.mvp.api.CallBack;

import java.util.HashMap;

public interface CircleContractClass {


    interface MainView {
        void CircleSuccess(Object result);
        void CircleError(Object msg);
    }

    //m
    interface MainModel {

        void getModelCircle(HashMap<String, String> params, CallBack callBack);
    }

    //p
    public abstract class MainPresenter{

        public abstract void getPresenterCircle(HashMap<String,String>params);

    }





}
