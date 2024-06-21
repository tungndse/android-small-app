package com.example.lab234.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.lab234.R;

import java.util.ArrayList;

public class ListViewFragment extends Fragment {

    private ArrayList<String> itemList;
    private ArrayAdapter<String> adapter;
    private EditText etNewItem;
    private Button btnAdd, btnUpdate;
    private ListView listView;

    public ListViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_view, container, false);

        Button buttonBack = view.findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(v -> getParentFragmentManager().popBackStack());

        itemList = new ArrayList<>();
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, itemList);

        etNewItem = view.findViewById(R.id.et_new_item);
        btnAdd = view.findViewById(R.id.btn_add);
        btnUpdate = view.findViewById(R.id.btn_update);
        listView = view.findViewById(R.id.list_view);

        listView.setAdapter(adapter);

        // Add item to the list
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNewItem.setVisibility(View.VISIBLE);
                btnUpdate.setVisibility(View.VISIBLE);
            }
        });

        // Update list with new item
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = etNewItem.getText().toString().trim();
                if (!newItem.isEmpty()) {
                    itemList.add(newItem);
                    adapter.notifyDataSetChanged();
                    etNewItem.setText("");
                    etNewItem.setVisibility(View.GONE);
                    btnUpdate.setVisibility(View.GONE);
                }
            }
        });

        // Handle item click to delete
        listView.setOnItemClickListener((parent, view1, position, id) -> {
            String item = itemList.get(position);
            itemList.remove(position);
            adapter.notifyDataSetChanged();
            Toast.makeText(getContext(), "Item deleted: " + item, Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}


