package com.noah.knowyourbcquiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.text.method.LinkMovementMethod;

public class MainActivity extends AppCompatActivity {

    int finalScore = 0;

    EditText nameInput;

    EditText answer_1;

    CheckBox answer_2_1;
    CheckBox answer_2_2;
    CheckBox answer_2_3;
    CheckBox answer_2_4;
    CheckBox answer_2_5;

    RadioGroup answer_3;
    RadioButton answer_3_2;

    RadioGroup answer_4;
    RadioButton answer_4_2;

    RadioGroup answer_5;
    RadioButton answer_5_1;

    RadioGroup answer_6;
    RadioButton answer_6_2;

    boolean showFinalScore = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        TextView who = (TextView) findViewById(R.id.link_who);
        who.setMovementMethod(LinkMovementMethod.getInstance());

        TextView yourLife = (TextView) findViewById(R.id.link_your_life);
        yourLife.setMovementMethod(LinkMovementMethod.getInstance());

        nameInput = (EditText) findViewById(R.id.name);

        answer_1 = (EditText) findViewById(R.id.answer_1);

        answer_2_1 = (CheckBox) findViewById(R.id.answer_2_1);
        answer_2_2 = (CheckBox) findViewById(R.id.answer_2_2);
        answer_2_3 = (CheckBox) findViewById(R.id.answer_2_3);
        answer_2_4 = (CheckBox) findViewById(R.id.answer_2_4);
        answer_2_5 = (CheckBox) findViewById(R.id.answer_2_5);

        answer_3 = (RadioGroup) findViewById(R.id.answer_3);
        answer_3_2 = (RadioButton) findViewById(R.id.answer_3_2);

        answer_4 = (RadioGroup) findViewById(R.id.answer_4);
        answer_4_2 = (RadioButton) findViewById(R.id.answer_4_2);

        answer_5 = (RadioGroup) findViewById(R.id.answer_5);
        answer_5_1 = (RadioButton) findViewById(R.id.answer_5_1);

        answer_6 = (RadioGroup) findViewById(R.id.answer_6);
        answer_6_2 = (RadioButton) findViewById(R.id.answer_6_2);

    }

    /**
     * This method sums the right answered questions and stores the score in "finalScore"
     */
    public void answers_check() {

        finalScore = 0;
        String answer_1s = answer_1.getText().toString().toLowerCase();

        boolean answer_2_1b = answer_2_1.isChecked();
        boolean answer_2_4b = answer_2_4.isChecked();
        boolean answer_2_2b = answer_2_2.isChecked();
        boolean answer_2_3b = answer_2_3.isChecked();
        boolean answer_2_5b = answer_2_5.isChecked();

        if (answer_1s.matches("condom")||answer_1s.matches("condoms")||answer_1s.matches("a condom")) {
            finalScore++;
        }

        if (answer_2_1b && answer_2_4b && (!answer_2_2b) && (!answer_2_3b) && (!answer_2_5b)) {
            finalScore++;
        }
        if (answer_3_2.isChecked()) {
            finalScore++;
        }

        if (answer_4_2.isChecked()) {
            finalScore++;
        }

        if (answer_5_1.isChecked()) {
            finalScore++;
        }

        if (answer_6_2.isChecked()) {
            finalScore++;
        }
    }


    /**
     * This method checks if all the questions are answered.
     */
    public boolean findIfAllQuestionsAnswered() {
        String answer_1s = answer_1.getText().toString();
        boolean answer_2_1b = answer_2_1.isChecked();
        boolean answer_2_2b = answer_2_2.isChecked();
        boolean answer_2_3b = answer_2_3.isChecked();
        boolean answer_2_4b = answer_2_4.isChecked();
        boolean answer_2_5b = answer_2_5.isChecked();

        if (answer_1s.matches("") ||
                (!answer_2_1b) && (!answer_2_2b) && (!answer_2_3b) && (!answer_2_4b) && (!answer_2_5b) ||
                answer_3.getCheckedRadioButtonId() == -1 ||
                answer_4.getCheckedRadioButtonId() == -1 ||
                answer_5.getCheckedRadioButtonId() == -1 ||
                answer_6.getCheckedRadioButtonId() == -1) {
            return false;

        } else {
            return true;
        }
    }

    /**
     * This method is called when finish button is clicked.
     */

    public void finish(View view) {

        answers_check();

        nameInput = (EditText) findViewById(R.id.name);
        String name = nameInput.getText().toString();

        if (name.matches("")) {
            name = getString(R.string.hi_there);
        }

        if (findIfAllQuestionsAnswered()) {
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle(R.string.final_answer_title);
            alertDialog.setMessage(name + getString(R.string.final_answer_1)+ " " + finalScore + getString(R.string.final_answer_2)+
                    getString(R.string.final_answer_3));
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, getString(R.string.ok_button_final_answer),
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            showFinalScore = false;
                        }
                    });
            alertDialog.show();
            showFinalScore = true;

        } else {
            Toast toast = Toast.makeText(this, R.string.incomplete_toast, Toast.LENGTH_LONG);
            LinearLayout layout = (LinearLayout) toast.getView();
            if (layout.getChildCount() > 0) {
                TextView tv = (TextView) layout.getChildAt(0);
                tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
            }
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }



    /**
     * This method is called when reset button is clicked.
     */

    public void resetGrade(View view) {
        finalScore = 0;

        nameInput.getText().clear();
        answer_1.getText().clear();
        answer_2_1.setChecked(false);
        answer_2_2.setChecked(false);
        answer_2_3.setChecked(false);
        answer_2_4.setChecked(false);
        answer_2_5.setChecked(false);
        answer_3.clearCheck();
        answer_4.clearCheck();
        answer_5.clearCheck();
        answer_6.clearCheck();

        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        scrollView.smoothScrollTo(0, 0);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("finalScore", finalScore);
        super.onSaveInstanceState(outState);

        outState.putBoolean("showFinalScore", showFinalScore);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        finalScore = savedInstanceState.getInt("finalScore", finalScore);
        showFinalScore = savedInstanceState.getBoolean("showFinalScore", showFinalScore);

        if (showFinalScore){
            finish(null);
        }

    }


}
