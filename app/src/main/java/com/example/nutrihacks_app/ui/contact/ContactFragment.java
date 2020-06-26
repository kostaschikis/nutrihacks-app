package com.example.nutrihacks_app.ui.contact;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.nutrihacks_app.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class ContactFragment extends Fragment {
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inflate the View Layout
        View root = inflater.inflate(R.layout.fragment_contact, container, false);

        final Button btnsave = root.findViewById(R.id.btnSave);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = "kostas";
                String email = "kostachikis@gmail.com";
                writeNewUser("1", name, email);
            }
        });

        // final TextView textView = root.findViewById(R.id.text_contact);
        // textView.setText("Contact Page");
        return root;
    }

    private void writeNewUser(String userId, String name, String email) {
        User user = new User(name, email);

        database.child("users").child(userId).setValue(user);
    }


}