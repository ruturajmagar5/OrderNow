package com.example.ordernow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView food;

    String[] iurl={"https://static.toiimg.com/thumb/76481989.cms?width=680&height=512&imgsize=170646",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRv8yMjQrq5SorevjLGTfVuvgbC-Khz8TJOIg&usqp=CAU",
            "https://healthyfitnessmeals.com/wp-content/uploads/2018/06/instagram-In-Stream_Square___banana-protein-donuts-3.jpg",
            "https://i.ytimg.com/vi/C9u8RoJvz_c/maxresdefault.jpg",
            "https://i.ytimg.com/vi/_8XV4CQANlQ/maxresdefault.jpg"};
    String[] hdata={"Pizza","Burger","Donut","Sandwich","Pattice"};

    String[] sdata={"Spicy chicken pizza = Rs:550","Beel Burger = Rs:400","Donut = Rs:300","Chicken sandwich = Rs:450","Special Pattice = Rs:80"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        food=findViewById(R.id.food);

        MyAdapter ma = new MyAdapter(MainActivity.this,iurl,hdata,sdata);
        food.setAdapter(ma);



    }
}