package com.example.ordernow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Paytm extends AppCompatActivity {
    Button pay_button2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paytm);
        pay_button2=findViewById(R.id.pay_button2);
        pay_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JSONObject paytmParams = new JSONObject();

                JSONObject body = new JSONObject();
                JSONObject txnAmount = new JSONObject();
                JSONObject userInfo = new JSONObject();
                try
                {
                    body.put("Payment", "500");
                    body.put("mid", "dGqMwH86881623295265");

                    body.put("websiteName", "WEBSTAGING");

                    body.put("orderId", "ORDERID_98765");

                    body.put("callbackUrl", "https://merchant.com/callback");

                    txnAmount.put("value", "1000.00");

                    txnAmount.put("currency", "INR");

                    userInfo.put("custId", "CUST_001");

                    body.put("txnAmount", txnAmount);

                    body.put("userInfo", userInfo);
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }

                /*
                 * Generate checksum by parameters we have in body
                 * You can get Checksum JAR from https://developer.paytm.com/docs/checksum/
                 * Find your Merchant Key in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys


                /* for Staging */
                URL url = null;
                try {
                    url = new URL("https://securegw-stage.paytm.in/theia/api/v1/initiateTransaction?mid=dGqMwH86881623295265&orderId=ORDERID_98765");



                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                /* for Production */
// URL url = new URL("https://securegw.paytm.in/theia/api/v1/initiateTransaction?mid=YOUR_MID_HERE&orderId=ORDERID_98765");

                try {
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.setDoOutput(true);

                    DataOutputStream requestWriter = new DataOutputStream(connection.getOutputStream());

                    requestWriter.close();
                    String responseData = "";
                    InputStream is = connection.getInputStream();
                    BufferedReader responseReader = new BufferedReader(new InputStreamReader(is));
                    if ((responseData = responseReader.readLine()) != null) {
                        System.out.append("Response: " + responseData);
                    }
                    responseReader.close();
                }

                catch (Exception exception)
                {

                    exception.printStackTrace();
                }


            }
        });


    }
}