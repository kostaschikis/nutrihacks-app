package com.example.nutrihacks_app.ui.team;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.nutrihacks_app.R;

public class TeamFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inflate the View Layout
        View root = inflater.inflate(R.layout.fragment_team, container, false);

        return root;
    }
}
