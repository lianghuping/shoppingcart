package com.bwie.shoppingcart.circle.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.shoppingcart.R;
import com.bwie.shoppingcart.circle.bean.CircleBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class CircleAdapter extends XRecyclerView.Adapter<CircleAdapter.MyView> {

    Context context;
    List<CircleBean.ResultBean> list;


    public CircleAdapter(Context context, List<CircleBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CircleAdapter.MyView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_circle,viewGroup,false);
        MyView myView = new MyView(view);
        return myView;
    }

    @Override
    public void onBindViewHolder(@NonNull CircleAdapter.MyView myView, int i) {




        Uri parse = Uri.parse(list.get(i).getHeadPic());
        myView.head_img.setImageURI(parse);
        myView.quan_title.setText(list.get(i).getNickName());

        myView.quan_actr.setText(list.get(i).getContent());
        Uri parse1 = Uri.parse(list.get(i).getImage());
        myView.quan_img1.setImageURI(parse1);

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyView extends RecyclerView.ViewHolder {

        private final SimpleDraweeView head_img;
        private final TextView quan_title;
        private final TextView quan_title1;
        private final TextView quan_actr;
        private final SimpleDraweeView quan_img1;

        public MyView(@NonNull View itemView) {
            super(itemView);

            head_img = itemView.findViewById(R.id.head_img);
            quan_title = itemView.findViewById(R.id.quan_title);
            quan_title1 = itemView.findViewById(R.id.quan_title1);
            quan_actr = itemView.findViewById(R.id.quan_actr);
            quan_img1 = itemView.findViewById(R.id.quan_img1);


        }
    }
}
