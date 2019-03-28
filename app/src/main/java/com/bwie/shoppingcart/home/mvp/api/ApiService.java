package com.bwie.shoppingcart.home.mvp.api;

import com.bwie.shoppingcart.circle.bean.CircleBean;
import com.bwie.shoppingcart.home.bean.BannerBean;
import com.bwie.shoppingcart.home.bean.AttributionBean;
import com.bwie.shoppingcart.home.bean.HomeBean;
import com.bwie.shoppingcart.home.bean.Bounced2Bean;
import com.bwie.shoppingcart.home.bean.BouncedBean;
import com.bwie.shoppingcart.home.bean.SearchBean;
import com.bwie.shoppingcart.home.bean.DetailsBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiService {

    @GET(Api.urlStrings)
    Observable<BannerBean> getBanner();

    @GET(Api.shuString)
    Observable<HomeBean> getHome();

    @GET(Api.souSTRING)
    Observable<SearchBean> getSou(@QueryMap HashMap<String,String>params);

    @GET(Api.xiangSTRING)
    Observable<DetailsBean> getXiang(@QueryMap HashMap<String,String>params);

    @GET(Api.guishuSTRING)
    Observable<AttributionBean> getGuiShu(@QueryMap HashMap<String,String>params);

    @GET(Api.popSTRING)
    Observable<BouncedBean> getPop();

    @GET(Api.pop2STRING)
    Observable<Bounced2Bean> getPop2(@QueryMap HashMap<String,String>params);

    @GET(Api.quanSTRING)
    Observable<CircleBean> getQuan(@QueryMap HashMap<String,String>params);
}
