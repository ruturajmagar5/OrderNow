package com.example.ordernow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cancel extends AppCompatActivity {
    Button bb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel);
        bb1=findViewById(R.id.bb1);

        bb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent pp= new Intent(Cancel.this,Payement.class);
                startActivity(pp);

            }
        });
    }
}