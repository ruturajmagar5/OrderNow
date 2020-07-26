package com.example.ordernow;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.razorpay.Checkout;

import org.json.JSONObject;

public class RozorPay extends AppCompatActivity {

    Button  pay_button3;

    private static final String TAG=MainActivity.class.getSimpleName();
    private Object responce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rozor_pay);

        pay_button3=findViewById(R.id.pay_button3);

        pay_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startPayement();



            }
        });


    }


    public void startPayement() {
        final Bundle meraprice=this.getIntent().getExtras();
        Checkout checkout= new Checkout();

        checkout.setKeyID("rzp_test_NLjlYWX5xzgril");

        checkout.setImage(R.drawable.rozorpayy);

        final Activity activity = this;

        try {

            JSONObject options = new JSONObject();



            options.put("name", "Order Now");
            options.put("description", "Reference No. #123456");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            options.put("amount","200");//pass amount in currency subunits
            options.put("prefill.email", "ruturajmagar5@gmail.com");
            options.put("prefill.contact","9112416062");
            checkout.open(activity, options);

        }
        catch(Exception e)
        {
            Log.e(TAG, "Error in starting Razorpay Checkout", e);
        }



    }


}