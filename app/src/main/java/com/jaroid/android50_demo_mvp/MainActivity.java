package com.jaroid.android50_demo_mvp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements LoginView {

    private static final String TAG = "MainActivity";
    private LoginPresenter loginPresenter;
    EditText edtUserName, edtPasswords;
    Button btnDemo;
    Switch swLanguage;
    private boolean isVnLanguage = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0, 0);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        isVnLanguage = getSharedPreferences("SETTINGS", MODE_PRIVATE).getBoolean("IS_VN", false);
    }

    private void initView() {
        edtUserName = findViewById(R.id.edtUserName);
        edtPasswords = findViewById(R.id.edtPasswords);
        btnDemo = findViewById(R.id.btnDemo);
        swLanguage = findViewById(R.id.swLanguage);

        loginPresenter = new LoginPresenter(this);
        findViewById(R.id.btnSignIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.login(edtUserName.getText().toString(), edtPasswords.getText().toString());
                btnDemo.setVisibility(View.GONE);
            }
        });
        swLanguage.setChecked(isVnLanguage);
        swLanguage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, "onCheckedChanged: " + isChecked);
                updateLanguage(isChecked);
            }
        });
    }

    private void updateLanguage(boolean isChecked) {
        this.isVnLanguage = isChecked;
        saveLanguageValue(isVnLanguage);
        Locale locale = new Locale(isVnLanguage ? "vi" : "en");
        Configuration configuration = getResources().getConfiguration();
        configuration.setLocale(locale);
        createConfigurationContext(configuration);
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    private void saveLanguageValue(boolean isVnLanguage) {
        SharedPreferences sharedPreferences = getSharedPreferences("SETTINGS", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("IS_VN", isVnLanguage);
        editor.commit();
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