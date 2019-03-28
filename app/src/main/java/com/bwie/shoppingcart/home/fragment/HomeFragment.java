package com.bwie.shoppingcart.home.fragment;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.bwie.shoppingcart.R;
import com.bwie.shoppingcart.home.activity.SearchActivity;
import com.bwie.shoppingcart.home.adapter.HomeAdapter;
import com.bwie.shoppingcart.home.adapter.Bounced2Adapter;
import com.bwie.shoppingcart.home.adapter.BouncedAdapter;
import com.bwie.shoppingcart.home.bean.BannerBean;
import com.bwie.shoppingcart.home.bean.HomeBean;
import com.bwie.shoppingcart.home.bean.Bounced2Bean;
import com.bwie.shoppingcart.home.bean.BouncedBean;
import com.bwie.shoppingcart.home.mvp.contract.HomeContractClass;
import com.bwie.shoppingcart.home.mvp.contract.BouncedContractClass;
import com.bwie.shoppingcart.home.mvp.presenter.BannerPresenter;
import com.bwie.shoppingcart.home.mvp.presenter.BouncedPresenter;
import com.bwie.shoppingcart.home.view.SearchView;
import com.bwie.shoppingcart.home.view.Search2View;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends Fragment implements HomeContractClass.MainView,BouncedContractClass.MainView,BouncedAdapter.setOnClickListen {

    @BindView(R.id.view)
    SearchView viewss;
    @BindView(R.id.xrv)
    XRecyclerView xrv;


    private BannerPresenter bannerPresenter;
    private HomeAdapter adapter;
    private Unbinder bind;
    private List<BannerBean.ResultEntity> list;
    private BannerBean bannerBean;
    private Search2View views;
    private RecyclerView pop1;
    private RecyclerView pop2;
    private BouncedAdapter bouncedAdapter;

    private BouncedPresenter bouncedPresenter;
    private Bounced2Adapter bounced2Adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Fresco.initialize(getActivity());
        View view = inflater.inflate(R.layout.frag_home, container, false);





        bind = ButterKnife.bind(this, view);

        views = view.findViewById(R.id.views);

        viewss.kuang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),SearchActivity.class);
                startActivity(intent);
            }
        });



        bannerPresenter = new BannerPresenter(this);
        bouncedPresenter = new BouncedPresenter(this);
        bannerPresenter.getPresenter();
        bannerPresenter.getPresenterHome();

        xrv.setLayoutManager(new LinearLayoutManager(getActivity()));

        viewss.sou.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                bouncedPresenter.getPresenterBounced();
                View view = getLayoutInflater().inflate(R.layout.home_bounced_layout, null);
                PopupWindow popupWindow = new PopupWindow(view,  440, 320, true);
                popupWindow.setFocusable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(R.layout.img_bounced));
                popupWindow.setOutsideTouchable(true);
                popupWindow.showAsDropDown(viewss, 30, -10);
                 pop1 = view.findViewById(R.id.pop1);
                pop2 = view.findViewById(R.id.pop2);
                bouncedAdapter = new BouncedAdapter();
                bouncedAdapter.setSetOnClickListen(HomeFragment.this);
                pop1.setLayoutManager(new LinearLayoutManager(getActivity()));
                pop1.setAdapter(bouncedAdapter);
                bounced2Adapter = new Bounced2Adapter();
                pop2.setLayoutManager(new StaggeredGridLayoutManager(getActivity(), null, 1 , 3));
                pop2.setAdapter(bounced2Adapter);
            }
        });

        return view;
    }


    @Override
    public void Success(Object result) {

        bannerBean = (BannerBean) result;
        String status = bannerBean.status;
//        if ("0000".equals(status)) {
//
//            list = bannerBean.getResult();
//            banner.setData(list, null);
//            banner.loadImage(new XBanner.XBannerAdapter() {
//                @Override
//                public void loadBanner(XBanner banner, Object model, View view, int position) {
//                    Glide.with(getActivity()).load(list.get(position).getImageUrl()).into((ImageView) view);
//
//                    banner.setPageChangeDuration(1000);
//
//                }
//            });
//        }

        xrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                xrv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                xrv.loadMoreComplete();
            }
        });

    }

    @Override
    public void Error(Object msg) {

    }

    @Override
    public void HomeSuccess(Object result) {

        Log.e("tag","+++"+result.toString());

        HomeBean homeBean = (HomeBean) result;

        HomeBean.ResultEntity result1 = homeBean.getResult();

        Log.e("tag","+++"+ result1.getMlss().getName());

        adapter = new HomeAdapter(getActivity(),homeBean,bannerBean);

        xrv.setAdapter(adapter);

        adapter.notifyDataSetChanged();



    }

    @Override
    public void HomeError(Object msg) {

    }

    @Override
    public void BouncedSuccess(Object result) {
        BouncedBean bouncedBean = (BouncedBean) result;
        List<BouncedBean.ResultBean> result2 = bouncedBean.getResult();
        Log.e("tag1",""+result2);
        bouncedAdapter.setResult2(result2);
    }

    @Override
    public void BouncedError(Object msg) {

    }

    @Override
    public void Bounced2Success(Object result) {
        Bounced2Bean bounced2Bean1 = (Bounced2Bean) result;
        Log.e("lhp", "二级请求数据返回Fragment "+ bounced2Bean1.getMessage() );
        Bounced2Bean bounced2Bean = (Bounced2Bean) result;
        List<Bounced2Bean.ResultBean> resultBeanList = bounced2Bean.getResult();
        bounced2Adapter.setResult2(resultBeanList);
    }

    @Override
    public void Bounced2Error(Object msg) {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bannerPresenter.onDestroy();
        bind.unbind();
    }


    @Override
    public void getPop(String id) {
        getPopWin(id);
        Log.e("lhp", "接口huidiaoid "+id );
    }

    private void getPopWin(String id) {

        HashMap<String,String> map = new HashMap<>();
        map.put("firstCategoryId",id);
        bouncedPresenter.getPresenterBounced2(map);

    }
}
