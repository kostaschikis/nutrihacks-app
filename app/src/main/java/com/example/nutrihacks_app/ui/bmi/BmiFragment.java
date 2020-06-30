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

import org.w3c.dom.Text;

import java.text.DecimalFormat;

import javax.xml.validation.Validator;

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
                // Validate user input
//                validate();
                // calculate BMI
                BMI = calculateBMI(userGender.getText().toString(), Integer.parseInt(userHeight.getText().toString()), Integer.parseInt(userWeight.getText().toString()));
                // Find Designation
                String des = findDesignation(BMI, userGender.getText().toString());
                // Set Text Views (BMI and Designation)
                userBMI.setText(new DecimalFormat("##.#").format(BMI));
                designation.setText(des);
            }

            private void validate() {
                if (userHeight.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), userHeight.getText().toString(), Toast.LENGTH_LONG).show();
                }
            }

            private double calculateBMI(String gender, int height, int weight) {
                return weight / (Math.pow(height, 2)) * 10000;
            }

            private String findDesignation(double bmi, String userGender) {
                String designation = "";
                if (userGender.equals("Female")) {
                    designation = femaleDes(bmi);
                } else if (userGender.equals("Male")) {
                    designation = maleDes(bmi);
                }
                return designation;
            }

            private String femaleDes(double bmi) {

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
                } else  {
                    return null;
                }
            }

            private String maleDes(double bmi) {

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
                } else  {
                    return null;
                }
            }

        });


        return root;
    }
}
