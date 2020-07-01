package com.example.nutrihacks_app.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.nutrihacks_app.R;

public class GalleryFragment extends Fragment {

    GridView gridView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the View Layout
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        // Select Grid View
        gridView = (GridView) root.findViewById(R.id.grid_view);

        // Set image adapter to the Grid View
        gridView.setAdapter(new ImageAdapter(getActivity()));

        // Fullscreen
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), FullScreenActivity.class);
                intent.putExtra("id",position);
                startActivity(intent);
            }
        });

        return root;
    }
}
