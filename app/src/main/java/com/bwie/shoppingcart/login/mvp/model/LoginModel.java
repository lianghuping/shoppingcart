package com.bwie.shoppingcart.login.mvp.model;

import com.bwie.shoppingcart.login.mvp.util.CallBack;

public interface LoginModel {

    void getCa(CallBack callBack, int tag, String phone, String pwd);


}
