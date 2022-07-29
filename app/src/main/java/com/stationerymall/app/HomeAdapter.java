package com.stationerymall.app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class HomeAdapter extends BaseAdapter {

    Context context;
    List<Category> categories;

    public HomeAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @Override
    public int getCount() {
        return categories.size();
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
        view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

        ImageView categoryImage = view.findViewById(R.id.category_image);
        TextView category_name = view.findViewById(R.id.category_name);

        categoryImage.setImageResource(categories.get(position).getImage());
        category_name.setText(categories.get(position).getName());

        view.setOnClickListener(view1 -> {
            Intent intent = new Intent(context, CategoryActivity.class);
            intent.putExtra("category_name", categories.get(position).getName());
            context.startActivity(intent);
        });

        return view;
    }
}
