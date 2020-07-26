package com.example.ordernow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Hellopage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hellopage);


        Thread t=new Thread(){
            @Override
            public void run() {
                super.run();

                try {
                    Thread.sleep(5000);

                Intent i=new Intent(Hellopage.this,MainActivity.class);
                    startActivity(i);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        };
        t.start();
    }
}