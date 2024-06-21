package com.example.lab234;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterFragment extends Fragment {

    private EditText etUsername, etPassword, etConfirmPassword;
    private Button btnRegister;

    private SharedPreferences sharedPreferences;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        etUsername = view.findViewById(R.id.et_username);
        etPassword = view.findViewById(R.id.et_password);
        etConfirmPassword = view.findViewById(R.id.et_confirm_password);
        btnRegister = view.findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String confirmPassword = etConfirmPassword.getText().toString().trim();

                if (isValidRegistration(username, password, confirmPassword)) {
                    // Store registration data in SharedPreferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", username);
                    editor.putString("password", password);
                    editor.apply();

                    // Clear input fields
                    etUsername.setText("");
                    etPassword.setText("");
                    etConfirmPassword.setText("");

                    Toast.makeText(getContext(), "Registration successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Registration failed. Please check your inputs.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    // Validation method (replace with your actual validation logic)
    private boolean isValidRegistration(String username, String password, String confirmPassword) {
        return !username.isEmpty() && password.equals(confirmPassword);
    }
}


