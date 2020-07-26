package com.example.ordernow;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class Gpay extends AppCompatActivity implements PaymentResultListener {
    Button  pay_button3;

    private static final int TEZ_REQUEST_CODE = 123;

    private static final String GOOGLE_TEZ_PACKAGE_NAME = "com.google.android.apps.nbu.paisa.user";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpay);
        pay_button3=findViewById(R.id.pay_button3);
        final Bundle meraprice=this.getIntent().getExtras();
        Button payButton = findViewById(R.id.pay_button);
        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri =
                        new Uri.Builder()
                                .scheme("upi")
                                .authority("pay")
                                .appendQueryParameter("pa", "9112416062@upi")
                                .appendQueryParameter("pn", "BCR2DN6TVPVN7QLH")
                                .appendQueryParameter("mc", "5411")
                                .appendQueryParameter("tr", "123456789")
                                .appendQueryParameter("tn", "Food Delivary")
                                .appendQueryParameter("am", meraprice.getString("price",null))
                                .appendQueryParameter("cu", "INR")
                                .appendQueryParameter("url", "https://test.merchant.website")
                                .build();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                intent.setPackage(GOOGLE_TEZ_PACKAGE_NAME);
                startActivityForResult(intent, TEZ_REQUEST_CODE);


            }
        });

        pay_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startPayment();



            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEZ_REQUEST_CODE) {
            // Process based on the data in response.
            Log.d("result", data.getStringExtra("Status"));

            Toast.makeText(Gpay.this, "Your order is sucessfully placed", Toast.LENGTH_SHORT).show();

            Intent spd= new Intent(Gpay.this,Thankyou.class);
            startActivity(spd);




        }

        else
            {

            Toast.makeText(Gpay.this, "Your order is not placed due to payement", Toast.LENGTH_SHORT).show();

            Intent spp= new Intent(Gpay.this,Cancel.class);
            startActivity(spp);


        }


    }

    private static final String TAG=Gpay.class.getSimpleName();
    private Object responce;


    public void startPayment() {
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
           e.printStackTrace();
        }



    }


    @Override
    public void onPaymentSuccess(String s) {

    }

    @Override
    public void onPaymentError(int i, String s) {

    }
}





