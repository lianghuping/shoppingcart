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

public class MagicAdapter extends RecyclerView.Adapter<MagicAdapter.MyView> {

    List<HomeBean.ResultEntity.MlssEntity.CommodityListEntity> listEntities;
    Context context;

    public MagicAdapter(List<HomeBean.ResultEntity.MlssEntity.CommodityListEntity> listEntities, Context context) {
        this.listEntities = listEntities;
        this.context = context;
    }

    public void setListEntities(List<HomeBean.ResultEntity.MlssEntity.CommodityListEntity> listEntities) {
        this.listEntities = listEntities;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MagicAdapter.MyView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.iteam_home_magic, viewGroup, false);
        MyView myView = new MyView(view);
        return myView;
    }

    @Override
    public void onBindViewHolder(@NonNull MagicAdapter.MyView myView, final int i) {
        Uri parse = Uri.parse(listEntities.get(i).getMasterPic());

        myView.img2.setImageURI(parse);

        myView.title2.setText(listEntities.get(i).getCommodityName());
        myView.price2.setText("￥: "+listEntities.get(i).getPrice());

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

        private final SimpleDraweeView img2;
        private final TextView price2;
        private final TextView title2;

        public MyView(@NonNull View itemView) {
            super(itemView);
            Fresco.initialize(context);
            img2 = itemView.findViewById(R.id.img2);
            price2 = itemView.findViewById(R.id.price2);
            title2 = itemView.findViewById(R.id.title2);



        }
    }
}
