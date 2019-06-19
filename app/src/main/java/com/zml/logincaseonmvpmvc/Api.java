package com.zml.logincaseonmvpmvc;


import com.zml.logincaseonmvpmvc.Model.User;

public class Api {
    private static Api api = new Api();

    private Api(){

    }

    public static Api getApi() {
        return api;
    }

    public void Login(final String account, final String password, final LoginCallBack loginCallBack) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    if (account.equals("meanlay") && password.equals("123456")) {
                        User user = new User();
                        user.setName("Meanlay");
                        if (loginCallBack != null) {
                            loginCallBack.success(user);
                        }
                    } else {
                        loginCallBack.fail();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.run();
    }

    public interface LoginCallBack {
        void success(User user);
        void fail();
    }
}
