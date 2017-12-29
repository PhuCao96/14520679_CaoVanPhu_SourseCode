package com.example.phucao.lab2_food;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtNameBT5;
    CheckBox btnPromotionBT5;
    Button btnAddBT5;

    GridView gridDishBT5;
    ArrayList<Dish> listDish;
    DishAdapter dishAdapter;

    Spinner spThumbnailBT5;
    ThumbnailAdapter thumbnailAdapter;
    ArrayList<Thumbnail> listThumbnail;

    int imageId;
    Drawable image;

    public enum ThumbnailEnum {
        Thumbnail1("Thumbnail 1", R.drawable.first_thumbnail),
        Thumbnail2("Thumbnail 2", R.drawable.second_thumbnail),
        Thumbnail3("Thumbnail 3", R.drawable.third_thumbnail),
        Thumbnail4("Thumbnail 4", R.drawable.fourth_thumbnail);

        private String name;
        private int img;

        ThumbnailEnum(String name, int img) {
            this.name = name;
            this.img = img;
        }

        public String getName() {
            return name;
        }

        public int getImage() {
            return img;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNameBT5 = (EditText) findViewById(R.id.txtNameBT5);
        txtNameBT5.setSelected(true);

        listThumbnail = new ArrayList<>();
        listThumbnail.add(new Thumbnail("Thumbnail 1", R.drawable.first_thumbnail));
        listThumbnail.add(new Thumbnail("Thumbnail 2", R.drawable.second_thumbnail));
        listThumbnail.add(new Thumbnail("Thumbnail 3", R.drawable.third_thumbnail));
        listThumbnail.add(new Thumbnail("Thumbnail 4", R.drawable.fourth_thumbnail));
        thumbnailAdapter = new ThumbnailAdapter(MainActivity.this, R.layout.item_thumbnail, listThumbnail);
        spThumbnailBT5 = (Spinner) findViewById(R.id.spThumbnailBT5);
        spThumbnailBT5.setAdapter(thumbnailAdapter);
        spThumbnailBT5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > -1) {
                    imageId = listThumbnail.get(i).getImage();
                } else {
                    imageId = R.drawable.bg_black_mask;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnPromotionBT5 = (CheckBox) findViewById(R.id.btnPromotionBT5);

        listDish = new ArrayList<>();
        dishAdapter = new DishAdapter(MainActivity.this, R.layout.item_dish, listDish);
        gridDishBT5 = (GridView) findViewById(R.id.gridDishBT5);
        gridDishBT5.setAdapter(dishAdapter);

        btnAddBT5 = (Button) findViewById(R.id.btnAddBT5);
        btnAddBT5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Toast.makeText(MainActivity.this, "Added successfully", Toast.LENGTH_SHORT).show();
                    listDish.add(new Dish(txtNameBT5.getText().toString(), imageId, btnPromotionBT5.isChecked()));
                    dishAdapter.notifyDataSetChanged();
                } catch (Exception ex) {
                    Log.i("ERROR", ex.getMessage());
                }
            }
        });
    }
}

