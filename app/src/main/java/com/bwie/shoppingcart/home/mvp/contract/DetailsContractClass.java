package com.bwie.shoppingcart.home.mvp.contract;

import com.bwie.shoppingcart.home.mvp.api.CallBack;

import java.util.HashMap;

/**
 * 详情
 */
public interface DetailsContractClass {


    interface MainView {
        void DetailsSuccess(Object result);
        void DetailsError(Object msg);
    }

    //m
    interface MainModel {

        void getModelDetails(HashMap<String, String> params, CallBack callBack);
    }

    //p
    public abstract class MainPresenter{

        public abstract void getPresenterDetails(HashMap<String,String>params);

    }





}
