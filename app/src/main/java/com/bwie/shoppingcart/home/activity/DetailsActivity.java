package com.bwie.shoppingcart.home.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bwie.shoppingcart.R;
import com.bwie.shoppingcart.home.adapter.DetailsAdapter;
import com.bwie.shoppingcart.home.bean.DetailsBean;
import com.bwie.shoppingcart.home.mvp.contract.DetailsContractClass;
import com.bwie.shoppingcart.home.mvp.presenter.DetailsPresenter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;


public class DetailsActivity extends AppCompatActivity implements DetailsContractClass.MainView {


    private TextView price,title,yishou,weight;
    private ImageView img;
    private XBanner banner;
    private WebView webView;
    private TextView details_textview_describe;
    private ImageView imageView;
    private DetailsPresenter detailsPresenter;
    private DetailsAdapter detailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        price = findViewById(R.id.Price);
        title=findViewById(R.id.titlea);
        yishou=findViewById(R.id.yiShou);
        weight=findViewById(R.id.weight);
        banner = findViewById(R.id.banner);
        webView = findViewById(R.id.webview);
        details_textview_describe = findViewById(R.id.describe);
        imageView = findViewById(R.id.details_image_return);

        getSupportActionBar().hide();

        Intent intent = getIntent();
        int id = intent.getExtras().getInt("ids");
        Toast.makeText(DetailsActivity.this, ""+id, Toast.LENGTH_SHORT).show();


        detailsPresenter = new DetailsPresenter(this);

        HashMap<String, String> map = new HashMap<>();
        map.put("commodityId", ""+id);
        detailsPresenter.getPresenterDetails(map);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    @Override
    public void DetailsSuccess(Object result) {

        DetailsBean detailsBean = (DetailsBean) result;

        DetailsBean.ResultBean result1 = detailsBean.getResult();
        Log.e("res",""+result1.getPrice());
        int pricea = result1.getPrice();
        Log.e("re",""+pricea);
        price.setText("￥:"+pricea);
        details_textview_describe.setText(result1.getDescribe());
        title.setText(result1.getCommodityName());
        yishou.setText("已售"+result1.getCommentNum()+"件");
        weight.setText(result1.getWeight()+"kg");
        String[] split = result1.getPicture().split(",");
        final List<String> arr= Arrays.asList(split);
        banner.setData(arr,null);
        banner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner xBanner, Object o, View view, int i) {
                Glide.with(DetailsActivity.this).load(arr.get(i)).into((ImageView) view);
            }
        });
        // 设置XBanner的页面切换特效，选择一个即可，总的大概就这么多效果啦，欢迎使用
       /* banner.setPageTransformer(Transformer.Default);//横向移动

        banner.setPageTransformer(Transformer.Alpha); //渐变，效果不明显*/

        banner.setPageTransformer(Transformer.Rotate);  //单页旋转

       /* banner.setPageTransformer(Transformer.Cube);    //立体旋转

        banner.setPageTransformer(Transformer.Flip);  // 反转效果

        banner.setPageTransformer(Transformer.Accordion); //三角换页*/

       /* banner.setPageTransformer(Transformer.ZoomFade); // 缩小本页，同时放大另一页

        banner.setPageTransformer(Transformer.ZoomCenter); //本页缩小一点，另一页就放大

        banner.setPageTransformer(Transformer.ZoomStack); // 本页和下页同事缩小和放大

        banner.setPageTransformer(Transformer.Stack);  //本页和下页同时左移

        banner.setPageTransformer(Transformer.Depth);  //本页左移，下页从后面出来

        banner.setPageTransformer(Transformer.Zoom);  //本页刚左移，下页就在后面*/
        // 设置XBanner页面切换的时间，即动画时长
        banner.setPageChangeDuration(1000);
        webView.loadData(result1.getDetails(),"text/html","UTF-8");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);                                                                 // 设置与Js交互的权限
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);                                            // 设置允许JS弹窗
        webSettings.setDomStorageEnabled(true);                                                                 //设置允许Dom存储
        webSettings.setUseWideViewPort(true);                                                           //设置加载进来的页面自适应手机屏幕
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(true);                                                                   // 设置可以支持缩放
        webSettings.setBuiltInZoomControls(true);                                                           // 设置出现缩放工具
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);//自适应屏幕
        webView.loadData(result1.getDetails(), "text/html;charset=utf-8", "utf-8");                //载入js代码
    }

    @Override
    public void DetailsError(Object msg) {

    }
}
