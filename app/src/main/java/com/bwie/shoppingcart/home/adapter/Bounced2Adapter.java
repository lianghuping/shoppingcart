package com.bwie.shoppingcart.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.shoppingcart.R;
import com.bwie.shoppingcart.home.activity.SearchActivity;
import com.bwie.shoppingcart.home.bean.Bounced2Bean;

import java.util.List;

public class Bounced2Adapter extends RecyclerView.Adapter<Bounced2Adapter.MyView> {

    Context context;
    private  List<Bounced2Bean.ResultBean> resultBeanList;


    public void setResult2(List<Bounced2Bean.ResultBean> resultBeanList) {
        this.resultBeanList = resultBeanList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Bounced2Adapter.MyView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
         context = viewGroup.getContext();
        View view = LayoutInflater.from(this.context).inflate(R.layout.iteam_bounced2,viewGroup,false);
        MyView myView = new MyView(view);
        return myView;
    }

    @Override
    public void onBindViewHolder(@NonNull Bounced2Adapter.MyView myView, final int i) {

        myView.text_pop2.setText(resultBeanList.get(i).getName());

        myView.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SearchActivity.class);
                intent.putExtra("names",resultBeanList.get(i).getName());
                context.startActivity(intent);
            }
        });

       /* myView.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SearchActivity.class);
                intent.putExtra("ids",resultBeanList.get(i).getId());
                context.startActivity(intent);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        if (resultBeanList!=null){

            return resultBeanList.size();
        }
        return 0;
    }

    public class MyView extends RecyclerView.ViewHolder{

        private final TextView text_pop2;

        public MyView(@NonNull View itemView) {
            super(itemView);

             text_pop2 = itemView.findViewById(R.id.text_pop2);

        }
    }
}
