package com.noah.knowyourbcquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    int finalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when all the radioButtons/checkBoxes are clicked (to see how the grade changes online)
     * and the finish button is clicked.
     */
    public void answers_check(View view) {

        EditText answer_1_input = (EditText) findViewById(R.id.answer_1);
        String answer_1 = answer_1_input.getText().toString();


        CheckBox answer_2_1 = (CheckBox) findViewById(R.id.answer_2_1);
        CheckBox answer_2_2 = (CheckBox) findViewById(R.id.answer_2_2);
        CheckBox answer_2_3 = (CheckBox) findViewById(R.id.answer_2_3);
        CheckBox answer_2_4 = (CheckBox) findViewById(R.id.answer_2_4);
        CheckBox answer_2_5 = (CheckBox) findViewById(R.id.answer_2_5);

        RadioButton answer_3_1 = (RadioButton) findViewById(R.id.answer_3_1);
        RadioButton answer_3_2 = (RadioButton) findViewById(R.id.answer_3_2);
        RadioButton answer_3_3 = (RadioButton) findViewById(R.id.answer_3_3);

        RadioButton answer_4_1 = (RadioButton) findViewById(R.id.answer_4_1);
        RadioButton answer_4_2 = (RadioButton) findViewById(R.id.answer_4_2);
        RadioButton answer_4_3 = (RadioButton) findViewById(R.id.answer_4_3);

        RadioButton answer_5_1 = (RadioButton) findViewById(R.id.answer_5_1);
        RadioButton answer_5_2 = (RadioButton) findViewById(R.id.answer_5_2);

        RadioButton answer_6_1 = (RadioButton) findViewById(R.id.answer_6_1);
        RadioButton answer_6_2 = (RadioButton) findViewById(R.id.answer_6_2);

        finalScore = 0;

        EditText nameInput = (EditText) findViewById(R.id.name);
        String name = nameInput.getText().toString();

        if (answer_1.matches("Condom")) {
            finalScore++;
        }

        if (answer_2_2.isChecked() || answer_2_4.isChecked()) ;{
            finalScore++;

        }
        if (answer_3_2.isChecked());{
            finalScore++;
        }

        if (answer_4_2.isChecked());{
            finalScore++;
        }

        if (answer_5_1.isChecked());{
            finalScore++;
        }

        if (answer_6_2.isChecked());{
            finalScore++;
        }
    }


}
