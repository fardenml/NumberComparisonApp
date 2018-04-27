package edu.clarkson.ee408.numcompare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.Random;

public class TryActivity extends AppCompatActivity {
    private TextView answer, num1, num2;
    private Button enter;
    private RadioGroup radioOperators;
    private RadioButton radioChecked;
    private int count, number1, number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try);

        enter = (Button)findViewById(R.id.Enter);

        answer = (TextView)findViewById(R.id.Answer);
        num1 = (TextView)findViewById(R.id.Number1);
        num2 = (TextView)findViewById(R.id.Number2);

        radioOperators = (RadioGroup)findViewById(R.id.radioGroup);

        Random rand = new Random();
        count = rand.nextInt(3)+1;

        if (count == 1)
        {
            number1 =  rand.nextInt(100)+1;
            number2 = number1;
        } else if (count == 2){
            number1 = rand.nextInt((100 - 50) + 1) + 50;
            number2 = rand.nextInt((50 - 1) + 1) + 1;
        } else{
            number1 = rand.nextInt((50 - 1) + 1) + 1;
            number2 = rand.nextInt((100 - 50) + 1) + 50;
        }

        num1.setText(String.valueOf(number1));
        num2.setText(String.valueOf(number2));

        View.OnClickListener Submit = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int selectedId = radioOperators.getCheckedRadioButtonId();
                radioChecked = (RadioButton) findViewById(selectedId);

                try {
                    switch(radioChecked.getText().toString())
                    {
                        case "=":
                            if (number1 == number2)
                            {
                                answer.setText("The expression is correct!");
                            }
                            else
                            {
                                answer.setText("The expression is incorrect!");
                            }
                            break;

                        case ">":
                            if (number1 > number2)
                            {
                                answer.setText("The expression is correct!");
                            }
                            else
                            {
                                answer.setText("The expression is incorrect!");
                            }
                            break;

                        case "<":
                            if (number1 < number2)
                            {
                                answer.setText("The expression is correct!");
                            }
                            else
                            {
                                answer.setText("The expression is incorrect!");
                            }
                            break;
                        default:
                            answer.setText("An operator needs to be selected.");
                            break;
                    }
                } catch (Exception e)
                {
                    answer.setText("An operator needs to be selected.");
                }
            }
        };
        enter.setOnClickListener(Submit);
    }

    /** Called when the user taps the New button */
    public void NewNumbers(View view) {
        Intent intent = new Intent(this, TryActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the Back button */
    public void BackHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}