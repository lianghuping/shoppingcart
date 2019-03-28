package com.bwie.shoppingcart.home.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bwie.shoppingcart.R;
import com.bwie.shoppingcart.circle.CircleFragment;
import com.bwie.shoppingcart.home.fragment.HomeFragment;
import com.bwie.shoppingcart.order.OrderFragment;
import com.bwie.shoppingcart.shoppingcart.ShoppingFragment;
import com.bwie.shoppingcart.mine.MineFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {


    @BindView(R.id.frag)
    FrameLayout frag;
    @BindView(R.id.radioButton0)
    RadioButton radioButton0;
    @BindView(R.id.radioButton1)
    RadioButton radioButton1;
    @BindView(R.id.radioButton2)
    RadioButton radioButton2;
    @BindView(R.id.radioButton3)
    RadioButton radioButton3;
    @BindView(R.id.radioButton4)
    RadioButton radioButton4;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private HomeFragment home;
    private CircleFragment fen;
    private ShoppingFragment quan;
    private OrderFragment ding;
    private MineFragment me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        getSupportActionBar().hide();

        manager = getSupportFragmentManager();

        transaction = manager.beginTransaction();

        home = new HomeFragment();
        fen = new CircleFragment();
        quan = new ShoppingFragment();
        ding = new OrderFragment();
        me = new MineFragment();

        transaction.add(R.id.frag,home);
        transaction.add(R.id.frag,fen);
        transaction.add(R.id.frag,quan);
        transaction.add(R.id.frag,ding);
        transaction.add(R.id.frag,me);

        transaction.show(home).hide(fen).hide(quan).hide(ding).hide(me);

        transaction.commit();

        radioGroup.check(radioGroup.getChildAt(0).getId());

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction1 = manager.beginTransaction();
                switch (checkedId){
                    case R.id.radioButton0:
                        transaction1.show(home).hide(fen).hide(quan).hide(ding).hide(me);
                        break;
                    case R.id.radioButton1:
                        transaction1.show(fen).hide(home).hide(quan).hide(ding).hide(me);
                        break;
                    case R.id.radioButton2:
                        transaction1.show(quan).hide(fen).hide(home).hide(ding).hide(me);
                        break;
                        case R.id.radioButton3:
                        transaction1.show(ding).hide(fen).hide(quan).hide(home).hide(me);
                        break;
                        case R.id.radioButton4:
                        transaction1.show(me).hide(fen).hide(quan).hide(ding).hide(home);
                        break;
                }
                transaction1.commit();


            }
        });

    }
}
