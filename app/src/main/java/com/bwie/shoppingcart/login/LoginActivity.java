package com.bwie.shoppingcart.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.shoppingcart.R;
import com.bwie.shoppingcart.login.mvp.presenter.LoginPresenterClass;
import com.bwie.shoppingcart.login.mvp.view.LoginView;
import com.bwie.shoppingcart.register.RegisterActivity;
import com.bwie.shoppingcart.home.activity.HomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener ,LoginView {

    @BindView(R.id.et_login_name)
    EditText etLoginName;
    @BindView(R.id.et_login_pwd)
    EditText etLoginPwd;
    @BindView(R.id.ck_rem_pwd)
    CheckBox ckRemPwd;
    @BindView(R.id.text_reg)
    TextView textReg;
    @BindView(R.id.btn_login)
    Button btnLogin;

    private LoginPresenterClass mainPresenterClass;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {

        btnLogin.setOnClickListener(this);
        textReg.setOnClickListener(this);

        mainPresenterClass = new LoginPresenterClass(this);


        preferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        if (preferences.getBoolean("remober", false)) {
            String phone = preferences.getString("phone", "");
            String pwd = preferences.getString("pwd", "");

            etLoginName.setText(phone);
            etLoginPwd.setText(pwd);
            ckRemPwd.setChecked(false);

        }

    }

        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.btn_login:
                    String phone1 = etLoginName.getText().toString();
                    String pwd1 = etLoginPwd.getText().toString();

                    mainPresenterClass.getLogin(0,phone1,pwd1);

                    SharedPreferences.Editor edit = preferences.edit();
                    edit.putBoolean("remober",ckRemPwd.isChecked());
                    edit.putString("phone",phone1);
                    edit.putString("pwd",pwd1);
                    edit.commit();

                    break;


                case R.id.text_reg:

                    startActivity(new Intent(LoginActivity.this,RegisterActivity.class));

                    break;
            }


        }


        @Override

        public void getShow(String info, int tag) {

            if(info.equals("登录成功")){
                Toast.makeText(LoginActivity.this,info,Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            }else{
                Toast.makeText(LoginActivity.this,info,Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            mainPresenterClass.onDestory();
        }
    }



