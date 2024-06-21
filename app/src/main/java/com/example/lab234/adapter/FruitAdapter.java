package com.example.lab234.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lab234.R;
import com.example.lab234.model.Fruit;

import java.util.ArrayList;

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private Context context;
    private ArrayList<Fruit> fruits;

    public FruitAdapter(Context context, ArrayList<Fruit> fruits) {
        super(context, 0, fruits);
        this.context = context;
        this.fruits = fruits;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(context).inflate(R.layout.list_item_fruit, parent, false);
        }

        Fruit currentFruit = fruits.get(position);

        ImageView imageView = listItem.findViewById(R.id.imageView);
        imageView.setImageResource(currentFruit.getImageResource());

        TextView nameTextView = listItem.findViewById(R.id.textViewName);
        nameTextView.setText(currentFruit.getName());

        TextView descriptionTextView = listItem.findViewById(R.id.textViewDescription);
        descriptionTextView.setText(currentFruit.getDescription());

        return listItem;
    }
}
