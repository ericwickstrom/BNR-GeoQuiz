package com.ericwickstrom.bnr.geoquiz;

/**
 * Created by beardsmcgee on 5/17/16.
 */
public class Question {
    private int textResId;
    private boolean answerTrue;

    public Question(int textResId, boolean answerTrue){
        this.textResId = textResId;
        this.answerTrue = answerTrue;
    }

    public int getTextResId(){
        return textResId;
    }

    public void setTextResId(int textResId){
        this.textResId = textResId;
    }

    public boolean isAnswerTrue(){
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue){
        this.answerTrue = answerTrue;
    }
}
