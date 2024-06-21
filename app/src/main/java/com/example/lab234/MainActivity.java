package com.example.lab234;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.lab234.fragment.CalculatorFragment;
import com.example.lab234.fragment.FruitListFragment;
import com.example.lab234.fragment.ListViewFragment;
import com.example.lab234.fragment.LoginFragment;
import com.example.lab234.fragment.OrderFragment;
import com.example.lab234.fragment.RandomNumberFragment;
import com.example.lab234.fragment.RegisterFragment;

public class MainActivity extends AppCompatActivity {

    private LinearLayout buttonContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonContainer = findViewById(R.id.buttonContainer);

        findViewById(R.id.buttonCalculator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new CalculatorFragment());
            }
        });

        findViewById(R.id.buttonRandomNumber).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new RandomNumberFragment());
            }
        });

        findViewById(R.id.buttonLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new LoginFragment());
            }
        });

        findViewById(R.id.buttonRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new RegisterFragment());
            }
        });

        findViewById(R.id.buttonListView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new ListViewFragment());
            }
        });

        findViewById(R.id.buttonFruitList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new FruitListFragment());
            }
        });

        findViewById(R.id.buttonOrderFoodDrink).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new OrderFragment());
            }
        });

        // Add a back stack change listener to show the button container when the back stack is empty
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                    buttonContainer.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void openFragment(Fragment fragment) {
        buttonContainer.setVisibility(View.GONE);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit();
    }
}
