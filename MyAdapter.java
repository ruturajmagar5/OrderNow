package com.example.ordernow;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

public class MyAdapter extends BaseAdapter {

    LayoutInflater li;
    Context con;
    String [] hdata,sdata;
    String[] iurl;

    public MyAdapter(Context con, String[] iurl, String[] hdata, String[] sdata) {
        this.con = con;
        this.iurl = iurl;
        this.hdata = hdata;
        this.sdata = sdata;
        li=LayoutInflater.from(con);
    }

    @Override
    public int getCount() {
        return iurl.length;
    }

    @Override
    public Object getItem(int position) {
        return iurl;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    ImageView civ;
    TextView chead,csub;


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v=li.inflate(R.layout.custom,null);
        civ=v.findViewById(R.id.civ);
        chead=v.findViewById(R.id.chead);
        csub=v.findViewById(R.id.csub);

        chead.setText(hdata[position]);
        csub.setText(sdata[position]);
        Glide.with(con).load(iurl[position]).into(civ);
        civ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        Intent i1 = new Intent(con, buy.class);

                Bundle b1 = new Bundle();
                b1.putString("raj", hdata[position]);


                b1.putString("raj3",iurl[position]);


                        b1.putString("raj2", sdata[position]);
                        i1.putExtras(b1);







                con.startActivity(i1);



















            }
        });




        return v;
    }
}
