package com.example.widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Widgets extends AppCompatActivity {

    CheckBox checkBox;
    ToggleButton toggleButton;

    RadioGroup radioGroup;
    RadioButton radioButton;

    Switch mySwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets);
        // Calling the checkbox method
        checkBox();

        // Toggle button method call
        toggleButton();

        // RadioButton method call
        radioButton();

        mySwitch = findViewById(R.id.switch_button);

        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String checked_status = String.valueOf(isChecked);
                Toast.makeText(Widgets.this, "Switched state : " + checked_status, Toast.LENGTH_SHORT).show();
            }
        });


    }

    // RadioButton Method definition
    private void radioButton() {
        radioGroup = findViewById(R.id.radio_group);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                radioButton = findViewById(checkedId);
                String  button_string = (String) radioButton.getText();
                Toast.makeText(Widgets.this, "Checked id is : " + button_string , Toast.LENGTH_SHORT).show();
            }
        });
    }

    // toggle button method definition
    private void toggleButton() {
        toggleButton = findViewById(R.id.toggleButton);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Toast.makeText(Widgets.this, "checked", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Widgets.this, "Not checked", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    // checkBox method definition
    private void checkBox() {
        // Creating the object of CheckBox
        checkBox = findViewById(R.id.button_checkbox);

        // Calling the check change listener method form checkBox class
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Toast.makeText(Widgets.this, "Checked", Toast.LENGTH_SHORT).show();
            }

        });
    }

    // Overridden method to check android configuration changes
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }

}
