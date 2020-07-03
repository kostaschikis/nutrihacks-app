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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.nutrihacks_app.R;

import java.text.DecimalFormat;


public class BmiFragment extends Fragment {
    private double BMI;
    private String userDesignation;
    // Save Button
    private Button btnSubmit;
    // User Input
    private RadioGroup genderRadio;
    private RadioButton userGender;
    private EditText userHeight, userWeight;
    // Text View
    private TextView BMIText;
    private TextView designationText;

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
        BMIText = (TextView) root.findViewById(R.id.userBMI);
        designationText = (TextView) root.findViewById(R.id.userDesignation);

        // When user submits the form
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1. Find selected gender
                int selectedGender = genderRadio.getCheckedRadioButtonId();
                userGender = (RadioButton) root.findViewById(selectedGender);

                // 2. Validate user input
                if (!validateInput(userGender, userHeight.getText().toString(), userWeight.getText().toString())) {
                    Toast.makeText(getActivity(), "Please fill all the fields", Toast.LENGTH_LONG).show();
                    return;
                }

                // 3. Calculate BMI
                BMI = calculateBMI(userGender.getText().toString(),
                        Integer.parseInt(userHeight.getText().toString()),
                        Integer.parseInt(userWeight.getText().toString())
                );

                // 4. Find Designation
                userDesignation = findDesignation(BMI, userGender.getText().toString());

                // 5. Display BMI and Designation on screen | Set Text Views
                BMIText.setText(new DecimalFormat("##.#").format(BMI));
                designationText.setText(userDesignation);
            }

            // Validation: Checks if a form input is empty
            private boolean validateInput(RadioButton gender, String height, String weight) {
                if (height.equals("") || weight.equals("") || gender == null) {
                    return false;
                } else {
                    return true;
                }
            }

            private double calculateBMI(String gender, int height, int weight) {
                return weight / (Math.pow(height, 2)) * 10000;
            }

            // Finds designation based on given BMI
            private String findDesignation(double bmi, String userGender) {
                String designation = "";
                if (userGender.equals("Female")) {
                    designation = femaleDesignation(bmi);
                } else if (userGender.equals("Male")) {
                    designation = maleDesignation(bmi);
                }
                return designation;
            }

            private String femaleDesignation(double bmi) {

                if (bmi < 18.5) {
                    return "Underweight";
                } else if (bmi >= 18.5 && bmi <= 23.5) {
                    return "Normal";
                } else if (bmi >= 23.6 && bmi <= 28.6) {
                    return "Overweight";
                } else if (bmi >= 28.7 && bmi <= 40) {
                    return "Obese";
                } else if (bmi > 40) {
                    return "Morbidly obese";
                } else {
                    return null;
                }
            }

            private String maleDesignation(double bmi) {

                if (bmi < 19.5) {
                    return "Underweight";
                } else if (bmi >= 19.5 && bmi <= 24.9) {
                    return "Normal";
                } else if (bmi >= 25 && bmi <= 29.9) {
                    return "Overweight";
                } else if (bmi >= 30 && bmi <= 40) {
                    return "Obese";
                } else if (bmi > 40) {
                    return "Morbidly obese";
                } else {
                    return null;
                }
            }

        });

        return root;
    }
}
