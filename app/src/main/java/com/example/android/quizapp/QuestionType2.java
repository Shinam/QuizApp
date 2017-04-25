package com.example.android.quizapp;

/**
 * Created by Shinam on 10/04/2017.
 */

public class QuestionType2 extends Question {
    private String mR1;
    private String mR2;
    private String mR3;
    private String mR4;
    private boolean mCorrect1;
    private boolean mCorrect2;
    private boolean mCorrect3;
    private boolean mCorrect4;
    private boolean mAns1;
    private boolean mAns2;
    private boolean mAns3;
    private boolean mAns4;


    public QuestionType2(String Img, String Quest, String R1, String R2, String R3, String R4, boolean Correct1, boolean Correct2, boolean Correct3, boolean Correct4) {
        this.mImg = Img;
        this.mQuestion = Quest;
        mR1 = R1;
        mR2 = R2;
        mR3 = R3;
        mR4 = R4;
        mCorrect1 = Correct1;
        mCorrect2 = Correct2;
        mCorrect3 = Correct3;
        mCorrect4 = Correct4;
        mAns1 = false;
        mAns2 = false;
        mAns3 = false;
        mAns4 = false;

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

    public void setAns1(boolean ans) {
        mAns1 = ans;
    }

    public void setAns2(boolean ans) {
        mAns2 = ans;
    }

    public void setAns3(boolean ans) {
        mAns3 = ans;
    }

    public void setAns4(boolean ans) {
        mAns4 = ans;
    }

    public boolean getAns1() {
        return mAns1;
    }

    public boolean getAns2() {
        return mAns2;
    }

    public boolean getAns3() {
        return mAns3;
    }

    public boolean getAns4() {
        return mAns4;
    }

    public boolean getCorrect1() {
        return mCorrect1;
    }

    public boolean getCorrect2() {
        return mCorrect2;
    }

    public boolean getCorrect3() {
        return mCorrect3;
    }

    public boolean getCorrect4() {
        return mCorrect4;
    }
}
