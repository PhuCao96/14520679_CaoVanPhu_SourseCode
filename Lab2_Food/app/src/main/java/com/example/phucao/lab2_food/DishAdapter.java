package com.example.phucao.lab2_food;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class DishAdapter extends ArrayAdapter<Dish> {
    Activity activity;
    int resource;
    List<Dish> objects;

    public DishAdapter(@NonNull Activity activity, @LayoutRes int resource, @NonNull List<Dish> objects) {
        super(activity, resource, objects);

        this.activity = activity;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.activity.getLayoutInflater();
        View row = inflater.inflate(this.resource,null);

        // Get item
        Dish dish = this.objects.get(position);

        // Get view
        ImageView imgDish = row.findViewById(R.id.imgDish);
        ImageView imgPromotion = row.findViewById(R.id.imgPromotion);
        TextView txtDish = row.findViewById(R.id.txtDish);

        // Set dish name
        if (dish.getName() != null) {
            txtDish.setText(dish.getName());
        }
        else {
            txtDish.setText("");
        }

        // Set dish image
        imgDish.setImageResource(dish.getImage());

        // If is promotion --> show icon
        if (dish.isPromotion()) {
            imgPromotion.setVisibility(View.VISIBLE);
        }
        else {
            imgPromotion.setVisibility(View.INVISIBLE);
        }

        return row;
    }
}
