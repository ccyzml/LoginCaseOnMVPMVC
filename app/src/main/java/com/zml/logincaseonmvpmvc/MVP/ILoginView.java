package com.zml.logincaseonmvpmvc.MVP;

public interface ILoginView {
    void success(String userName);
    void fail();
    void invalidPassword();
    void invalidAccount();
}
