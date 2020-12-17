package com.gezhi.gege;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegistActivity extends AppCompatActivity implements View.OnClickListener {

    EditText registeraccountet, registerpasswordet;
    Button registerBtn, backloginBtn;


//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        registerBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//        });
//    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registactivity_layout);
        registeraccountet = (EditText) findViewById(R.id.register_account);
        registerpasswordet = (EditText) findViewById(R.id.register_password);
        registerBtn = (Button) findViewById(R.id.register_btn);
//        backloginBtn = (Button) findViewById(R.id.backlogin_btn);
        registerBtn.setOnClickListener(this);
//        backloginBtn.setOnClickListener(this);
    }

//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.registfragment_layout, container, false);
//        registeraccountet = (EditText) view.findViewById(R.id.register_account);
//        registerpasswordet = (EditText) view.findViewById(R.id.register_password);
//        registerBtn = (Button) view.findViewById(R.id.register_btn);
//        registerBtn.setOnClickListener(this);
//        return view;
//    }


//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        String straccount = registeraccountet.getText().toString().trim();
//        String strpassword = registerpasswordet.getText().toString().trim();
//        super.onSaveInstanceState(outState);
//    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_btn:
                SharedPreferences.Editor editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit();
                String straccount = registeraccountet.getText().toString().trim();
                String strpassword = registerpasswordet.getText().toString().trim();
                editor.putString("account", straccount);
                editor.putString("password", strpassword);
                Log.d("TAG", "onClick:用户为： " + straccount);
                Log.d("TAG", "onClick:密码为： " + strpassword);
                editor.apply();

                Intent data1 = new Intent();
                data1.putExtra("straccount", straccount);
                data1.putExtra("strpassword", strpassword);
                Log.d("putExtraDataTAG", "onClick: " + straccount + "," + strpassword);
                setResult(RESULT_OK, data1);
                finish();
                Intent intent = new Intent(RegistActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
//            case R.id.backlogin_btn:
//                break;
            default:
                break;
        }
    }
}
