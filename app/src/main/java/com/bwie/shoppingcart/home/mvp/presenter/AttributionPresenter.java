package com.bwie.shoppingcart.home.mvp.presenter;

import com.bwie.shoppingcart.home.mvp.api.CallBack;
import com.bwie.shoppingcart.home.mvp.contract.AttributionContractClass;
import com.bwie.shoppingcart.home.mvp.model.AttributionModel;

import java.util.HashMap;

public class AttributionPresenter extends AttributionContractClass.MainPresenter {


    private AttributionContractClass.MainView mainView;
    private AttributionModel mModel;

    public AttributionPresenter(AttributionContractClass.MainView mainView){
        this.mainView = mainView ;
        mModel = new AttributionModel();
    }

    @Override
    public void getPresenterAttribution(HashMap<String, String> params) {
        mModel.getModelAttribution(params, new CallBack() {
            @Override
            public void Success(Object result) {
                mainView.AttributionSuccess(result);
            }

            @Override
            public void Error(Object msg) {
                mainView.AttributionError(msg);
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
