package com.stationerymall.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PurchasesActivity extends AppCompatActivity {

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchases);

        dbHelper = new DBHelper(this);
        String data  = dbHelper.getData();
        TextView purchasesTextView = findViewById(R.id.purchases_textview);
        purchasesTextView.setText(data);
    }
}