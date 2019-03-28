package com.bwie.shoppingcart.login.mvp.model;

import android.os.Handler;
import android.os.Message;

import com.bwie.shoppingcart.login.mvp.util.CallBack;
import com.bwie.shoppingcart.login.mvp.util.OkHttpUtil;

public class LoginModelClass implements LoginModel {

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String s = (String) msg.obj;
            if(s.contains("成功")){
                callBack.Success(s);
            }else{
                callBack.Error(s);
            }
        }
    };
    private CallBack callBack;

    @Override
    public void getCa(CallBack callBack, int tag, String phone, String pwd) {
        this.callBack = callBack;
        OkHttpUtil.doPost(handler,tag,phone,pwd);


    }
}


