package com.stationerymall.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BuyNowActivity extends AppCompatActivity {

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_now);

        Bundle bundle = getIntent().getExtras();

        ImageView productImage = findViewById(R.id.product_purchased_image);
        TextView productName = findViewById(R.id.product_purchased_name);
        TextView productPrice = findViewById(R.id.product_purchased_price);

        String product_price_extra = String.valueOf(bundle.getInt("product_price"));
        String product_name_extra = bundle.getString("product_name");


        EditText customer_name_txt = findViewById(R.id.customer_name_editxt);
        EditText customer_phone_txt = findViewById(R.id.phone_number_editxt);
        EditText mpesa_code_txt = findViewById(R.id.mpesa_code_editxt);


        productImage.setImageResource(bundle.getInt("product_image"));
        productPrice.setText("@Ksh "+product_price_extra);
        productName.setText(product_name_extra);

        dbHelper = new DBHelper(this);

        Button submitBtn = findViewById(R.id.submit_button);
        submitBtn.setOnClickListener(View->{
            String customerName = customer_name_txt.getText().toString();
            String customerPhone = customer_phone_txt.getText().toString();
            String mpesa_code = mpesa_code_txt.getText().toString();
            dbHelper.insertPurchase(product_name_extra, product_price_extra, customerName, customerPhone, mpesa_code);
            customer_name_txt.setText("");
            customer_phone_txt.setText("");
            mpesa_code_txt.setText("");
            Toast.makeText(this, "Purchase Submitted!", Toast.LENGTH_SHORT).show();
        });


        Button purchasesBtn = findViewById(R.id.view_purchases_button);
        purchasesBtn.setOnClickListener(View->{
            Intent intent = new Intent(BuyNowActivity.this, PurchasesActivity.class);
            startActivity(intent);
            finish();
        });

    }
}