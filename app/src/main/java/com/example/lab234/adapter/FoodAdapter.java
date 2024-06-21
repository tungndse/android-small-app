package com.example.lab234.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab234.R;
import com.example.lab234.model.Food;

import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<Food> {

    private Context context;
    private ArrayList<Food> foods;

    public FoodAdapter(Context context, ArrayList<Food> foods) {
        super(context, 0, foods);
        this.context = context;
        this.foods = foods;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_food, parent, false);
        }

        Food currentFood = getItem(position);

        ImageView imageViewFood = convertView.findViewById(R.id.imageViewFood);
        TextView textViewFoodName = convertView.findViewById(R.id.textViewFoodName);

        if (currentFood != null) {
            imageViewFood.setImageResource(currentFood.getImageResource());
            textViewFoodName.setText(currentFood.getName());
        }

        return convertView;
    }
}

