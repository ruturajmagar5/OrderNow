package com.example.ordernow;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class buy extends AppCompatActivity {

    TextView tv1, tv2;
    ImageView iv;
    Bundle b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        iv=findViewById(R.id.iv);

        b1=this.getIntent().getExtras();
        tv1.setText(b1.getString("raj",null));


        Glide.with(buy.this).load(b1.getString("raj3",null)).into(iv);


        tv2.setText(b1.getString("raj2",null));
        //iv.setImageResource(Integer.parseInt(b1.getString("raj3",null)));
        Log.d("ruturaj",b1.getString("raj2",null).toString().split("=")[1].split(":")[1]);
    }



    public void robo(View view){

        AlertDialog.Builder adb=new AlertDialog.Builder(buy.this);
        adb.setIcon(android.R.drawable.ic_menu_call);
        adb.setTitle("Order Confirmation");
        adb.setMessage("Do you want to proceed?");
        adb.setPositiveButton("Confirm order", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(buy.this, "Order Confirmed", Toast.LENGTH_SHORT).show();

                Intent t= new Intent(buy.this,Payement.class);
                 Bundle b=new Bundle();
                 b.putString("price",b1.getString("raj2",null).toString().split(":")[1]);
                 t.putExtras(b);
                 startActivity(t);

            }
        });
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(buy.this, "Order cancelled", Toast.LENGTH_SHORT).show();
                finish();

            }
        });
        adb.setNeutralButton("Continue Shopping", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(buy.this, "Continue Shopping", Toast.LENGTH_SHORT).show();

                Intent t= new Intent(buy.this,MainActivity.class);

                startActivity(t);

            }
        });
        adb.setCancelable(false);

        adb.show();

    }
}