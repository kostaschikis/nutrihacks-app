package com.example.nutrihacks_app.ui.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.nutrihacks_app.R;

public class FullScreenActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        // Get image view from layout
        imageView = (ImageView) findViewById(R.id.image_view);

        // Hide Action Bar
        getSupportActionBar().hide();
        getSupportActionBar().setTitle("Full Screen Image");

        // Get Intent from GalleryFragment
        Intent i = getIntent();

        // Get image id from intent
        int position = i.getExtras().getInt("id");

        // Find image based on id
        ImageAdapter imageAdapter = new ImageAdapter(this);

        // Display image
        imageView.setImageResource(imageAdapter.imageArray[position]);
    }
}