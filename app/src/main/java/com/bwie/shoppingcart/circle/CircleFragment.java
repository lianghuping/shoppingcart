package com.bwie.shoppingcart.circle;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.shoppingcart.R;
import com.bwie.shoppingcart.circle.adapter.CircleAdapter;
import com.bwie.shoppingcart.circle.bean.CircleBean;
import com.bwie.shoppingcart.home.mvp.contract.CircleContractClass;
import com.bwie.shoppingcart.home.mvp.presenter.CirclePresenter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CircleFragment extends Fragment implements CircleContractClass.MainView {


    @BindView(R.id.xrecy)
    XRecyclerView xrecy;
    Unbinder unbinder;
    private CirclePresenter circlePresenter;
    private CircleAdapter circleAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Fresco.initialize(getActivity());

        View view = inflater.inflate(R.layout.frag_circle, container, false);

        unbinder = ButterKnife.bind(this, view);

        circlePresenter = new CirclePresenter(this);

        HashMap<String,String> map = new HashMap<>();
        map.put("page","1");
        map.put("count","50");
        circlePresenter.getPresenterCircle(map);

        xrecy.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }




    @Override
    public void CircleSuccess(Object result) {

        CircleBean circleBean = (CircleBean) result;

        List<CircleBean.ResultBean> result1 = circleBean.getResult();

        circleAdapter = new CircleAdapter(getActivity(), result1);

        xrecy.setAdapter(circleAdapter);


        xrecy.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                xrecy.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                xrecy.loadMoreComplete();
            }
        });

    }

    @Override
    public void CircleError(Object msg) {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }

}
