package com.example.ordernow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Payement extends AppCompatActivity {

    Button cb,cb2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payement);
        cb=findViewById(R.id.cb);
        cb2=findViewById(R.id.cb2);

        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent s= new Intent(Payement.this,Gpay.class);
                Bundle b=Payement.this.getIntent().getExtras();
                Bundle doosra=new Bundle();
                doosra.putString("price",b.getString("price",null));
                s.putExtras(doosra);
                startActivity(s);

//                Intent c = new Intent();
//                c.setAction(Intent.ACTION_CALL);
//                c.setData(Uri.parse("tel:9112416062"));
//                startActivity(c);

            }
        });

        cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent c = new Intent();
                c.setAction(Intent.ACTION_CALL);
                c.setData(Uri.parse("tel:9112416062"));
                startActivity(c);

            }
        });






    }
}