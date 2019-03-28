package com.bwie.shoppingcart.home.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bwie.shoppingcart.R;
import com.bwie.shoppingcart.home.activity.SearchActivity;

public class SearchView extends LinearLayout {

    public ImageView sou;
    public Button kuang;

    public SearchView(Context context) {
        super(context);
    }

    public SearchView(final Context context, AttributeSet attrs) {
        super(context, attrs);

        View view = LayoutInflater.from(context).inflate(R.layout.view_search,this);
        sou = view.findViewById(R.id.sou);

        kuang = view.findViewById(R.id.kuang);
        final Activity activity = (Activity) context;

        kuang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SearchActivity.class);
                context.startActivity(intent);
                activity.finish();

            }
        });



    }

    public SearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



}
