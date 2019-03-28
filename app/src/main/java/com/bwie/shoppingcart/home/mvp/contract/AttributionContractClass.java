package com.bwie.shoppingcart.home.mvp.contract;

import com.bwie.shoppingcart.home.mvp.api.CallBack;

import java.util.HashMap;

public interface AttributionContractClass {


    interface MainView {
        void AttributionSuccess(Object result);
        void AttributionError(Object msg);
    }

    //m
    interface MainModel {

        void getModelAttribution(HashMap<String, String> params, CallBack callBack);
    }

    //p
    public abstract class MainPresenter{

        public abstract void getPresenterAttribution(HashMap<String,String>params);

    }





}
