package com.example.widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void simpleToast(View view) {

        //context object
        Context context = getApplicationContext();
        //message to user
        CharSequence text = "Hello toast!";
        //Message display time.
        int duration = Toast.LENGTH_SHORT;

        /*
        1. First parameter is the context
        2. User message
        3. Duration (Long and Short)

        Building to toast object using makeText method
         */
        Toast toast = Toast.makeText(context, text, duration);
        //Custom position of the toast message
        /*
        Fist param is corner position
        Second - Adjust the messaage position to right
        Third - Adjust the message position to bottom.
         */
        toast.setGravity(Gravity.TOP| Gravity.LEFT, 100, 500);
        // show() method to show the message to user.
        toast.show();
    }

    // Handling the customToastMessage Button click
    public void customToastMessage(View view) {

        //LayoutInflater object to get access of layout resources
        LayoutInflater inflater = getLayoutInflater();
        // inflate method takes two parameter
        // First is - layout id
        //second is ViewGroup id ie. root layout id (LinearLayout or RelativeLayout)
        View layout = inflater.inflate(R.layout.custom_toast,(ViewGroup) findViewById(R.id.custom_toast_container) );
        // Creating the TextView object
        TextView text = (TextView) layout.findViewById(R.id.text);
        // Setting the message to textView
        text.setText("This is a custom toast");
        //setting the textColor Dynamically
        text.setTextColor(getResources().getColor(R.color.colorAccent));
        // Creating the toast object
        Toast toast = new Toast(getApplicationContext());
        // Setting the custom position of message
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        // Setting the message display time
        toast.setDuration(Toast.LENGTH_LONG);
        // Assigning the custom layout object
        toast.setView(layout);
        // Showing the message to user.
        toast.show();

    }

    public void goToWidgetsAcitivity(View view) {
        Intent intent = new Intent(this, Widgets.class);
        startActivity(intent);
    }
}
