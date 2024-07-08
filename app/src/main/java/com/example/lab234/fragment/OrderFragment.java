package com.example.lab234.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lab234.R;
import com.example.lab234.activity.DrinkSelectionActivity;
import com.example.lab234.activity.FoodSelectionActivity;
import com.example.lab234.adapter.FoodAdapter;
import com.example.lab234.model.Food;

import java.util.ArrayList;

public class OrderFragment extends Fragment {

    private ArrayList<Food> chosenFoods;
    private FoodAdapter chosenFoodsAdapter;
    private ListView listViewChosenFoods;
    private static final int REQUEST_CODE_FOOD_SELECTION = 100;
    private static final int REQUEST_CODE_DRINK_SELECTION = 90;

    public OrderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        // Initialize views
        Button buttonOrderFood = view.findViewById(R.id.buttonOrderFood);
        Button buttonOrderDrink = view.findViewById(R.id.buttonOrderDrink);
        Button buttonBack = view.findViewById(R.id.buttonBack);
        listViewChosenFoods = view.findViewById(R.id.listViewChosenFoods);

        // Set up list and adapter
        chosenFoods = new ArrayList<>();
        chosenFoodsAdapter = new FoodAdapter(getActivity(), chosenFoods, true); // Pass true to show delete button
        listViewChosenFoods.setAdapter(chosenFoodsAdapter);

        // Button click listeners
        buttonOrderFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FoodSelectionActivity.class);
                startActivityForResult(intent, REQUEST_CODE_FOOD_SELECTION);
            }
        });

        buttonOrderDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DrinkSelectionActivity.class);
                startActivityForResult(intent, REQUEST_CODE_DRINK_SELECTION);
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle back button click (if needed)
                getParentFragmentManager().popBackStack();
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == getActivity().RESULT_OK) {
            if (data != null) {
                if (requestCode == REQUEST_CODE_FOOD_SELECTION) {
                    Food selectedFood = data.getParcelableExtra("selected_food");
                    if (selectedFood != null) {
                        chosenFoods.add(selectedFood);
                        chosenFoodsAdapter.notifyDataSetChanged();
                    }
                } else if (requestCode == REQUEST_CODE_DRINK_SELECTION) {
                    Food selectedDrink = data.getParcelableExtra("selected_food");
                    if (selectedDrink != null) {
                        chosenFoods.add(selectedDrink);
                        chosenFoodsAdapter.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
