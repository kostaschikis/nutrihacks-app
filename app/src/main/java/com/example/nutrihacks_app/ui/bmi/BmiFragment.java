package com.example.nutrihacks_app.ui.bmi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.nutrihacks_app.R;

public class BmiFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inflate the View Layout
        View root = inflater.inflate(R.layout.fragment_bmi, container, false);

        final TextView textView = root.findViewById(R.id.text_bmi);
        textView.setText("BMI Page");

        return root;
    }
}
