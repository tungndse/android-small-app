package com.example.lab234.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab234.R;
import com.example.lab234.adapter.FoodAdapter;
import com.example.lab234.model.Food;

import java.util.ArrayList;

public class DrinkSelectionActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Food> drinkList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_selection);

        listView = findViewById(R.id.listViewFood);

        // Initialize drink list with sample data
        drinkList = new ArrayList<>();
        drinkList.add(new Food("Coca Cola", R.drawable.coca_img));
        drinkList.add(new Food("Heineken", R.drawable.heineken_img));
        drinkList.add(new Food("Tiger", R.drawable.tiger_img));
        drinkList.add(new Food("Saigon Red", R.drawable.saigonred_img));

        FoodAdapter adapter = new FoodAdapter(this, drinkList, false); // Pass false to hide delete button
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Food selectedDrink = drinkList.get(position);
                // Return to OrderFragment with selectedDrink
                Intent intent = new Intent();
                intent.putExtra("selected_food", selectedDrink);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
