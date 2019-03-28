package com.bwie.shoppingcart.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.shoppingcart.R;
import com.bwie.shoppingcart.home.activity.DetailsActivity;
import com.bwie.shoppingcart.home.bean.SearchBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyView> {

    List<SearchBean.ResultEntity> listEntities;
    Context context;

    public SearchAdapter(Context context) {
        listEntities = new ArrayList<>();
        this.context = context;
    }

    public void setListEntities(List<SearchBean.ResultEntity> listEntities) {
        this.listEntities.clear();
        if(listEntities!=null){
            this.listEntities = listEntities;
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchAdapter.MyView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.iteam_search, viewGroup, false);
        MyView myView = new MyView(view);
        return myView;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.MyView myView, final int i) {
        Uri parse = Uri.parse(listEntities.get(i).getMasterPic());

        myView.sou_img1.setImageURI(parse);

        myView.sou_title1.setText(listEntities.get(i).getCommodityName());
        myView.sou_price1.setText("￥: "+listEntities.get(i).getPrice());

        myView.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("ids",listEntities.get(i).getCommodityId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listEntities.size();
    }

    public class MyView extends RecyclerView.ViewHolder{

        private final SimpleDraweeView sou_img1;
        private final TextView sou_title1;
        private final TextView sou_price1;

        public MyView(@NonNull View itemView) {
            super(itemView);
            Fresco.initialize(context);
            sou_img1 = itemView.findViewById(R.id.sou_img1);
            sou_title1 = itemView.findViewById(R.id.sou_title1);
            sou_price1 = itemView.findViewById(R.id.sou_price1);



        }
    }
}
