package com.stationerymall.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    List<Category> categories;
    HomeAdapter homeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       gridView = findViewById(R.id.grid_list);
       gridList();
       homeAdapter = new HomeAdapter(this, categories);
       gridView.setAdapter(homeAdapter);

    }

    private void gridList() {

        categories = new ArrayList<>();

        categories.add(new Category(R.drawable.glue, "Glue"));
        categories.add(new Category(R.drawable.paper_clips, "Pins"));
        categories.add(new Category(R.drawable.clipboards, "Clipboards"));

        categories.add(new Category(R.drawable.stapplers, "Staplers"));
        categories.add(new Category(R.drawable.olymoic_exercise_book_64_pages, "Exercises"));
        categories.add(new Category(R.drawable.document_files, "Files"));

        categories.add(new Category(R.drawable.pencils, "Pencils"));
        categories.add(new Category(R.drawable.pens, "Pens"));
        categories.add(new Category(R.drawable.rulers, "Rulers"));

        categories.add(new Category(R.drawable.calculators, "Calculators"));
        categories.add(new Category(R.drawable.scissors, "Scissors"));

        categories.add(new Category(R.drawable.envelopes, "Envelopes"));

        for (Category category:categories) {
            System.out.println(category.getImage());
        }

    }
}