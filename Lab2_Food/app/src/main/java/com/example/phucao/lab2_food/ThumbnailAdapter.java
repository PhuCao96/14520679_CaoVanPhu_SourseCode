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

public class ThumbnailAdapter extends ArrayAdapter<Thumbnail> {
    Activity activity;
    int resource;
    List<Thumbnail> objects;

    public ThumbnailAdapter(@NonNull Activity activity, @LayoutRes int resource, @NonNull List<Thumbnail> objects) {
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
        Thumbnail thumbnail = this.objects.get(position);

        // Get view
        TextView txtThumbnailItem = row.findViewById(R.id.txtThumbnailItem);
        ImageView imgThumbnailItem = row.findViewById(R.id.imgThumbnailItem);

        // Set thumbnail name
        txtThumbnailItem.setText(thumbnail.getName());

        // Set thumbnail image
        imgThumbnailItem.setImageResource(thumbnail.getImage());

        return row;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.activity.getLayoutInflater();
        View row = inflater.inflate(this.resource,null);

        // Get item
        Thumbnail thumbnail = this.objects.get(position);

        // Get view
        TextView txtThumbnailItem = row.findViewById(R.id.txtThumbnailItem);
        ImageView imgThumbnailItem = row.findViewById(R.id.imgThumbnailItem);

        // Set thumbnail name
        txtThumbnailItem.setText(thumbnail.getName());

        // Set thumbnail image
        imgThumbnailItem.setImageResource(thumbnail.getImage());

        return row;
    }
}
