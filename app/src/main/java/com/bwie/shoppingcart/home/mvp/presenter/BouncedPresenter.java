package com.bwie.shoppingcart.home.mvp.presenter;

import android.util.Log;

import com.bwie.shoppingcart.home.mvp.api.CallBack;
import com.bwie.shoppingcart.home.mvp.contract.BouncedContractClass;
import com.bwie.shoppingcart.home.mvp.model.BouncedModel;

import java.util.HashMap;

public class BouncedPresenter extends BouncedContractClass.MainPresenter {


    private BouncedContractClass.MainView mainView;
    private BouncedModel mModel;

    public BouncedPresenter(BouncedContractClass.MainView mainView){
        this.mainView = mainView ;
        mModel = new BouncedModel();
    }

    @Override
    public void getPresenterBounced() {
        mModel.getModelBounced(new CallBack() {
            @Override
            public void Success(Object result) {
                mainView.BouncedSuccess(result);
            }

            @Override
            public void Error(Object msg) {
                mainView.BouncedError(msg);
            }
        });
    }

    @Override
    public void getPresenterBounced2(HashMap<String, String> params) {
        mModel.getModel2Bounced(params, new CallBack() {
            @Override
            public void Success(Object result) {
                Log.e("lhp", "P请求数据成功"+result.toString() );
                mainView.Bounced2Success(result);
            }

            @Override
            public void Error(Object msg) {
                Log.e("lhp", "P请求数据失败" );
                mainView.Bounced2Error(msg);

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
