package com.example.lab234.fragment;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

import com.example.lab234.R;

public class RandomNumberFragment extends Fragment {

    private EditText etMin, etMax;
    private Button btnGenerate;
    private TextView tvResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_random_number, container, false);

        Button buttonBack = view.findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(v -> getParentFragmentManager().popBackStack());

        etMin = view.findViewById(R.id.et_min);
        etMax = view.findViewById(R.id.et_max);
        btnGenerate = view.findViewById(R.id.btn_generate);
        tvResult = view.findViewById(R.id.tv_result);

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int min = Integer.parseInt(etMin.getText().toString());
                    int max = Integer.parseInt(etMax.getText().toString());
                    int randomNumber = getRandomNumber(min, max);
                    tvResult.setText(String.valueOf(randomNumber));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    tvResult.setText("Invalid input");
                }
            }
        });

        return view;
    }

    private int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}


