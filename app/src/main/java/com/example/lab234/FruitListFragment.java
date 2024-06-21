package com.example.lab234;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.lab234.model.Fruit;

import java.util.ArrayList;

public class FruitListFragment extends Fragment {

    private ArrayList<Fruit> fruitList;
    private FruitAdapter adapter;

    public FruitListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fruit_list, container, false);

        // Initialize fruit data
        fruitList = new ArrayList<>();
        initializeFruits();

        // Initialize ListView and adapter
        ListView listView = view.findViewById(R.id.list_view_fruits);
        adapter = new FruitAdapter(getActivity(), fruitList);
        listView.setAdapter(adapter);

        return view;
    }

    private void initializeFruits() {
        // Replace with your actual fruit data (names, image resources, descriptions)
        fruitList.add(new Fruit("Apple", R.drawable.apple_image, "Sweet and crunchy"));
        fruitList.add(new Fruit("Banana", R.drawable.banana_image, "Soft and nutritious"));
        fruitList.add(new Fruit("Orange", R.drawable.orange_image, "Juicy and citrusy"));
        fruitList.add(new Fruit("Grapes", R.drawable.grapes_image, "Small, sweet, and seedless"));
        fruitList.add(new Fruit("Strawberry", R.drawable.strawberry_image, "Red, juicy, and sweet"));
        fruitList.add(new Fruit("Watermelon", R.drawable.watermelon_image, "Refreshing and hydrating"));
    }
}

