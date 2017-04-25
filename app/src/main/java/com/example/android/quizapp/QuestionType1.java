package com.example.android.quizapp;

/**
 * Created by Shinam on 09/04/2017.
 */

public class QuestionType1 extends Question {
    private String mR1;
    private String mR2;
    private String mR3;
    private String mR4;
    private int mCorrect;
    private int mAns;

    public QuestionType1(String Img, String Quest, String R1, String R2, String R3, String R4, int Correct) {
        this.mImg = Img;
        this.mQuestion = Quest;
        mR1 = R1;
        mR2 = R2;
        mR3 = R3;
        mR4 = R4;
        mCorrect = Correct;
        mAns = 0;
    }

    public String getImg() {
        return mImg;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public String getR1() {
        return mR1;
    }

    public String getR2() {
        return mR2;
    }

    public String getR3() {
        return mR3;
    }

    public String getR4() {
        return mR4;
    }

    public void setAns(int ans) {
        mAns = ans;
    }

    public int getAns() {
        return mAns;
    }

    public int getCorrect() {
        return mCorrect;
    }

}
