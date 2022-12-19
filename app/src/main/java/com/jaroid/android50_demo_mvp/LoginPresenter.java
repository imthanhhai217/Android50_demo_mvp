package com.jaroid.android50_demo_mvp;

public class LoginPresenter implements LoginViewPresenter {

    private LoginView iLoginView;
    private DataBaseModel dataBaseModel;

    public LoginPresenter(LoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    public void login(String userName, String password) {
        dataBaseModel = new DataBaseModel(this);
        dataBaseModel.checkLoginFromDatabase(userName, password);
    }

    @Override
    public void loginSuccess(String message) {
        iLoginView.loginSuccess(message);
    }

    @Override
    public void loginFailed(String message) {
        iLoginView.loginFailed(message);
    }
}
