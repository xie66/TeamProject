package com.gezhi.gege;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_CODE_GO_TO_REGIST = 100; //登录界面定义常量
    Button loginBtn, registerBtn;
    EditText accountEt, passwordEt;
    String accountEt1, passwordEt1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        initView();

        if (accountEt != null && passwordEt != null) {
            SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
            accountEt1 = preferences.getString("account", "");
            passwordEt1 = preferences.getString("password", "");
            accountEt.setText(accountEt1);
            passwordEt.setText(passwordEt1);
            Log.d("TAG", "onClick:用户为： " + accountEt);
            Log.d("TAG", "onClick:密码为： " + passwordEt);
        }
    }

    private void initView() {
        loginBtn = (Button) findViewById(R.id.login_btn);
        registerBtn = (Button) findViewById(R.id.register_btn);
        accountEt = (EditText) findViewById(R.id.acount_et);
        passwordEt = (EditText) findViewById(R.id.password_et);
        loginBtn.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn:
                if (accountEt.equals(accountEt1) && passwordEt.equals(passwordEt1)) {
                    Intent intent1 = new Intent(LoginActivity.this, MyActivity1.class);
                    startActivity(intent1);
                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.register_btn:
                Intent intent = new Intent(LoginActivity.this, RegistActivity.class);
                startActivityForResult(intent, REQUEST_CODE_GO_TO_REGIST);
                Log.d("TAG", "onClick: 单击了注册按钮！");
                break;
            default:
                break;
        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data1) {
//        super.onActivityResult(requestCode, resultCode, data1);
//        switch (requestCode) {
//            case REQUEST_CODE_GO_TO_REGIST:
//                //判断注册是否成功  如果注册成功
//                if (resultCode == RESULT_OK) {
//                    //则获取data中的账号和密码  动态设置到EditText中
//                    String straccount = data1.getStringExtra("straccount");
//                    String strpassword = data1.getStringExtra("strpassword");
//                    Log.d("TAG", "onActivityResult: " + straccount);
//                    accountEt.setText(straccount);
//                    passwordEt.setText(strpassword);
//                }
//                break;
//        }
//    }
}
