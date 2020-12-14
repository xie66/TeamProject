package com.gezhi.gege;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends AppCompatActivity  {

    Button startBtn;
//    int requestLoginCode = 2020;
    Timer timer;   //定时器
    int count = 5;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_layout);
        startBtn = (Button) findViewById(R.id.jump_btn);


        timer = new Timer();
        handler = new Handler(Looper.getMainLooper());
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                count--;
                handler.post(new Runnable() {    //handler.post(r)。r是要执行的任务代码。意思就是说r的代码实际是在UI线程执行的。可以写更新UI的代码。
                    @Override
                    public void run() {
                        startBtn.setText("跳过 " + count);
                    }
                });
                if (count <= 0) {
                    Intent intent = new Intent(StartActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    timer.cancel();
                    timer = null;
                }
            }
        }, 0, 1000);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timer != null) {
                    timer.cancel();
                }
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }



//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.jump_btn:
//                if (timer != null) {
//                    timer.cancel();
//                }
//                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
//                startActivity(intent);
//              break;
//        }
//    }
}