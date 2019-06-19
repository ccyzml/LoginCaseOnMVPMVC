package com.zml.logincaseonmvpmvc.MVP;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zml.logincaseonmvpmvc.R;
import com.zml.logincaseonmvpmvc.SimpleDialog;


public class MVPActivity extends AppCompatActivity implements ILoginView {
    EditText accountET,passwordET;
    Button loginBtn;
    LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accountET = findViewById(R.id.account);
        passwordET = findViewById(R.id.password);
        loginBtn = findViewById(R.id.login);
        loginPresenter = new LoginPresenter(this);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountET.getText().toString();
                String password = passwordET.getText().toString();
                loginPresenter.login(account,password);
            }
        });

    }

    @Override
    public void success(String userName) {
        SimpleDialog.showSimpleDialog(this,"欢迎"+userName);
    }

    @Override
    public void fail() {
        SimpleDialog.showSimpleDialog(this,"登录失败");
    }

    @Override
    public void invalidPassword() {
        SimpleDialog.showSimpleDialog(this,"密码不能为空");
    }

    @Override
    public void invalidAccount() {
        SimpleDialog.showSimpleDialog(this,"账号不能为空");
    }
}
