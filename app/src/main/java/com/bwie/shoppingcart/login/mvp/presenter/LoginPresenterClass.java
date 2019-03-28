package com.bwie.shoppingcart.login.mvp.presenter;

import com.bwie.shoppingcart.login.mvp.model.LoginModelClass;
import com.bwie.shoppingcart.login.mvp.util.CallBack;
import com.bwie.shoppingcart.login.mvp.view.LoginView;

public class LoginPresenterClass implements LoginPresenter {

    private LoginModelClass loginModelClass;
    private LoginView loginView;

    public LoginPresenterClass(LoginView loginView){

        loginModelClass = new LoginModelClass();
        this.loginView = loginView;
    }


    @Override
    public void getLogin(final int tag, String phone, String pwd) {

        loginModelClass.getCa(new CallBack() {
            @Override
            public void Success(String result) {
                loginView.getShow(result,tag);
            }

            @Override
            public void Error(String msg) {
                loginView.getShow(msg,tag);
            }
        },tag,phone,pwd);


    }

    public void onDestory(){
        if(loginModelClass !=null){
            loginModelClass = null;
        }else if(loginView != null){
            loginView = null;
        }
    }


}


