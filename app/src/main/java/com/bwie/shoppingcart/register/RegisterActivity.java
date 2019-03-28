package com.bwie.shoppingcart.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.shoppingcart.R;
import com.bwie.shoppingcart.login.LoginActivity;
import com.bwie.shoppingcart.login.mvp.presenter.LoginPresenterClass;
import com.bwie.shoppingcart.login.mvp.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener,LoginView {

    @BindView(R.id.et_reg_name)
    EditText etRegName;
    @BindView(R.id.et_reg_yan)
    EditText etRegYan;
    @BindView(R.id.et_reg_pwd)
    EditText etRegPwd;
    @BindView(R.id.text_login)
    TextView textLogin;
    @BindView(R.id.btn_regist)
    Button btnRegist;
    private LoginPresenterClass mainPresenterClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        btnRegist.setOnClickListener(this);
        textLogin.setOnClickListener(this);

        mainPresenterClass = new LoginPresenterClass(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_regist:
                String phone3 = etRegName.getText().toString();
                String pwd3 = etRegPwd.getText().toString();
                mainPresenterClass.getLogin(1, phone3, pwd3);
                break;

            case R.id.text_login:
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                break;
        }


    }

    @Override
    public void getShow(String info, int tag) {

        if (info.equals("注册成功")) {
            Toast.makeText(RegisterActivity.this, info, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        } else {
            Toast.makeText(RegisterActivity.this, info, Toast.LENGTH_SHORT).show();

        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenterClass.onDestory();

    }
}

