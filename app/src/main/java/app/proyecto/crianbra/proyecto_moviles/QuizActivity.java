package app.proyecto.crianbra.proyecto_moviles;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crianbra.proyecto_moviles.R;

import org.w3c.dom.Text;

public class QuizActivity extends AppCompatActivity {

    /*private int ids_answers[] = {
            R.id.radio_btn_1, R.id.radio_btn_2, R.id.radio_btn_3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        String carpetaFuente = "fonts/galette-med.otf";
        Typeface fuente = Typeface.createFromAsset(getAssets(), carpetaFuente);

        TextView text_question = (TextView) findViewById(R.id.txt_quiz);
        text_question.setTypeface(fuente);
        text_question.setText(R.string.question_content);

        TextView quiz = (TextView)findViewById(R.id.quiz);
        quiz.setTypeface(fuente);

        String[] answers = getResources().getStringArray(R.array.answers);

        for (int i = 0; i < ids_answers.length; i++) {
            RadioButton rb = (RadioButton) findViewById(ids_answers[i]);
            rb.setTypeface(fuente);
            rb.setText(answers[i]);
        }

        final int correct_answer = getResources().getInteger(R.integer.correct_answer);
        final RadioGroup group = (RadioGroup) findViewById(R.id.answer_group);

        Button btn_check = (Button) findViewById(R.id.btn_next);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = group.getCheckedRadioButtonId();
                int answer = -1;
                for (int i = 0; i < ids_answers.length; i++) {
                    if (ids_answers[i] == id) {
                        answer = i;
                    }
                }
                if (answer == correct_answer) {
                    Toast.makeText(QuizActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(QuizActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }*/

    public static final String CORRECT_ANSWER = "correct_answer";
    public static final String CURRENT_QUESTION = "current_question";
    public static final String ANSWER_IS_CORRECT = "answer_is_correct";
    public static final String ANSWER = "answer";

    private int ids_answers[] = {
            R.id.radio_btn_1, R.id.radio_btn_2, R.id.radio_btn_3
    };
    private String[] all_questions;

    private TextView text_question;
    private RadioGroup group;
    private Button btn_next, btn_prev;

    private int correct_answer;
    private int current_question;
    private boolean[] answer_is_correct;
    private int[] answer;




    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i("lifecycle", "onSaveInstanceState");
        super.onSaveInstanceState(outState);
        outState.putInt(CORRECT_ANSWER, correct_answer);
        outState.putInt(CURRENT_QUESTION, current_question);
        outState.putBooleanArray(ANSWER_IS_CORRECT, answer_is_correct);
        outState.putIntArray(ANSWER, answer);
    }

    @Override
    protected void onStop() {
        Log.i("lifecycle", "onStop");
        super.onStop();
    }

    @Override
    protected void onStart() {
        Log.i("lifecycle", "onStart");
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        Log.i("lifecycle", "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("lifecycle", "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        text_question = (TextView) findViewById(R.id.txt_quiz);
        group = (RadioGroup) findViewById(R.id.answer_group);
        btn_next = (Button) findViewById(R.id.btn_next);
        btn_prev = (Button) findViewById(R.id.btn_prev);

        String carpetaFuente = "fonts/galette-med.otf";
        Typeface fuente = Typeface.createFromAsset(getAssets(), carpetaFuente);

        text_question.setTypeface(fuente);
        btn_next.setTypeface(fuente);
        btn_prev.setTypeface(fuente);

        TextView quiz = (TextView)findViewById(R.id.quiz);
        quiz.setTypeface(fuente);

        all_questions = getResources().getStringArray(R.array.all_questions);

        if (savedInstanceState == null) {
            startOver();
        } else {
            Bundle state = savedInstanceState;
            correct_answer = state.getInt(CORRECT_ANSWER);
            current_question = state.getInt(CURRENT_QUESTION);
            answer_is_correct = state.getBooleanArray(ANSWER_IS_CORRECT);
            answer = state.getIntArray(ANSWER);
            showQuestion();
        }

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
                if (current_question < all_questions.length-1) {
                    current_question++;
                    showQuestion();
                } else {
                    checkResults();
                }
            }
        });

        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
                if (current_question > 0) {
                    current_question--;
                    showQuestion();
                }
            }
        });
    }

    private void startOver() {
        answer_is_correct = new boolean[all_questions.length];
        answer = new int[all_questions.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = -1;
        }
        current_question = 0;
        showQuestion();
    }

    private void checkResults() {

        int correctas = 0, incorrectas = 0, nocontestadas = 0;
        for (int i = 0; i < all_questions.length; i++) {
            if (answer_is_correct[i]) correctas++;
            else if (answer[i] == -1) nocontestadas++;
            else incorrectas++;
        }

        // TODO: Permitir traducción de este texto:
        String message = String.format("Correctas: %d\nIncorrectas: %d\nNo contestadas: %d\n",
                        correctas, incorrectas, nocontestadas);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.results);
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton(R.string.finish, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //finish();
                Intent i = new Intent(QuizActivity.this, Matematica2Activity.class);
                startActivity(i);
            }
        });
        builder.setNegativeButton(R.string.start_over, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startOver();
            }
        });
        builder.create().show();
    }

    private void checkAnswer() {
        int id = group.getCheckedRadioButtonId();
        int ans = -1;
        for (int i = 0; i < ids_answers.length; i++) {
            if (ids_answers[i] == id) {
                ans = i;
            }
        }
        answer_is_correct[current_question] = (ans == correct_answer);
        answer[current_question] = ans;
    }

    private void showQuestion() {

        String carpetaFuente = "fonts/galette-med.otf";
        Typeface fuente = Typeface.createFromAsset(getAssets(), carpetaFuente);


        String q = all_questions[current_question];
        String[] parts = q.split(";");

        group.clearCheck();

        text_question.setText(parts[0]);
        for (int i = 0; i < ids_answers.length; i++) {
            RadioButton rb = (RadioButton) findViewById(ids_answers[i]);
            rb.setTypeface(fuente);
            String ans = parts[i+1];
            if (ans.charAt(0) == '*') {
                correct_answer = i;
                ans = ans.substring(1);
            }
            rb.setText(ans);
            if (answer[current_question] == i) {
                rb.setChecked(true);
            }
        }
        if (current_question == 0) {
            btn_prev.setVisibility(View.GONE);
        } else {
            btn_prev.setVisibility(View.VISIBLE);
        }
        if (current_question == all_questions.length-1) {
            btn_next.setText(R.string.finish);
        } else {
            btn_next.setText(R.string.next);
        }
    }
}
