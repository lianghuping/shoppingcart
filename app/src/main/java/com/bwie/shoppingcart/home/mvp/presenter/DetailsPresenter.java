package com.bwie.shoppingcart.home.mvp.presenter;

import com.bwie.shoppingcart.home.mvp.api.CallBack;
import com.bwie.shoppingcart.home.mvp.contract.DetailsContractClass;
import com.bwie.shoppingcart.home.mvp.model.DetailsModel;

import java.util.HashMap;

public class DetailsPresenter extends DetailsContractClass.MainPresenter {


    private DetailsContractClass.MainView mainView;
    private DetailsModel mModel;

    public DetailsPresenter(DetailsContractClass.MainView mainView){
        this.mainView = mainView ;
        mModel = new DetailsModel();
    }

    @Override
    public void getPresenterDetails(HashMap<String, String> params) {
        mModel.getModelDetails(params, new CallBack() {
            @Override
            public void Success(Object result) {
                mainView.DetailsSuccess(result);
            }

            @Override
            public void Error(Object msg) {
                mainView.DetailsError(msg);
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
