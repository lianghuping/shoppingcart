package com.bwie.shoppingcart.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bwie.shoppingcart.R;

public class Search2View extends LinearLayout {

    public ImageView sou1;
    public EditText serachview1;
    public Button kuang1;

    public Search2View(Context context) {
        super(context);
    }

    public Search2View(final Context context, AttributeSet attrs) {
        super(context, attrs);

        View view = LayoutInflater.from(context).inflate(R.layout.view_search2,this);
        sou1 = view.findViewById(R.id.sou1);
        serachview1 = view.findViewById(R.id.serachview1);
        kuang1 = view.findViewById(R.id.kuang1);









    }

    public Search2View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



}
