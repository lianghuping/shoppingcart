package com.bwie.shoppingcart.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.shoppingcart.R;
import com.bwie.shoppingcart.home.bean.DetailsBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.MyView> {


    DetailsBean.ResultBean result1;
    Context context;



    public DetailsAdapter(Context context, DetailsBean.ResultBean result1) {
        this.context = context;
        this.result1=result1;
    }

    public void setList(DetailsBean.ResultBean resultBeans) {
        this.result1 = resultBeans;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.iteam_details, viewGroup, false);
        MyView myView = new MyView(view);
        return myView;
    }

    @Override
    public void onBindViewHolder(@NonNull MyView myView, int i) {



        myView.title4.setText(result1.getCategoryName());
        myView.price4.setText(result1.getPrice()+"");


    }


    @Override
    public int getItemCount() {
        return 1;
    }


    public class MyView extends RecyclerView.ViewHolder {


        private final TextView price4;
        private final TextView title4;
        private final SimpleDraweeView img4;

        public MyView(@NonNull View itemView) {
            super(itemView);
            Fresco.initialize(context);

             price4 = itemView.findViewById(R.id.price4);
            title4 = itemView.findViewById(R.id.title4);
            img4 = itemView.findViewById(R.id.img4);


        }


    }


}
