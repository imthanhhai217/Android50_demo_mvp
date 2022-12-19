package com.jaroid.android50_demo_mvp;

public class DataBaseModel {
    private LoginViewPresenter iLoginView;

    public DataBaseModel(LoginViewPresenter iLoginView) {
        this.iLoginView = iLoginView;
    }

    public void checkLoginFromDatabase(String userName, String password) {
        if (userName.equals("hai") && password.equals("123456")) {
            iLoginView.loginSuccess("Đăng nhập thành công");
        } else {
            iLoginView.loginFailed("Đăng nhập thất bại");
        }
    }
}
