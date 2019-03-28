package com.bwie.shoppingcart.home.mvp.contract;

import com.bwie.shoppingcart.home.mvp.api.CallBack;

/**
 * 主页面
 */
public interface HomeContractClass {

    //v
    interface MainView{
        void Success(Object result);
        void Error(Object msg);
        void HomeSuccess(Object result);
        void HomeError(Object msg);


    }
    //m
    interface MianModel {
            void getModel(CallBack callBack);
            void getModelHome(CallBack callBack);

    }

    //p
    public abstract class MainPresenter{
        public abstract void getPresenter();
        public abstract void getPresenterHome();

    }





}
