package com.example.android.quizapp;

/**
 * Created by Shinam on 10/04/2017.
 */

public class QuestionType3 extends Question {
    private String mCorrect;
    private String mAns;

    public QuestionType3(String Img, String Quest, String R){
        this.mImg = Img;
        this.mQuestion = Quest;
        mCorrect = R;
        mAns = null;
    }

    public String getImg() { return mImg; }
    public String getQuestion() { return mQuestion; }
    public String getCorrect() { return mCorrect; }
    public void setAns(String ans) { mAns = ans; }
    public String getAns() { return mAns; }
}
