package edu.clarkson.ee408.numcompare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private int equalCase, number1, number2, number3, number4, number5, number6, ansCount = 0;
    private Button submit;
    private RadioGroup radioOperators1, radioOperators2, radioOperators3;
    private RadioButton radioChecked1, radioChecked2, radioChecked3;
    private RadioButton l1,l2,l3,r1,r2,r3,e1,e2,e3;
    private TextView numCorrect, num1, num2, num3, num4, num5, num6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        submit = (Button)findViewById(R.id.Submit);
        ansCount = 0;
        radioOperators1 = (RadioGroup)findViewById(R.id.radioGroup1);
        radioOperators2 = (RadioGroup)findViewById(R.id.radioGroup2);
        radioOperators3 = (RadioGroup)findViewById(R.id.radioGroup3);
        numCorrect = (TextView)findViewById(R.id.ans);
        num1 = (TextView)findViewById(R.id.Number1);
        num2 = (TextView)findViewById(R.id.Number2);
        num3 = (TextView)findViewById(R.id.Number3);
        num4 = (TextView)findViewById(R.id.Number4);
        num5 = (TextView)findViewById(R.id.Number5);
        num6 = (TextView)findViewById(R.id.Number6);

        Random rand = new Random();
        equalCase = rand.nextInt(8)+1;

        if (equalCase == 4)
        {
            number1 =  rand.nextInt(100)+1;
            number2 = number1;
            number3 = rand.nextInt(100)+1;
            number4 = rand.nextInt(100)+1;
            number5 = rand.nextInt(100)+1;
            number6 = rand.nextInt(100)+1;
        }
        if (equalCase == 5)
        {
            number1 = rand.nextInt(100)+1;
            number2 = rand.nextInt(100)+1;
            number3 = rand.nextInt(100)+1;
            number4 = number3;
            number5 = rand.nextInt(100)+1;
            number6 = rand.nextInt(100)+1;

        }
        if (equalCase == 6)
        {
            number1 = rand.nextInt(100)+1;
            number2 = rand.nextInt(100)+1;
            number3 = rand.nextInt(100)+1;
            number4 = rand.nextInt(100)+1;
            number5 = rand.nextInt(100)+1;
            number6 = number5;
        }
        else
        {
            number1 = rand.nextInt(100)+1;
            number2 = rand.nextInt(100)+1;
            number3 = rand.nextInt(100)+1;
            number4 = rand.nextInt(100)+1;
            number5 = rand.nextInt(100)+1;
            number6 = rand.nextInt(100)+1;
        }

        num1.setText(Integer.toString(number1));
        num2.setText(Integer.toString(number2));
        num3.setText(Integer.toString(number3));
        num4.setText(Integer.toString(number4));
        num5.setText(Integer.toString(number5));
        num6.setText(Integer.toString(number6));

        View.OnClickListener Submit = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int selectedId1 = radioOperators1.getCheckedRadioButtonId();
                int selectedId2 = radioOperators2.getCheckedRadioButtonId();
                int selectedId3 = radioOperators3.getCheckedRadioButtonId();
                radioChecked1 = (RadioButton) findViewById(selectedId1);
                radioChecked2 = (RadioButton) findViewById(selectedId2);
                radioChecked3 = (RadioButton) findViewById(selectedId3);

                numCorrect.setText("");
                try {
                    switch(radioChecked1.getText().toString())
                    {
                        case "=":
                            if (number1 == number2)
                            {
                                ansCount++;
                            }
                            break;

                        case ">":
                            if (number1 > number2)
                            {
                                ansCount++;
                            }
                            break;

                        case "<":
                            if (number1 < number2)
                            {
                                ansCount++;
                            }
                            break;
                        default:
                            numCorrect.setText("An operator needs to be selected.");
                            break;
                    }
                } catch (Exception e)
                {
                    numCorrect.setText("An operator needs to be selected.");
                }
                try {
                    switch(radioChecked2.getText().toString())
                    {
                        case "=":
                            if (number3 == number4)
                            {
                                ansCount++;
                            }
                            break;

                        case ">":
                            if (number3 > number4)
                            {
                                ansCount++;
                            }
                            break;

                        case "<":
                            if (number3 < number4)
                            {
                                ansCount++;
                            }
                            break;
                        default:
                            numCorrect.setText("An operator needs to be selected.");
                            break;
                    }
                } catch (Exception e)
                {
                    numCorrect.setText("An operator needs to be selected.");
                }
                try {
                    switch(radioChecked3.getText().toString())
                    {
                        case "=":
                            if (number5 == number6)
                            {
                                ansCount++;
                            }
                            break;

                        case ">":
                            if (number5 > number6)
                            {
                                ansCount++;
                            }
                            break;

                        case "<":
                            if (number5 < number6)
                            {
                                ansCount++;
                            }
                            break;
                        default:
                            numCorrect.setText("An operator needs to be selected.");
                            break;
                    }
                } catch (Exception e)
                {
                    numCorrect.setText("An operator needs to be selected.");
                }
                numCorrect.setText("You got " + Integer.toString(ansCount) + "/3 correct");
                ansCount = 0;
            }
        };
        submit.setOnClickListener(Submit);
    }

    /** Called when the user taps the Back button */
    public void BackHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
