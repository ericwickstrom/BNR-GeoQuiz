package com.ericwickstrom.bnr.geoquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private Button previousButton;
    private TextView questionTextView;

    private Question[] questionBank = new Question[]{
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true)
    };

    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionTextView = (TextView) findViewById(R.id.question_text_view);
        updateQuestionTextView();

        trueButton = (Button) findViewById(R.id.true_button);
        trueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(questionBank[currentIndex].isAnswerTrue()){
                    Toast.makeText(QuizActivity.this,
                            R.string.correct_toast,
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(QuizActivity.this,
                            R.string.incorrect_toast,
                            Toast.LENGTH_LONG).show();
                }
                nextQuestion();
            }

        });

        falseButton = (Button) findViewById(R.id.false_button);
        falseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!questionBank[currentIndex].isAnswerTrue()){
                    Toast.makeText(QuizActivity.this,
                            R.string.correct_toast,
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(QuizActivity.this,
                            R.string.incorrect_toast,
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nextQuestion();
            }
        });

        previousButton = (Button) findViewById(R.id.previous_button);
        previousButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                previousQuestion();
            }
        });

    }

    private void previousQuestion(){
        if(currentIndex == 0){
            currentIndex = questionBank.length-1;
        } else {
            currentIndex--;
        }
        updateQuestionTextView();
    }

    private void nextQuestion(){
        if(currentIndex == questionBank.length-1){
            currentIndex = 0;
        } else {
            currentIndex++;
        }
        updateQuestionTextView();
    }

    private void updateQuestionTextView(){
        int question = questionBank[currentIndex].getTextResId();
        questionTextView.setText(question);
    }
}
