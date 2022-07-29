package com.stationerymall.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    GridView gridView;
    List<Product> products;
    CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Bundle bundle = getIntent().getExtras();
        String category_title_extra = bundle.getString("category_name");
        TextView category_title = findViewById(R.id.category_name_title);
        category_title.setText(category_title_extra);

        gridView = findViewById(R.id.product_list);
        gridList();
        
        
        categoryAdapter = new CategoryAdapter(this, filteredProducts(products, category_title_extra));
        gridView.setAdapter(categoryAdapter);
    }

    private List<Product> filteredProducts(List<Product> products, String category_name) {
        ArrayList<Product> myproducts = new ArrayList<>();
        for (Product product: products) {
            if (product.getCategory().equals(category_name)) {
                myproducts.add(product);
            }
        }
        return myproducts;
    }

    private void gridList() {
        products = new ArrayList<>();
//        Exercises
        products.add(new Product("Exercises","Kasuku Exercise Book - 200 pages", R.drawable.exercise_squared_book_200_pages,120));
        products.add(new Product("Exercises","Kasuku Hardcover Black Book - 200 pages", R.drawable.hard_cover_black_book_200_pages,450));
        products.add(new Product("Exercises","HIT (Karatasi) Exercise Book - 200 pages", R.drawable.hit_karatasi_exercise_200_pages,115));
        products.add(new Product("Exercises","Olympic Exercise Book - 64 pages", R.drawable.olymoic_exercise_book_64_pages,60));
        products.add(new Product("Exercises","Kasuku Exercise Book - 200 pages", R.drawable.exercise_squared_book_200_pages,145));
        products.add(new Product("Exercises","Kasuku Exercise Book - 200 pages", R.drawable.exercise_squared_book_200_pages,80));
        products.add(new Product("Exercises","Kasuku Exercise Book - 200 pages", R.drawable.exercise_squared_book_200_pages,90));
        products.add(new Product("Exercises","Kasuku Exercise Book - 200 pages", R.drawable.exercise_squared_book_200_pages,120));

//Clipboards
        products.add(new Product("Clipboards","Black quality Clipboard", R.drawable.black_clip_board,500));
        products.add(new Product("Clipboards","Gray Amazing Clipboard", R.drawable.gray_clipboard,450));
        products.add(new Product("Clipboards","Two Pages red Clipboard", R.drawable.two_pages_clipboard,900));
        products.add(new Product("Clipboards","White and Blue Clipboards", R.drawable.blue_and_white_clipboard,780));

//Pencils
        products.add(new Product("Pencils","Hakuna Matata Patriot ", R.drawable.hakuna_matata_kenyan_pencil,500));
        products.add(new Product("Pencils","Gray Amazing Clipboard", R.drawable.staedtler_yellow_pencil,450));
        products.add(new Product("Pencils","Two Pages red Clipboard", R.drawable.apple_pencil,900));
        products.add(new Product("Pencils","White and Blue Clipboards", R.drawable.hb_superfine_pencil,780));

        //Staplers
        products.add(new Product("Staplers","Common Black Stapler", R.drawable.common_black_stapler,500));
        products.add(new Product("Staplers","Red Stapler gun", R.drawable.stapler_gun,450));
        products.add(new Product("Staplers","Large Office Stapler", R.drawable.kangaroo_stapler,900));
        products.add(new Product("Staplers","Original Kangaroo Stapler", R.drawable.red_stapler,780));

        //files
        products.add(new Product("Files","Box file Official", R.drawable.robin_box_file,500));
        products.add(new Product("Files","PVC Spring file", R.drawable.rapid_pvc_file,450));
        products.add(new Product("Files","Manilla file", R.drawable.tepee_manilla_spring_file,900));
        products.add(new Product("Files","Lateral file", R.drawable.lateral_tepee_file,780));

        //Glue
        products.add(new Product("Glue","Box file Official", R.drawable.glue_stick_office_glue,500));
        products.add(new Product("Glue","Paper print glue", R.drawable.paper_print_glue,450));
        products.add(new Product("Glue","Rolling tape glue", R.drawable.tape_glue,900));
        products.add(new Product("Glue","Super Sleek Smart Office Glue", R.drawable.super_sleek_office_glue,780));

        //rulers
        products.add(new Product("Rulers","Kaluma Official ruler", R.drawable.kaluma_ruler,500));
        products.add(new Product("Rulers","Teacher 1 metre ruler", R.drawable.teacher_ruler,450));
        products.add(new Product("Rulers","Smart yellow ruler", R.drawable.rulers,900));

        //Pins and Clips
        products.add(new Product("Pins","Kangaroo quality pins", R.drawable.kangaroo_stapler_pins,500));
        products.add(new Product("Pins","Noticeboard quality pins", R.drawable.notice_board_pins,450));
        products.add(new Product("Pins","Amazing stapler pins", R.drawable.stapler_pins,900));
        products.add(new Product("Pins","Stainless pins", R.drawable.stainless_pins,780));
        products.add(new Product("Pins","Unistock quality pins", R.drawable.unatock_stapler_pins,500));

        //Pens
        products.add(new Product("Pens","Bic sharp pointed pen", R.drawable.bic_blue_biro_pen,500));
        products.add(new Product("Pens","Bic blunt pen", R.drawable.blue_blunt_biro_pen,450));
        products.add(new Product("Pens","Executive biro pen", R.drawable.executive_biro_pen,900));
        products.add(new Product("Pens","Uniball biro pen", R.drawable.uniball_biro_pen,780));

        //Pencils
        products.add(new Product("Envelopes","A4 Quality envelopes", R.drawable.a4_brown_envelopes,500));
        products.add(new Product("Envelopes","A5 pack envelopes", R.drawable.a5_envelopes,450));
        products.add(new Product("Envelopes","B4 envelopes", R.drawable.b4_brown_envelopes,900));
        products.add(new Product("Envelopes","Letter size envelopes", R.drawable.letter_envelopes,780));

        //Calculators
        products.add(new Product("Calculators","Box file Official", R.drawable.business_calculator,500));
        products.add(new Product("Calculators","PVC Spring file", R.drawable.casio_calculator,450));
        products.add(new Product("Calculators","Manilla file", R.drawable.classwiz_scientific_calculator,900));
        products.add(new Product("Calculators","Lateral file", R.drawable.pink_casio_calculator,780));

        //Scissors
        products.add(new Product("Scissors","Box file Official", R.drawable.super_sleek_office_glue,500));
        products.add(new Product("Scissors","PVC Spring file", R.drawable.casio_calculator,450));

    }
}