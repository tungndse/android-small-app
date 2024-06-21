package com.example.lab234.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.lab234.R;

public class CalculatorFragment extends Fragment {

    private EditText etNumber1, etNumber2;
    private RadioGroup radioGroup;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        Button buttonBack = view.findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });

        etNumber1 = view.findViewById(R.id.et_number1);
        etNumber2 = view.findViewById(R.id.et_number2);
        radioGroup = view.findViewById(R.id.radioGroup);
        btnCalculate = view.findViewById(R.id.btn_calculate);
        tvResult = view.findViewById(R.id.tv_result);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    float num1 = Float.parseFloat(etNumber1.getText().toString());
                    float num2 = Float.parseFloat(etNumber2.getText().toString());
                    float result = 0;

                    int selectedId = radioGroup.getCheckedRadioButtonId();

                    if (selectedId == R.id.rb_add) {
                        result = num1 + num2;
                    } else if (selectedId == R.id.rb_subtract) {
                        result = num1 - num2;
                    } else if (selectedId == R.id.rb_multiply) {
                        result = num1 * num2;
                    } else if (selectedId == R.id.rb_divide) {
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            tvResult.setText("Cannot divide by zero");
                            return;
                        }
                    }

                    tvResult.setText(String.valueOf(result));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    tvResult.setText("Invalid input");
                }
            }
        });

        return view;
    }
}
