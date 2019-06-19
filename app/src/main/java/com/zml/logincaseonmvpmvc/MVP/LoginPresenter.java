package com.zml.logincaseonmvpmvc.MVP;


import com.zml.logincaseonmvpmvc.Api;
import com.zml.logincaseonmvpmvc.Model.User;

public class LoginPresenter {
    private ILoginView iLoginView;
    private User user;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    public void login(String account, String password) {
        if (account.equals("")) {
            iLoginView.invalidAccount();
        }else if (password.equals("")) {
            iLoginView.invalidPassword();
        } else {
            Api.getApi().Login(account, password, new Api.LoginCallBack() {
                @Override
                public void success(User user) {
                    LoginPresenter.this.user = user;
                    iLoginView.success(user.getName());
                }

                @Override
                public void fail() {
                    iLoginView.fail();
                }
            });
        }
    }
}
