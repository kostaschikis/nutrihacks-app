package com.example.nutrihacks_app.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.nutrihacks_app.ImageAdapter;
import com.example.nutrihacks_app.R;

public class GalleryFragment extends Fragment {

    GridView gridView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        // Select Grid View
        gridView = (GridView) root.findViewById(R.id.grid_view);

        // Set image adapter to the Grid View
        gridView.setAdapter(new ImageAdapter(getActivity()));

        return root;
    }
}
