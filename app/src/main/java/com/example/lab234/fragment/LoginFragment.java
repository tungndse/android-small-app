package com.example.lab234.fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

import com.example.lab234.R;

public class LoginFragment extends Fragment {

    private EditText etUsername, etPassword;
    private Button btnLogin;
    private SharedPreferences sharedPreferences;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        Button buttonBack = view.findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(v -> getParentFragmentManager().popBackStack());

        sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        etUsername = view.findViewById(R.id.et_username);
        etPassword = view.findViewById(R.id.et_password);
        btnLogin = view.findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                // Retrieve stored credentials
                String storedUsername = sharedPreferences.getString("username", "");
                String storedPassword = sharedPreferences.getString("password", "");

                if (username.equals(storedUsername) && password.equals(storedPassword)) {
                    // Login successful
                    Toast.makeText(getContext(), "Login successful", Toast.LENGTH_SHORT).show();
                    // Proceed with your login logic (e.g., navigate to next screen)
                } else {
                    // Login failed
                    Toast.makeText(getContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
