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
import com.bwie.shoppingcart.home.bean.AttributionBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class AttributionAdapter extends RecyclerView.Adapter<AttributionAdapter.MyView> {

    Context context;
    List<AttributionBean.ResultBean> list;

    public AttributionAdapter(Context context, List<AttributionBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AttributionAdapter.MyView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.iteam_attribution,viewGroup,false);
        MyView myView = new MyView(view);
        return myView;
    }

    @Override
    public void onBindViewHolder(@NonNull AttributionAdapter.MyView myView, final int i) {


        Uri parse = Uri.parse(list.get(i).getMasterPic());
        myView.gui_img.setImageURI(parse);

        myView.gui_title.setText(list.get(i).getCommodityName());
        myView.gui_price.setText(list.get(i).getPrice()+"");

        myView.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("ids",list.get(i).getCommodityId());
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyView extends RecyclerView.ViewHolder{

        private final TextView gui_price;
        private final TextView gui_title;
        private final SimpleDraweeView gui_img;


        public MyView(@NonNull View itemView) {
            super(itemView);

            Fresco.initialize(context);

            gui_price = itemView.findViewById(R.id.gui_price);
            gui_title = itemView.findViewById(R.id.gui_title);
            gui_img = itemView.findViewById(R.id.gui_img);
        }
    }
}
