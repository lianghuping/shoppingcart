package com.bwie.shoppingcart.home.mvp.presenter;

import android.util.Log;

import com.bwie.shoppingcart.home.mvp.api.CallBack;
import com.bwie.shoppingcart.home.mvp.contract.SearchContractClass;
import com.bwie.shoppingcart.home.mvp.model.SearchModel;

import java.util.HashMap;

public class HomePresenter extends SearchContractClass.MainPresenter {


    private SearchContractClass.MainView mainView;
    private SearchModel mModel;

    public HomePresenter(SearchContractClass.MainView mainView){
        this.mainView = mainView ;
        mModel = new SearchModel();
    }


    @Override
    public void getPresenterSearch(HashMap<String, String> params) {
        mModel.getModelSearch(params, new CallBack() {
            @Override
            public void Success(Object result) {
                Log.e("lhp", "P is going  success" );
                mainView.SearchSuccess(result);
            }

            @Override
            public void Error(Object msg) {
                Log.e("lhp", "P is going  faild" );
                mainView.SearchError(msg);
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
