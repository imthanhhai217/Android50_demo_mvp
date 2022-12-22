package com.jaroid.android50_demo_mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements LoginView {

    private LoginPresenter loginPresenter;
    EditText edtUserName, edtPasswords;
    Button btnDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUserName = findViewById(R.id.edtUserName);
        edtPasswords = findViewById(R.id.edtPasswords);
        btnDemo = findViewById(R.id.btnDemo);

        loginPresenter = new LoginPresenter(this);
        findViewById(R.id.btnSignIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.login(edtUserName.getText().toString(), edtPasswords.getText().toString());
                btnDemo.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void loginSuccess(String message) {
        Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed(String message) {
        Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
    }
}