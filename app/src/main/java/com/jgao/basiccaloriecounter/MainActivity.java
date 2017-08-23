package com.jgao.basiccaloriecounter;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private int sp;
    private int tp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.whichExercise);
        Spinner spinner2 = (Spinner) findViewById(R.id.convertExercise);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.exercise_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(this);

        final Button button = (Button) findViewById(R.id.button);
        final EditText editText = (EditText) findViewById(R.id.editText);
        final TextView outputText = (TextView) findViewById(R.id.outputText);
        final String c = " Calories Burned";

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                int et;
                try {
                    et = Integer.parseInt(editText.getText().toString());
                } catch (Exception e) {
                    et = 0;
                }

                //First, get the number of calories per exercise.
                double perCal;
                switch (sp) {
                    case 0:
                        //Calories
                        perCal = 1;
                        break;
                    case 1:
                        //Pushup
                        perCal = 350./100;
                        break;
                    case 2:
                        //Situp
                        perCal = 200./100;
                        break;
                    case 3:
                        //Jumping Jacks
                        perCal = 10./100;
                        break;
                    case 4:
                        //Jogging
                        perCal = 12./100;
                        break;
                    case 5:
                        //Jogging
                        perCal = 225./100;
                        break;
                    case 6:
                        //Jogging
                        perCal = 25./100;
                        break;
                    case 7:
                        //Jogging
                        perCal = 25./100;
                        break;
                    case 8:
                        //Jogging
                        perCal = 100./100;
                        break;
                    case 9:
                        //Jogging
                        perCal = 12./100;
                        break;
                    case 10:
                        //Jogging
                        perCal = 20./100;
                        break;
                    case 11:
                        //Jogging
                        perCal = 13./100;
                        break;
                    case 12:
                        //Jogging
                        perCal = 15./100;
                        break;
                    default:
                        perCal = 0;
                        break;
                }
                double ot = et / perCal;

                //Then, get the equivalent conversion.
                double equivalent;
                String tag = "";
                switch (tp) {
                    case 0:
                        //Calories
                        equivalent = 1;
                        tag = "Calories Burned";
                        break;
                    case 1:
                        //Pushup
                        equivalent = 350./100;
                        tag = "Pushups";
                        break;
                    case 2:
                        //Situp
                        equivalent = 200./100;
                        tag = "Situps";
                        break;
                    case 3:
                        //Jumping Jacks
                        equivalent = 10./100;
                        tag = "Minute(s) of Jumping Jacks";
                        break;
                    case 4:
                        //Jogging
                        equivalent = 12./100;
                        tag = "Minute(s) of Jogging";
                        break;
                    case 5:
                        //Jogging
                        equivalent = 225./100;
                        tag = "Squats";
                        break;
                    case 6:
                        //Jogging
                        equivalent = 25./100;
                        tag = "Minutes of leg-lifts";
                        break;
                    case 7:
                        //Jogging
                        equivalent = 25./100;
                        tag = "Minutes of Planks";
                        break;
                    case 8:
                        //Jogging
                        equivalent = 100./100;
                        tag = "Pullups";
                        break;
                    case 9:
                        //Jogging
                        equivalent = 12./100;
                        tag = "Minutes of cycling";
                        break;
                    case 10:
                        //Jogging
                        equivalent = 20./100;
                        tag = "Minutes of walking";
                        break;
                    case 11:
                        //Jogging
                        equivalent = 13./100;
                        tag = "Minutes of swimming";
                        break;
                    case 12:
                        //Jogging
                        equivalent = 15./100;
                        tag = "Minutes of stair-climbing";
                        break;
                    default:
                        equivalent = 0;
                        break;
                }
                int ot2 = (int) Math.round(ot * equivalent);
                outputText.setText((Integer.toString(ot2) + " " + tag));
            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        System.out.println(parent.getId());
        switch (parent.getId()) {
            case 2131492952:
                //whichExercise
                this.sp = position;
                break;
            case 2131492954:
                //whichExercise
                this.sp = position;
                break;
            case 2131492956:
                this.tp = position;
                break;
            default:
                break;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        this.sp = 0;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // ignore orientation change
        if (newConfig.orientation != Configuration.ORIENTATION_LANDSCAPE) {
            super.onConfigurationChanged(newConfig);
        }
    }
}
