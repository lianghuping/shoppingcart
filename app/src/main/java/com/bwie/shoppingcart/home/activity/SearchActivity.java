package com.bwie.shoppingcart.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bwie.shoppingcart.R;
import com.bwie.shoppingcart.home.adapter.SearchAdapter;
import com.bwie.shoppingcart.home.bean.SearchBean;
import com.bwie.shoppingcart.home.mvp.contract.SearchContractClass;
import com.bwie.shoppingcart.home.mvp.presenter.HomePresenter;
import com.bwie.shoppingcart.home.view.Search2View;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity implements SearchContractClass.MainView {


    @BindView(R.id.views)
    Search2View views;
    @BindView(R.id.sou_rv)
    RecyclerView souRv;
    private HomePresenter homePresenter;
    private SearchAdapter searchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fresco.initialize(this);

        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        getSupportActionBar().hide();



        homePresenter = new HomePresenter(this);


        initData();

        views.sou1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        souRv.setLayoutManager(new GridLayoutManager(this,2));
        searchAdapter = new SearchAdapter(this);
        views.kuang1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ss = views.serachview1.getText().toString();

                if(ss.equals("") && ss != null){
                    Toast.makeText(SearchActivity.this,"没有数据或者数据收不到",Toast.LENGTH_LONG).show();
                   /* HashMap<String, String> map = new HashMap<>();
                    map.put("keyword","");
                    map.put("page", "1");
                    map.put("count", "10");
                    homePresenter.getPresenterSou(map);*/
                }else{
                    HashMap<String, String> map = new HashMap<>();
                    map.put("keyword",ss);
                    map.put("page", "1");
                    map.put("count", "10");
                    homePresenter.getPresenterSearch(map);
                }
            }
        });





    }

    private void initData() {

        Intent intent1 = getIntent();
        String name = intent1.getStringExtra("names");
       /* Toast.makeText(this,name,Toast.LENGTH_SHORT).show();*/
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("keyword", name);
        map2.put("page", "1");
        map2.put("count", "10");
        Log.e("lhp", "拼接口"+map2.toString() );
        homePresenter.getPresenterSearch(map2);
      /*  pop_houAdapter = new Pop_houAdapter(this);
        souRv.setLayoutManager(new GridLayoutManager(this,2));
        souRv.setAdapter(pop_houAdapter);*/

    }


    @Override
    public void SearchSuccess(Object result) {

       SearchBean searchBean = (SearchBean) result;

        Log.e("lhp","回调"+ searchBean.getResult());

        List<SearchBean.ResultEntity> result1 = searchBean.getResult();

        souRv.setAdapter(searchAdapter);

        searchAdapter.setListEntities(result1);





    }

    @Override
    public void SearchError(Object msg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        homePresenter.onDestroy();
    }
}
