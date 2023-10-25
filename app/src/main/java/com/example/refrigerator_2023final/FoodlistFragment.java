package com.example.refrigerator_2023final;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FoodlistFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodlistFragment extends Fragment {

    private View view;
    private String TAG = "FoodlistFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.i(TAG,"onCreateView");

        view = inflater.inflate(R.layout.activity_food_list_page, container, false);
        return view;
        // Inflate the layout for this fragmenr
    }
}