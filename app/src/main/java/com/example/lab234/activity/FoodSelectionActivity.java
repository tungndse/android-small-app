package com.example.lab234.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab234.adapter.FoodAdapter;
import com.example.lab234.R;
import com.example.lab234.model.Food;

import java.util.ArrayList;

public class FoodSelectionActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Food> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_selection);

        listView = findViewById(R.id.listViewFood);

        // Initialize food list with sample data
        foodList = new ArrayList<>();
        foodList.add(new Food("Bun Bo Hue", R.drawable.bunbohue_img));
        foodList.add(new Food("Pho Ha Noi", R.drawable.phohanoi_img));
        foodList.add(new Food("Mi Quang", R.drawable.miquang_img));
        foodList.add(new Food("Hu Tiu Sai Gon", R.drawable.hutiusaigon_img));

        FoodAdapter adapter = new FoodAdapter(this, foodList);
        listView.setAdapter(adapter);

        // Set item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Food selectedFood = foodList.get(position);
                // Return to OrderFragment with selectedFood
                Intent intent = new Intent();
                intent.putExtra("selected_food", selectedFood);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}



