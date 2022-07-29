package com.stationerymall.app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CategoryAdapter  extends BaseAdapter {

    Context context;
    List<Product> products;

    public CategoryAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(context).inflate(R.layout.product_item_layout, parent, false);

        ImageView productImage = view.findViewById(R.id.product_image);
        TextView productName = view.findViewById(R.id.product_name);
        TextView productPrice = view.findViewById(R.id.product_price);
        Button buyNowBtn = view.findViewById(R.id.buy_now_button);

        productName.setText(products.get(position).getName());
        productPrice.setText("@Ksh "+products.get(position).getPrice());
        productImage.setImageResource(products.get(position).getImage());

//        view.setOnClickListener(view1 -> Toast.makeText(context, "Position"+position, Toast.LENGTH_SHORT).show());
        buyNowBtn.setOnClickListener(view1 -> {
            Intent intent = new Intent(context, BuyNowActivity.class);
            intent.putExtra("product_image", products.get(position).getImage());
            intent.putExtra("product_price", products.get(position).getPrice());
            intent.putExtra("product_name", products.get(position).getName());
            context.startActivity(intent);
//            Toast.makeText(context, "Product:" + products.get(position).getName(), Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
