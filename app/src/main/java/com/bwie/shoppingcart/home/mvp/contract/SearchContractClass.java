package com.bwie.shoppingcart.home.mvp.contract;

import com.bwie.shoppingcart.home.mvp.api.CallBack;

import java.util.HashMap;

public interface SearchContractClass {


    interface MainView {
        void SearchSuccess(Object result);
        void SearchError(Object msg);
    }

    //m
    interface MianModel {

        void getModelSearch(HashMap<String,String>params,CallBack callBack);
    }

    //p
    public abstract class MainPresenter{

        public abstract void getPresenterSearch(HashMap<String,String>params);

    }





}
