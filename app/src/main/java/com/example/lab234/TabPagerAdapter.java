package com.example.lab234;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.lab234.model.Fruit;

public class TabPagerAdapter extends FragmentPagerAdapter {

    private static final int NUM_TABS = 6;

    public TabPagerAdapter(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new RandomNumberFragment();
            case 1:
                return new CalculatorFragment();
            case 2:
                return new LoginFragment();
            case 3:
                return new RegisterFragment();
            case 4:
                return new ListViewFragment();
            case 5:
                return new FruitListFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_TABS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Return tab title based on position (optional)
        switch (position) {
            case 0:
                return "Random";
            case 1:
                return "Calculator";
            case 2:
                return "Login";
            case 3:
                return "Register";
            case 4:
                return "List View";
            case 5:
                return "Fruit List";
            default:
                return null;
        }
    }
}
