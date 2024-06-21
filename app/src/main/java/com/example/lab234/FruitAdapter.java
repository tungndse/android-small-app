package com.example.lab234;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab234.model.Fruit;

import java.util.ArrayList;

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private Context mContext;
    private ArrayList<Fruit> mFruitList;

    public FruitAdapter(Context context, ArrayList<Fruit> fruitList) {
        super(context, 0, fruitList);
        mContext = context;
        mFruitList = fruitList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item_fruit, parent, false);
        }

        Fruit currentFruit = mFruitList.get(position);

        TextView nameTextView = listItem.findViewById(R.id.tv_fruit_name);
        nameTextView.setText(currentFruit.getName());

        ImageView imageView = listItem.findViewById(R.id.iv_fruit_image);
        imageView.setImageResource(currentFruit.getImageResource());

        TextView descriptionTextView = listItem.findViewById(R.id.tv_fruit_description);
        descriptionTextView.setText(currentFruit.getDescription());

        return listItem;
    }
}
