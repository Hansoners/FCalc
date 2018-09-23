package com.example.android.recyclerview;

import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class WilksActivity extends AppCompatActivity {

    int squat = 0;
    int deadlift = 0;
    int bench = 0;
    int weight = 0;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wilks);

        final TextView tvWilks = (TextView) findViewById(R.id.tvWilks);
        final TextView tvLevel = (TextView) findViewById(R.id.tvSkill);
        final TextInputEditText edSquat = (TextInputEditText) findViewById(R.id.squatNum);
        final TextInputEditText edBench = (TextInputEditText) findViewById(R.id.benchNum);
        final TextInputEditText edDeadlift = (TextInputEditText) findViewById(R.id.deadliftNum);
        final TextInputEditText edWeight = (TextInputEditText) findViewById(R.id.weightNum2);

        edSquat.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!edSquat.getText().toString().matches("")) {
                    squat = Integer.parseInt(edSquat.getText().toString());
                    count++;
                }
            }
        });

        edBench.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!edBench.getText().toString().matches("")) {
                    bench = Integer.parseInt(edBench.getText().toString());
                    count++;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        edDeadlift.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!edDeadlift.getText().toString().matches("")) {
                    deadlift = Integer.parseInt(edDeadlift.getText().toString());
                    count++;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        edWeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!edWeight.getText().toString().matches("")) {
                    weight = Integer.parseInt(edWeight.getText().toString());
                    count++;
                }
            }
        });

        final Button calculateBtn = (Button) findViewById(R.id.calculateBtn);


        calculateBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                double wilks = 0;

                if (count >= 4) {
                    InputMethodManager inputManager = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);

                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);

                    wilks = calculateWilks(weight, squat, bench, deadlift);
                    tvWilks.setText("" + round(wilks,1));

                    if (wilks <= 120) {
                        tvLevel.setText("Un-trained");
                    }

                    else if (wilks <= 200) {
                        tvLevel.setText("Novice");
                    }

                    else if (wilks <= 238) {
                        tvLevel.setText("Intermediate");
                    }

                    else if (wilks <= 326) {
                        tvLevel.setText("Advanced");
                    }

                    else if (wilks <= 414) {
                        tvLevel.setText("Elite");
                    }
                }

            }
        });

    }

    public double calculateWilks(int w, int squat, int bench, int deadlift) {
        double total = (squat + bench + deadlift) / 2.20462;
        double a = -216.0475144;
        double b = 16.2606339;
        double c = -0.002388645;
        double d = -0.00113732;
        double e = 7.01863E-06;
        double f = -1.291E-08;
        double x = w / 2.20462;
        double coeff = 500 / (a + (b * x) + (c * Math.pow(x, 2)) + (d * Math.pow(x, 3))
                + (e * Math.pow(x, 4)) + (f * Math.pow(x, 5)));

        return coeff * total;
    }

    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}
