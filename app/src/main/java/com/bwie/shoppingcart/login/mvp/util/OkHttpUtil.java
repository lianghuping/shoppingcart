package com.bwie.shoppingcart.login.mvp.util;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtil {

    static String info = "";

    private static OkHttpUtil okHttpUtil = null;

    private OkHttpUtil(){

    };

    //封装单例
    private static OkHttpUtil getInstance(){

        if(okHttpUtil==null){

            okHttpUtil = new OkHttpUtil();

        }else{
            return okHttpUtil;
        }

        return okHttpUtil;
    }

    //请求doPost方法
    public static void doPost(final Handler handler, int tag, String phone, String pwd){

        String url = "";
        if(tag == 0){
            url = "http://172.17.8.100/small/user/v1/login";
        }else{
            url = "http://172.17.8.100/small/user/v1/register";
        }

        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("phone",phone)
                .add("pwd",pwd)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {



            @Override
            public void onFailure(Call call, IOException e) {
                info = "请求失败";
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String string = response.body().string();

                try {

                    JSONObject jsonObject = new JSONObject(string);
                    info = jsonObject.getString("message");
                    Log.e("tag",info);
                    Message message = new Message();
                    message.obj=info;
                    handler.sendMessage(message);

                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        });

    }




}
