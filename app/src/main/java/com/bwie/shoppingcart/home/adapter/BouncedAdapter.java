package com.bwie.shoppingcart.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.shoppingcart.R;
import com.bwie.shoppingcart.home.bean.BouncedBean;

import java.util.List;

public class BouncedAdapter extends RecyclerView.Adapter<BouncedAdapter.MyView> {

    Context context;
    private  List<BouncedBean.ResultBean> result2;


    public void setResult2(List<BouncedBean.ResultBean> result2) {
        this.result2 = result2;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BouncedAdapter.MyView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
         context = viewGroup.getContext();
        View view = LayoutInflater.from(this.context).inflate(R.layout.iteam_bounced1,viewGroup,false);
        MyView myView = new MyView(view);
        return myView;
    }

    @Override
    public void onBindViewHolder(@NonNull BouncedAdapter.MyView myView, final int i) {

        myView.text_pop.setText(result2.get(i).getName());

        myView.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("lhp", "一级条目点击成功");
                if(setOnClickListen!=null){
                    setOnClickListen.getPop(result2.get(i).getId());
                }else{
                    Toast.makeText(context,"亲,没有收到您需要的商品",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        if (result2!=null){

            return result2.size();
        }
        return 0;
    }

    public class MyView extends RecyclerView.ViewHolder{

        private final TextView text_pop;

        public MyView(@NonNull View itemView) {
            super(itemView);

             text_pop = itemView.findViewById(R.id.text_pop);

        }
    }


    setOnClickListen setOnClickListen;

    public void setSetOnClickListen(BouncedAdapter.setOnClickListen setOnClickListen) {
        this.setOnClickListen = setOnClickListen;
    }

    public interface setOnClickListen{
        void getPop(String id);
    }




}
