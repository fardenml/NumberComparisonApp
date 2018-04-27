package edu.clarkson.ee408.numcompare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Learn button */
    public void learn(View view) {
        Intent intent = new Intent(this, LearnActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the Try button */
    public void tryIt(View view) {
        Intent intent = new Intent(this, TryActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the Quiz button */
    public void quiz(View view) {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }
}
