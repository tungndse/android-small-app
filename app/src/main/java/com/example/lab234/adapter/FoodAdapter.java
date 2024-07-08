package com.example.lab234.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab234.R;
import com.example.lab234.model.Food;

import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<Food> {

    private Context context;
    private ArrayList<Food> foods;
    private boolean showDeleteButton;

    public FoodAdapter(Context context, ArrayList<Food> foods, boolean showDeleteButton) {
        super(context, 0, foods);
        this.context = context;
        this.foods = foods;
        this.showDeleteButton = showDeleteButton;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            int layoutId = showDeleteButton ? R.layout.list_item_ordered_food : R.layout.list_item_food;
            convertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        }

        Food currentFood = getItem(position);

        ImageView imageViewFood = convertView.findViewById(R.id.imageViewFood);
        TextView textViewFoodName = convertView.findViewById(R.id.textViewFoodName);

        if (currentFood != null) {
            imageViewFood.setImageResource(currentFood.getImageResource());
            textViewFoodName.setText(currentFood.getName());
        }

        if (showDeleteButton) {
            Button buttonDeleteFood = convertView.findViewById(R.id.buttonDeleteFood);
            buttonDeleteFood.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    foods.remove(position);
                    notifyDataSetChanged();
                }
            });
        }

        return convertView;
    }
}


