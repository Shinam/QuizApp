package com.example.android.quizapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.android.quizapp.R.id.flag;
import static com.example.android.quizapp.R.id.prevBut;
import static com.example.android.quizapp.R.id.progressBar;

public class Quiz extends AppCompatActivity {

    final ArrayList<Question> questions = new ArrayList<>();
    private ImageView Imag;
    private Question currentQuestion;
    private RelativeLayout Title;
    private ListView myList;
    private LinearLayout Lay;
    private TextView myQuest;
    private QuestionType1 Q1;
    private QuestionType2 Q2;
    private QuestionType3 Q3;
    private RadioGroup rg1;
    private RadioGroup rg2;
    int cpt = 0;
    private ProgressBar progBar;
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private RadioGroup.OnCheckedChangeListener listener1 = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                rg2.setOnCheckedChangeListener(null);
                rg2.clearCheck();
                rg2.setOnCheckedChangeListener(listener2);
            }
        }
    };
    private RadioGroup.OnCheckedChangeListener listener2 = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                rg1.setOnCheckedChangeListener(null);
                rg1.clearCheck();
                rg1.setOnCheckedChangeListener(listener1);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView previousButton = (TextView) findViewById(R.id.prevBut);
        previousButton.setVisibility(View.GONE);
        View Sep = findViewById(R.id.sep);
        Sep.setVisibility(View.GONE);
        progBar = (ProgressBar) findViewById(progressBar);
        progBar.setProgress(1);

        questions.add(new QuestionType1(getString(R.string.i1), getString(R.string.q1), getString(R.string.r11),
                getString(R.string.r12), getString(R.string.r13), getString(R.string.r14), 1));
        questions.add(new QuestionType2(getString(R.string.i2), getString(R.string.q2), getString(R.string.r21),
                getString(R.string.r22), getString(R.string.r23), getString(R.string.r24), false, true, false, true));
        questions.add(new QuestionType3(getString((R.string.i3)), getString(R.string.q3), getString(R.string.r3)));
        questions.add(new QuestionType1(getString(R.string.i4), getString(R.string.q4), getString(R.string.r41),
                getString(R.string.r42), getString(R.string.r43), getString(R.string.r44), 2));

        ShowQuestion();
        rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
        rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
        rg1.setOnCheckedChangeListener(listener1);
        rg2.setOnCheckedChangeListener(listener2);
    }

    // Show the next question
    public void ShowQuestion() {
        TextView questNmb = (TextView) findViewById(R.id.questionCnt);
        questNmb.setText("Question " + (cpt + 1) + "/4");
        currentQuestion = questions.get(cpt);
        String tmp;
        if (currentQuestion instanceof QuestionType1) {
            Title = (RelativeLayout) findViewById(R.id.appBar);
            Title.setBackgroundResource(R.color.Top);
            Lay = (LinearLayout) findViewById(R.id.actionLayout);
            Lay.setBackgroundResource(R.color.Top);
            Q1 = (QuestionType1) currentQuestion;
            tmp = Q1.getQuestion();
            myQuest = (TextView) findViewById(R.id.questName);
            myQuest.setText(tmp);
            tmp = Q1.getR1();
            myQuest = (TextView) findViewById(R.id.radioButton1);
            myQuest.setText(tmp);
            tmp = Q1.getR2();
            myQuest = (TextView) findViewById(R.id.radioButton2);
            myQuest.setText(tmp);
            tmp = Q1.getR3();
            myQuest = (TextView) findViewById(R.id.radioButton3);
            myQuest.setText(tmp);
            tmp = Q1.getR4();
            myQuest = (TextView) findViewById(R.id.radioButton4);
            myQuest.setText(tmp);
            Lay = (LinearLayout) findViewById(R.id.LinearRadio);
            Lay.setVisibility(View.VISIBLE);
            Lay = (LinearLayout) findViewById(R.id.LinearBox1);
            Lay.setVisibility(View.GONE);
            Lay = (LinearLayout) findViewById(R.id.LinearBox2);
            Lay.setVisibility(View.GONE);
            Lay = (LinearLayout) findViewById(R.id.LinearEdit);
            Lay.setVisibility(View.GONE);
            Imag = (ImageView) findViewById(flag);
            Resources res = getResources();
            String mDrawableName = Q1.getImg();
            int resID = res.getIdentifier(mDrawableName, "drawable", getPackageName());
            Drawable drawable = res.getDrawable(resID);
            Imag.setImageDrawable(drawable);
        } else if (currentQuestion instanceof QuestionType2) {
            Title = (RelativeLayout) findViewById(R.id.appBar);
            Title.setBackgroundResource(R.color.Multi);
            Lay = (LinearLayout) findViewById(R.id.actionLayout);
            Lay.setBackgroundResource(R.color.Multi);
            Q2 = (QuestionType2) currentQuestion;
            tmp = Q2.getQuestion();
            myQuest = (TextView) findViewById(R.id.questName);
            myQuest.setText(tmp);
            tmp = Q2.getR1();
            myQuest = (TextView) findViewById(R.id.checkbox1);
            myQuest.setText(tmp);
            tmp = Q2.getR2();
            myQuest = (TextView) findViewById(R.id.checkbox2);
            myQuest.setText(tmp);
            tmp = Q2.getR3();
            myQuest = (TextView) findViewById(R.id.checkbox3);
            myQuest.setText(tmp);
            tmp = Q2.getR4();
            myQuest = (TextView) findViewById(R.id.checkbox4);
            myQuest.setText(tmp);
            Lay = (LinearLayout) findViewById(R.id.LinearRadio);
            Lay.setVisibility(View.GONE);
            Lay = (LinearLayout) findViewById(R.id.LinearBox1);
            Lay.setVisibility(View.VISIBLE);
            Lay = (LinearLayout) findViewById(R.id.LinearBox2);
            Lay.setVisibility(View.VISIBLE);
            Lay = (LinearLayout) findViewById(R.id.LinearEdit);
            Lay.setVisibility(View.GONE);
            Imag = (ImageView) findViewById(flag);
            Resources res = getResources();
            String mDrawableName = Q2.getImg();
            int resID = res.getIdentifier(mDrawableName, "drawable", getPackageName());
            Drawable drawable = res.getDrawable(resID);
            Imag.setImageDrawable(drawable);
        } else if (currentQuestion instanceof QuestionType3) {
            Title = (RelativeLayout) findViewById(R.id.appBar);
            Title.setBackgroundResource(R.color.Open);
            Lay = (LinearLayout) findViewById(R.id.actionLayout);
            Lay.setBackgroundResource(R.color.Open);
            Q3 = (QuestionType3) currentQuestion;
            tmp = Q3.getQuestion();
            myQuest = (TextView) findViewById(R.id.questName);
            myQuest.setText(tmp);
            Lay = (LinearLayout) findViewById(R.id.LinearEdit);
            Lay.setVisibility(View.VISIBLE);
            Lay = (LinearLayout) findViewById(R.id.LinearRadio);
            Lay.setVisibility(View.GONE);
            Lay = (LinearLayout) findViewById(R.id.LinearBox1);
            Lay.setVisibility(View.GONE);
            Lay = (LinearLayout) findViewById(R.id.LinearBox2);
            Lay.setVisibility(View.GONE);
            Imag = (ImageView) findViewById(flag);
            Resources res = getResources();
            String mDrawableName = Q3.getImg();
            int resID = res.getIdentifier(mDrawableName, "drawable", getPackageName());
            Drawable drawable = res.getDrawable(resID);
            Imag.setImageDrawable(drawable);
        } else {
            Toast.makeText(Quiz.this, "Error", Toast.LENGTH_SHORT).show();
        }
        if (cpt >= 0 && cpt <= 3) {
            TextView But = (TextView) findViewById(R.id.nextBut);
            But.setVisibility(View.VISIBLE);
        }
        if (cpt > 0 && cpt <= 3) {
            View Sep = findViewById(R.id.sep);
            Sep.setVisibility(View.VISIBLE);
        }
        if (cpt == 3) {
            myQuest = (TextView) findViewById(R.id.nextBut);
            myQuest.setText("Finish");
        } else {
            myQuest = (TextView) findViewById(R.id.nextBut);
            myQuest.setText("Next");
        }
    }

    // Next Question and take the answer to the Array
    public void next(View view) {
        if (cpt == 4) {
            Result();
        } else {
            if (currentQuestion instanceof QuestionType1) {
                if (getInt() != -1)
                    ((QuestionType1) currentQuestion).setAns(getInt());
            } else if (currentQuestion instanceof QuestionType2) {
                CheckBox chck = (CheckBox) findViewById(R.id.checkbox1);
                if (chck.isChecked()) {
                    ((QuestionType2) currentQuestion).setAns1(true);
                } else
                    ((QuestionType2) currentQuestion).setAns1(false);
                chck = (CheckBox) findViewById(R.id.checkbox2);
                if (chck.isChecked()) {
                    ((QuestionType2) currentQuestion).setAns2(true);
                } else
                    ((QuestionType2) currentQuestion).setAns2(false);
                chck = (CheckBox) findViewById(R.id.checkbox3);
                if (chck.isChecked()) {
                    ((QuestionType2) currentQuestion).setAns3(true);
                } else
                    ((QuestionType2) currentQuestion).setAns3(false);
                chck = (CheckBox) findViewById(R.id.checkbox4);
                if (chck.isChecked()) {
                    ((QuestionType2) currentQuestion).setAns4(true);
                } else
                    ((QuestionType2) currentQuestion).setAns4(false);
            } else if (currentQuestion instanceof QuestionType3) {
                TextView EditAns = (TextView) findViewById(R.id.EditAnswer);
                if (EditAns.getText() != null) {
                    ((QuestionType3) currentQuestion).setAns(EditAns.getText().toString());
                }
            } else {
                Toast.makeText(Quiz.this, "Error Answer", Toast.LENGTH_SHORT).show();
            }
            if (cpt == 0) {
                TextView previousButton = (TextView) findViewById(R.id.prevBut);
                previousButton.setVisibility(View.VISIBLE);
                View Sep = findViewById(R.id.sep);
                Sep.setVisibility(View.VISIBLE);
            }
            if (cpt == 3) {
                cpt++;
                Summary();
            } else {
                cpt++;
                progBar.setProgress(cpt + 1);
                rg1.clearCheck();
                rg2.clearCheck();
                ShowQuestion();
            }
            if (cpt == 0) {
                TextView previousButton = (TextView) findViewById(R.id.prevBut);
                previousButton.setVisibility(View.GONE);
                View Sep = findViewById(R.id.sep);
                Sep.setVisibility(View.GONE);
            }
        }
    }

    // Previous Question
    public void previous(View view) {
        if (cpt == 1) {
            TextView previousButton = (TextView) findViewById(R.id.prevBut);
            previousButton.setVisibility(View.GONE);
            View Sep = findViewById(R.id.sep);
            Sep.setVisibility(View.GONE);
        }
        if (cpt == 4) {
            myList = (ListView) findViewById(R.id.question_list);
            myList.setVisibility(View.GONE);
            Lay = (LinearLayout) findViewById(R.id.activity_question1);
            Lay.setVisibility(View.VISIBLE);
        }
        cpt--;
        progBar.setProgress(cpt + 1);
        rg1.clearCheck();
        rg2.clearCheck();
        ShowQuestion();
    }

    // Get the answer checked
    public int getInt() {
        int butid = -1;
        int chkId1 = rg1.getCheckedRadioButtonId();
        int chkId2 = rg2.getCheckedRadioButtonId();
        int realCheck = chkId1 == -1 ? chkId2 : chkId1;
        switch (realCheck) {
            case R.id.radioButton1:
                butid = 1;
                break;
            case R.id.radioButton2:
                butid = 2;
                break;
            case R.id.radioButton3:
                butid = 3;
                break;
            case R.id.radioButton4:
                butid = 4;
                break;
        }
        return butid;
    }

    // Show All questions, can click on it
    public void Summary() {
        myQuest = (TextView) findViewById(R.id.nextBut);
        myQuest.setText("Result");
        Title = (RelativeLayout) findViewById(R.id.appBar);
        Title.setBackgroundResource(R.color.summ);
        Lay = (LinearLayout) findViewById(R.id.actionLayout);
        Lay.setBackgroundResource(R.color.summ);
        ArrayList<String> questionName = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            currentQuestion = questions.get(i);
            if (currentQuestion instanceof QuestionType1)
                questionName.add(((QuestionType1) currentQuestion).getQuestion());
            else if (currentQuestion instanceof QuestionType2)
                questionName.add(((QuestionType2) currentQuestion).getQuestion());
            else if (currentQuestion instanceof QuestionType3)
                questionName.add(((QuestionType3) currentQuestion).getQuestion());
            else
                Toast.makeText(Quiz.this, "Error Summary", Toast.LENGTH_SHORT).show();
        }
        myList = (ListView) findViewById(R.id.question_list);
        myList.setVisibility(View.VISIBLE);
        Lay = (LinearLayout) findViewById(R.id.activity_question1);
        Lay.setVisibility(View.GONE);
        myList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, questionName) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View row = super.getView(position, convertView, parent);
                currentQuestion = questions.get(position);
                if (currentQuestion instanceof QuestionType1)
                    if (((QuestionType1) currentQuestion).getAns() == 0)
                        row.setBackgroundColor(Color.RED);
                    else
                        row.setBackgroundResource(R.color.Top);
                else if (currentQuestion instanceof QuestionType2) {
                    if (((QuestionType2) currentQuestion).getAns1() == false
                            && ((QuestionType2) currentQuestion).getAns2() == false
                            && ((QuestionType2) currentQuestion).getAns3() == false
                            && ((QuestionType2) currentQuestion).getAns4() == false) {
                        row.setBackgroundColor(Color.RED);
                    } else {
                        row.setBackgroundResource(R.color.Top);
                    }
                } else if (currentQuestion instanceof QuestionType3) {
                    String test = ((QuestionType3) currentQuestion).getAns();
                    int size = 0;
                    if (test != null)
                        size = test.length();
                    if (size == 0)
                        row.setBackgroundColor(Color.RED);
                    else
                        row.setBackgroundResource(R.color.Top);
                } else
                    row.setBackgroundColor(Color.WHITE);
                return row;
            }
        });
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cpt = position;
                Summary();
            }
        });
        if (cpt < 4) {
            cpt--;
            SelectQuest();
        }
    }

    public void SelectQuest() {
        myList = (ListView) findViewById(R.id.question_list);
        myList.setVisibility(View.GONE);
        Lay = (LinearLayout) findViewById(R.id.activity_question1);
        Lay.setVisibility(View.VISIBLE);
        next(null);
    }

    //Calculate the result and show it
    public void Result() {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            currentQuestion = questions.get(i);
            if (currentQuestion instanceof QuestionType1) {
                int a = ((QuestionType1) currentQuestion).getAns();
                if (a == ((QuestionType1) currentQuestion).getCorrect()) {
                    result++;
                }
            } else if (currentQuestion instanceof QuestionType2) {
                boolean b = ((QuestionType2) currentQuestion).getAns1();
                boolean c = ((QuestionType2) currentQuestion).getAns2();
                boolean d = ((QuestionType2) currentQuestion).getAns3();
                boolean e = ((QuestionType2) currentQuestion).getAns4();
                if (b == ((QuestionType2) currentQuestion).getCorrect1()
                        && c == ((QuestionType2) currentQuestion).getCorrect2()
                        && d == ((QuestionType2) currentQuestion).getCorrect3()
                        && e == ((QuestionType2) currentQuestion).getCorrect4()) {
                    result++;
                }
            } else if (currentQuestion instanceof QuestionType3) {
                String anss = ((QuestionType3) currentQuestion).getAns();
                if (anss.equalsIgnoreCase(((QuestionType3) currentQuestion).getCorrect())) {
                    result++;
                }
            }
        }
        result = result * 5;
        Intent intent = new Intent(this, Results.class).putExtra("res", result);
        startActivity(intent);
    }

    public void Sum(View view) {
        cpt = 3;
        TextView But = (TextView) findViewById(R.id.nextBut);
        But.setVisibility(View.GONE);
        But = (TextView) findViewById(prevBut);
        But.setVisibility(View.VISIBLE);
        View Sep = findViewById(R.id.sep);
        Sep.setVisibility(View.GONE);
        next(null);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            popupWindow = new PopupWindow(
                    layoutInflater.inflate(R.layout.popwindows, null, false),
                    ActionBar.LayoutParams.MATCH_PARENT,
                    ActionBar.LayoutParams.MATCH_PARENT,
                    true);
            popupWindow.showAtLocation(this.findViewById(R.id.activity_question), Gravity.CENTER, 0, 0);
        } else {
            popupWindow.dismiss();
            ;
        }
    }
}