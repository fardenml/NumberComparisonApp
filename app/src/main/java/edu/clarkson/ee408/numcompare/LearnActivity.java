package edu.clarkson.ee408.numcompare;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class LearnActivity extends AppCompatActivity {

    private TextView explanation, answer, lDig1, lDig2, lDig3, rDig1, rDig2, rDig3,line;
    private EditText num1, num2;
    private Button enter, next, prev;
    private RadioGroup radioOperators;
    private RadioButton radioChecked;
    private ImageView blue_1, blue_2, blue_3, blue_4, blue_5, blue_6, blue_7, blue_8, blue_9;
    private ImageView green_1, green_2, green_3, green_4, green_5, green_6, green_7, green_8, green_9;
    private ImageView lArrow1, lArrow2, lArrow3, rArrow1, rArrow2, rArrow3;

    boolean error = false;

    int number1, number2, oNumber1, oNumber2;
    int leftDigit1, leftDigit2, leftDigit3;
    int rightDigit1, rightDigit2, rightDigit3;
    int state = -1;
    int maxLength = 3;
    int done = -1;

    String cMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        enter = (Button)findViewById(R.id.Enter);
        next = (Button)findViewById(R.id.Next_Step);
        prev = (Button)findViewById(R.id.Prev_Step);

        explanation = (TextView)findViewById(R.id.Answer);
        answer = (TextView)findViewById(R.id.Answer);

        lDig1 = (TextView)findViewById(R.id.Left_Digit_1);
        lDig2 = (TextView)findViewById(R.id.Left_Digit_2);
        lDig3 = (TextView)findViewById(R.id.Left_Digit_3);

        rDig1 = (TextView)findViewById(R.id.Right_Digit_1);
        rDig2 = (TextView)findViewById(R.id.Right_Digit_2);
        rDig3 = (TextView)findViewById(R.id.Right_Digit_3);

        line = (TextView)findViewById(R.id.Line);


        num1 = (EditText)findViewById(R.id.Number1);
        num2 = (EditText)findViewById(R.id.Number2);

        blue_1 = (ImageView)findViewById(R.id.blue_1);
        blue_2 = (ImageView)findViewById(R.id.blue_2);
        blue_3 = (ImageView)findViewById(R.id.blue_3);
        blue_4 = (ImageView)findViewById(R.id.blue_4);
        blue_5 = (ImageView)findViewById(R.id.blue_5);
        blue_6 = (ImageView)findViewById(R.id.blue_6);
        blue_7 = (ImageView)findViewById(R.id.blue_7);
        blue_8 = (ImageView)findViewById(R.id.blue_8);
        blue_9 = (ImageView)findViewById(R.id.blue_9);

        green_1 = (ImageView)findViewById(R.id.green_1);
        green_2 = (ImageView)findViewById(R.id.green_2);
        green_3 = (ImageView)findViewById(R.id.green_3);
        green_4 = (ImageView)findViewById(R.id.green_4);
        green_5 = (ImageView)findViewById(R.id.green_5);
        green_6 = (ImageView)findViewById(R.id.green_6);
        green_7 = (ImageView)findViewById(R.id.green_7);
        green_8 = (ImageView)findViewById(R.id.green_8);
        green_9 = (ImageView)findViewById(R.id.green_9);

        lArrow1 = (ImageView)findViewById(R.id.Left_Arrow_1);
        lArrow2 = (ImageView)findViewById(R.id.Left_Arrow_2);
        lArrow3 = (ImageView)findViewById(R.id.Left_Arrow_3);

        rArrow1 = (ImageView)findViewById(R.id.Right_Arrow_1);
        rArrow2 = (ImageView)findViewById(R.id.Right_Arrow_2);
        rArrow3 = (ImageView)findViewById(R.id.Right_Arrow_3);

        radioOperators = (RadioGroup)findViewById(R.id.radioGroup);

        prev.setClickable(false);
        prev.setVisibility(View.INVISIBLE);
        next.setClickable(false);
        next.setVisibility(View.INVISIBLE);

        num1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength) {
        }});
        num2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength) {
        }});


        View.OnClickListener Submit = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                error = false;
                state = 0;
                done = -1;// -1=not done, 1= finished on first digit, 2= finished on second digit, 3= finished on third digit
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);


                int selectedId = radioOperators.getCheckedRadioButtonId();
                radioChecked = (RadioButton) findViewById(selectedId);

                try {
                    switch (radioChecked.getText().toString()) {
                        case "=":
                            if (Integer.parseInt(num1.getText().toString()) == Integer.parseInt(num2.getText().toString())) {
                                cMessage = "The expression is correct!";
                            } else
                                cMessage = "The expression is incorrect!";

                            break;

                        case ">":
                            if (Integer.parseInt(num1.getText().toString()) > Integer.parseInt(num2.getText().toString())) {
                                cMessage = "The expression is correct!";
                            } else
                                cMessage = "The expression is incorrect!";
                            break;

                        case "<":
                            if (Integer.parseInt(num1.getText().toString()) < Integer.parseInt(num2.getText().toString())) {
                                cMessage = "The expression is correct!";
                            } else
                                cMessage = "The expression is incorrect!";
                            break;
                        default:
                            answer.setText("A operator needs to be selected.");
                            error = true;
                            break;
                    }
                }catch(Exception e) {
                    answer.setText("An operator needs to be selected! Try Again.");
                    error = true;
                }
                try {
                    if (Integer.parseInt(num1.getText().toString()) < 0 || Integer.parseInt(num1.getText().toString()) > 999 || Integer.parseInt(num2.getText().toString()) < 0 || Integer.parseInt(num2.getText().toString()) > 999) {
                        answer.setText("The numbers must be between 0 and 999! Try again.");
                        error = true;
                    }
                }catch(Exception e){
                    answer.setText("Please enter numbers in both green squares!");
                }

                if (!error) {
                    oNumber1 = Integer.parseInt(num1.getText().toString());
                    oNumber2 = Integer.parseInt(num2.getText().toString());
                    number1 = Integer.parseInt(num1.getText().toString());
                    number2 = Integer.parseInt(num2.getText().toString());

                    leftDigit1 = number1 / 100;
                    number1 = number1 - (leftDigit1 * 100);
                    leftDigit2 = number1 / 10;
                    number1 = number1 - (leftDigit2 * 10);
                    leftDigit3 = number1;

                    rightDigit1 = number2 / 100;
                    number2 = number2 - (rightDigit1 * 100);
                    rightDigit2 = number2 / 10;
                    number2 = number2 - (rightDigit2 * 10);
                    rightDigit3 = number2;

                    lDig1.setVisibility(View.VISIBLE);
                    lDig2.setVisibility(View.VISIBLE);
                    lDig3.setVisibility(View.VISIBLE);

                    rDig1.setVisibility(View.VISIBLE);
                    rDig2.setVisibility(View.VISIBLE);
                    rDig3.setVisibility(View.VISIBLE);

                    line.setVisibility(View.VISIBLE);


                    lDig1.setText(String.valueOf(leftDigit1));
                    lDig2.setText(String.valueOf(leftDigit2));
                    lDig3.setText(String.valueOf(leftDigit3));

                    rDig1.setText(String.valueOf(rightDigit1));
                    rDig2.setText(String.valueOf(rightDigit2));
                    rDig3.setText(String.valueOf(rightDigit3));

                    compareDigits();
                }
            }
        };

        View.OnClickListener Next = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Button b = (Button)v;
                if (done == 1){
                    if (state == 1)
                        state = 4;
                    else
                        state = 1;
                    compareDigits();
                } else if (done == 2){
                    if (state < 2)
                        state++;
                    else
                        state = 4;
                    compareDigits();
                }else if (state >= 0){
                    if (state < 4){
                        state++;
                        compareDigits();
                    }
                } else{
                    answer.setText("Please press ENTER first.");
                }
            }
        };

        View.OnClickListener Prev = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Button b = (Button)v;
                if (done == 1){
                    if (state == 1)
                        state = 0;
                    else
                        state = 1;
                    compareDigits();
                } else if(done == 2){
                    if (state <= 2)
                        state--;
                    else
                        state = 2;
                    compareDigits();
                }else if (state > 0){
                    state--;
                    compareDigits();
                } else{
                    answer.setText("Please press ENTER first.");
                }
            }
        };

        enter.setOnClickListener(Submit);
        next.setOnClickListener(Next);
        prev.setOnClickListener(Prev);
    }

    void compareDigits(){
        if (state == 0){
            prev.setClickable(false);
            prev.setVisibility(View.INVISIBLE);
            next.setClickable(true);
            next.setVisibility(View.VISIBLE);

            lArrow1.setVisibility(View.INVISIBLE);
            lArrow2.setVisibility(View.INVISIBLE);
            lArrow3.setVisibility(View.INVISIBLE);
            rArrow1.setVisibility(View.INVISIBLE);
            rArrow2.setVisibility(View.INVISIBLE);
            rArrow3.setVisibility(View.INVISIBLE);

            hideBoxes();

            answer.setText(cMessage + "\nTo determine this, we will be comparing each digit of the numbers against each other.\nPress NEXT STEP to start!");

        }
        else if (state == 1){// compares first digit
            prev.setClickable(true);
            prev.setVisibility(View.VISIBLE);
            next.setClickable(true);
            next.setVisibility(View.VISIBLE);

            lArrow1.setVisibility(View.VISIBLE);
            lArrow2.setVisibility(View.INVISIBLE);
            lArrow3.setVisibility(View.INVISIBLE);
            rArrow1.setVisibility(View.VISIBLE);
            rArrow2.setVisibility(View.INVISIBLE);
            rArrow3.setVisibility(View.INVISIBLE);

            showBoxes(leftDigit1, rightDigit1);

            if (leftDigit1 == rightDigit1) {
                answer.setText(String.valueOf(leftDigit1) + " blocks is equal to " + String.valueOf(rightDigit1) + " blocks.\nBecause the number of blocks are the same, we will need to compare the next digits.\nPress NEXT STEP to continue!");
            } else if (leftDigit1 < rightDigit1) {
                answer.setText(String.valueOf(leftDigit1) + " blocks is less than " + String.valueOf(rightDigit1) + " blocks.\nThis is because there are more green blocks than blue blocks.\nPress NEXT STEP to find out what this means!");
                done = 1;
            } else {
                answer.setText(String.valueOf(leftDigit1) + " blocks is greater than " + String.valueOf(rightDigit1) + " blocks.\nThis is because there are more blue blocks than green blocks.\nPress NEXT STEP to find out what this means!");
                done = 1;
            }
        }
        else if (state == 2){// compares second digit
            prev.setClickable(true);
            prev.setVisibility(View.VISIBLE);
            next.setClickable(true);
            next.setVisibility(View.VISIBLE);

            lArrow1.setVisibility(View.INVISIBLE);
            lArrow2.setVisibility(View.VISIBLE);
            lArrow3.setVisibility(View.INVISIBLE);
            rArrow1.setVisibility(View.INVISIBLE);
            rArrow2.setVisibility(View.VISIBLE);
            rArrow3.setVisibility(View.INVISIBLE);

            showBoxes(leftDigit2, rightDigit2);

            if (leftDigit2 == rightDigit2) {
                answer.setText(String.valueOf(leftDigit2) + " blocks is equal to " + String.valueOf(rightDigit2) + " blocks.\nBecause the number of blocks are the same, we will need to compare the next digits.\nPress NEXT STEP to continue!");
            } else if (leftDigit2 < rightDigit2) {
                answer.setText(String.valueOf(leftDigit2) + " blocks is less than " + String.valueOf(rightDigit2) + " blocks.\nThis is because there are more green blocks than blue blocks.\nPress NEXT STEP to find out what this means!");
                done = 2;
            } else {
                answer.setText(String.valueOf(leftDigit2) + " blocks is greater than " + String.valueOf(rightDigit2) + " blocks.\nThis is because there are more blue blocks than green blocks.\nPress NEXT STEP to find out what this means!");
                done = 2;
            }
        } else if (state == 3){// compares third digit
            prev.setClickable(true);
            prev.setVisibility(View.VISIBLE);
            next.setClickable(true);
            next.setVisibility(View.VISIBLE);

            lArrow1.setVisibility(View.INVISIBLE);
            lArrow2.setVisibility(View.INVISIBLE);
            lArrow3.setVisibility(View.VISIBLE);
            rArrow1.setVisibility(View.INVISIBLE);
            rArrow2.setVisibility(View.INVISIBLE);
            rArrow3.setVisibility(View.VISIBLE);

            showBoxes(leftDigit3, rightDigit3);

            if (leftDigit3 == rightDigit3) {
                answer.setText(String.valueOf(leftDigit3) + " blocks is equal to " + String.valueOf(rightDigit3) + " blocks.\nThis is because the number of blocks are the same.\nPress NEXT STEP to find out what this means!");
            } else if (leftDigit3 < rightDigit3) {
                answer.setText(String.valueOf(leftDigit3) + " blocks is less than " + String.valueOf(rightDigit3) + " blocks.\nThis is because there are more green blocks than blue blocks.\nPress NEXT STEP to find out what this means!");
                done = 3;
            } else {
                answer.setText(String.valueOf(leftDigit3) + " blocks is greater than " + String.valueOf(rightDigit3) + " blocks.\nThis is because there are more blue blocks than green blocks.\nPress NEXT STEP to find out what this means!");
                done = 3;
            }
        } else if (state == 4){// final screen
            prev.setClickable(true);
            next.setClickable(false);
            next.setVisibility(View.INVISIBLE);

            lArrow1.setVisibility(View.INVISIBLE);
            lArrow2.setVisibility(View.INVISIBLE);
            lArrow3.setVisibility(View.INVISIBLE);
            rArrow1.setVisibility(View.INVISIBLE);
            rArrow2.setVisibility(View.INVISIBLE);
            rArrow3.setVisibility(View.INVISIBLE);

            hideBoxes();

            if (oNumber1 == oNumber2) {
                answer.setText("Since all of the digits for both numbers had the same number of blue and green blocks, the numbers are equal to each other.\n" + oNumber1 + " is equal to " + oNumber2 + "!\nNow head back to the main menu to test yourself!");
            } else if (oNumber1 < oNumber2) {
                answer.setText("Since there were more green blocks than blue blocks, the number on the right is greater than the number on the left.\n" + oNumber1 + " is less than " + oNumber2 + "!\nNow head back to the main menu to test yourself!");
            } else {
                answer.setText("Since there were more blue blocks than green blocks, the number on the left is greater than the number on the right.\n" + oNumber1 + " is greater than " + oNumber2 + "!\nNow head back to the main menu to test yourself!");
            }
        }
        else
            state = 0;
    }

    void showBoxes(int lDigit, int rDigit){
        hideBoxes();
        if (lDigit >= 1)
            blue_1.setVisibility(View.VISIBLE);
        if (lDigit >= 2)
            blue_2.setVisibility(View.VISIBLE);
        if (lDigit >= 3)
            blue_3.setVisibility(View.VISIBLE);
        if (lDigit >= 4)
            blue_4.setVisibility(View.VISIBLE);
        if (lDigit >= 5)
            blue_5.setVisibility(View.VISIBLE);
        if (lDigit >= 6)
            blue_6.setVisibility(View.VISIBLE);
        if (lDigit >= 7)
            blue_7.setVisibility(View.VISIBLE);
        if (lDigit >= 8)
            blue_8.setVisibility(View.VISIBLE);
        if (lDigit >= 9)
            blue_9.setVisibility(View.VISIBLE);

        if (rDigit >= 1)
            green_1.setVisibility(View.VISIBLE);
        if (rDigit >= 2)
            green_2.setVisibility(View.VISIBLE);
        if (rDigit >= 3)
            green_3.setVisibility(View.VISIBLE);
        if (rDigit >= 4)
            green_4.setVisibility(View.VISIBLE);
        if (rDigit >= 5)
            green_5.setVisibility(View.VISIBLE);
        if (rDigit >= 6)
            green_6.setVisibility(View.VISIBLE);
        if (rDigit >= 7)
            green_7.setVisibility(View.VISIBLE);
        if (rDigit >= 8)
            green_8.setVisibility(View.VISIBLE);
        if (rDigit >= 9)
            green_9.setVisibility(View.VISIBLE);
    }

    void hideBoxes(){
        blue_1.setVisibility(View.INVISIBLE);
        blue_2.setVisibility(View.INVISIBLE);
        blue_3.setVisibility(View.INVISIBLE);
        blue_4.setVisibility(View.INVISIBLE);
        blue_5.setVisibility(View.INVISIBLE);
        blue_6.setVisibility(View.INVISIBLE);
        blue_7.setVisibility(View.INVISIBLE);
        blue_8.setVisibility(View.INVISIBLE);
        blue_9.setVisibility(View.INVISIBLE);

        green_1.setVisibility(View.INVISIBLE);
        green_2.setVisibility(View.INVISIBLE);
        green_3.setVisibility(View.INVISIBLE);
        green_4.setVisibility(View.INVISIBLE);
        green_5.setVisibility(View.INVISIBLE);
        green_6.setVisibility(View.INVISIBLE);
        green_7.setVisibility(View.INVISIBLE);
        green_8.setVisibility(View.INVISIBLE);
        green_9.setVisibility(View.INVISIBLE);
    }
}
