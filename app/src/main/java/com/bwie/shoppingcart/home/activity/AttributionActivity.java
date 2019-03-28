package com.bwie.shoppingcart.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.bwie.shoppingcart.R;
import com.bwie.shoppingcart.home.adapter.AttributionAdapter;
import com.bwie.shoppingcart.home.bean.AttributionBean;
import com.bwie.shoppingcart.home.mvp.contract.AttributionContractClass;
import com.bwie.shoppingcart.home.mvp.presenter.AttributionPresenter;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AttributionActivity extends AppCompatActivity implements AttributionContractClass.MainView {

    @BindView(R.id.rvGs)
    RecyclerView rvGs;
    private AttributionPresenter attributionPresenter;
    private AttributionAdapter attributionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_attribution);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String idr = String.valueOf(intent.getExtras().getInt("ids"));

        Toast.makeText(AttributionActivity.this,idr, Toast.LENGTH_SHORT).show();

        attributionPresenter = new AttributionPresenter(this);

        if(idr.equals("1002")){
            HashMap<String, String> map = new HashMap<>();
            map.put("labelId", idr);
            map.put("page", "1");
            map.put("count", "10");
            attributionPresenter.getPresenterAttribution(map);

        }else if(idr.equals("1003")){

            HashMap<String, String> map = new HashMap<>();
            map.put("labelId", idr);
            map.put("page", "1");
            map.put("count", "10");
            attributionPresenter.getPresenterAttribution(map);

        }else if(idr.equals("1004")){

            HashMap<String, String> map = new HashMap<>();
            map.put("labelId", idr);
            map.put("page", "1");
            map.put("count", "10");
            attributionPresenter.getPresenterAttribution(map);
        }


        rvGs.setLayoutManager(new GridLayoutManager(this,2));



    }

    @Override
    public void AttributionSuccess(Object result) {

        AttributionBean attributionBean = (AttributionBean) result;

        Log.e("tag1",""+ attributionBean.getResult());

        List<AttributionBean.ResultBean> result1 = attributionBean.getResult();

        Log.e("tag",""+result1);

        attributionAdapter = new AttributionAdapter(this, result1);

        rvGs.setAdapter(attributionAdapter);

    }

    @Override
    public void AttributionError(Object msg) {

    }
}
