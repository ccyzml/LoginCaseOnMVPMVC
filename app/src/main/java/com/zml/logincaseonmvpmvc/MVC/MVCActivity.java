package com.zml.logincaseonmvpmvc.MVC;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zml.logincaseonmvpmvc.Api;
import com.zml.logincaseonmvpmvc.Model.User;
import com.zml.logincaseonmvpmvc.R;
import com.zml.logincaseonmvpmvc.SimpleDialog;


public class MVCActivity extends AppCompatActivity {
    EditText accountET,passwordET;
    Button loginBtn;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accountET = findViewById(R.id.account);
        passwordET = findViewById(R.id.password);
        loginBtn = findViewById(R.id.login);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountET.getText().toString();
                String password = passwordET.getText().toString();
                if (account.equals("")) {
                    SimpleDialog.showSimpleDialog(MVCActivity.this,"账号不能为空");
                }else if (password.equals("")) {
                    SimpleDialog.showSimpleDialog(MVCActivity.this,"密码不能为空");
                } else {
                    Api.getApi().Login(account, password, new Api.LoginCallBack() {
                        @Override
                        public void success(User user) {
                            MVCActivity.this.user = user;
                            SimpleDialog.showSimpleDialog(MVCActivity.this, "欢迎" + user.getName());
                        }

                        @Override
                        public void fail() {
                            SimpleDialog.showSimpleDialog(MVCActivity.this, "登录失败");
                        }
                    });
                }
            }
        });

    }

}
