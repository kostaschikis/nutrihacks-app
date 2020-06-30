package com.example.nutrihacks_app.ui.bmi;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.nutrihacks_app.R;

import org.w3c.dom.Text;

public class BmiFragment extends Fragment {
    // BMI
    private double BMI;
    private TextView designation;
    // Save Button
    private Button btnSubmit;
    // User Input
    private RadioGroup genderRadio;
    private RadioButton userGender;
    private EditText userHeight, userWeight;
    // Text View
    private TextView userBMI;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inflate the View Layout
        final View root = inflater.inflate(R.layout.fragment_bmi, container, false);

        // Submit Button
        btnSubmit = (Button) root.findViewById(R.id.btnCalc);
        // User Input
        genderRadio = (RadioGroup) root.findViewById(R.id.userGender);
        userHeight = (EditText) root.findViewById(R.id.userHeight);
        userWeight = (EditText) root.findViewById(R.id.userWeight);
        // Text Views
        userBMI = (TextView) root.findViewById(R.id.userBMI);
        designation = (TextView) root.findViewById(R.id.userDesignation);

        // User Submits the data
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Find selected gender
                int selectedGender = genderRadio.getCheckedRadioButtonId();
                userGender = (RadioButton) root.findViewById(selectedGender);
                // calculate BMI
                BMI = calculateBMI(userGender.getText().toString(), Integer.parseInt(String.valueOf(userHeight)), Integer.parseInt(String.valueOf(userWeight)));
                    userBMI.setText(Double.toString(BMI));

            }

            private double calculateBMI(String gender, int height, int weight) {
                double BMI = weight / (height * height);
                BMI = roundBMI(BMI);
                return BMI;
            }

            private void femaleBMI() {}

            private void maleBMI() {}

            private double roundBMI (double BMI) {
                BMI /= Math.pow(10, (int) Math.log10(f));
                BMI = ((int) (BMI * 10)) / 10.0f; // <-- performs one digit floor
                return Math.round(BMI);
            }

            private void writeBMI() {}


        });


        return root;
    }
}
