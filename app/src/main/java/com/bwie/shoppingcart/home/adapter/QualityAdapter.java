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
import com.bwie.shoppingcart.home.bean.HomeBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class QualityAdapter extends RecyclerView.Adapter<QualityAdapter.MyView> {

    List<HomeBean.ResultEntity.PzshEntity.CommodityListEntity> commodityListEntities;
    Context context;



    public QualityAdapter(List<HomeBean.ResultEntity.PzshEntity.CommodityListEntity> commodityListEntities, Context context) {
        this.commodityListEntities = commodityListEntities;
        this.context = context;
    }

    public void setList(List<HomeBean.ResultEntity.PzshEntity.CommodityListEntity> commodityListEntities) {
        this.commodityListEntities = commodityListEntities;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public QualityAdapter.MyView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.iteam_home_quality, viewGroup, false);
        MyView myView = new MyView(view);
        return myView;
    }

    @Override
    public void onBindViewHolder(@NonNull QualityAdapter.MyView myView, final int i) {

        Uri parse = Uri.parse(commodityListEntities.get(i).getMasterPic());

        myView.img3.setImageURI(parse);

        myView.title3.setText(commodityListEntities.get(i).getCommodityName());
        myView.price3.setText("￥: "+commodityListEntities.get(i).getPrice()+".00");

        myView.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("ids",commodityListEntities.get(i).getCommodityId());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return commodityListEntities.size();
    }

    public class MyView extends RecyclerView.ViewHolder{

        private final SimpleDraweeView img3;
        private final TextView price3;
        private final TextView title3;

        public MyView(@NonNull View itemView) {
            super(itemView);
            Fresco.initialize(context);
            img3 = itemView.findViewById(R.id.img3);
            price3 = itemView.findViewById(R.id.price3);
            title3 = itemView.findViewById(R.id.title3);



        }
    }


}
