package com.example.android.recyclerview;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import android.widget.Toast;


public class ORMActivity extends AppCompatActivity implements TextWatcher {

    TextInputEditText editText1;
    TextInputEditText editText2;
    TextView ormText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orm);

        editText1 = (TextInputEditText) findViewById(R.id.weightNum);
        editText2 = (TextInputEditText) findViewById(R.id.repsNum);
        ormText = (TextView) findViewById(R.id.ormNum);

        editText1.addTextChangedListener(this);
        editText2.addTextChangedListener(this);

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (editText1.getText().hashCode() == editable.hashCode()) {
            editText1.removeTextChangedListener(this);
            float reps = 0;
            float weight = 0;

            if (!editText1.getText().toString().matches("")) {
                weight = Integer.parseInt(editText1.getText().toString());
            }

            String stringValue = editText2.getText().toString();
            if (!stringValue.matches("")) {
                reps = Integer.parseInt(editText2.getText().toString());
            }

            float max = calculateMax(weight, reps);
            ormText.setText("" + max);
            editText1.addTextChangedListener(this);

        } else if (editText2.getText().hashCode() == editable.hashCode()) {

            editText2.removeTextChangedListener(this);
            float reps = 0;
            float weight = 0;

            if (!editText2.getText().toString().matches("")) {
                reps = Integer.parseInt(editText2.getText().toString());
            }

            String stringValue = editText1.getText().toString();
            if (!stringValue.matches("")) {
                weight = Integer.parseInt(editText1.getText().toString());
            }
            float max = calculateMax(weight, reps);
            ormText.setText("" + max);
            editText2.addTextChangedListener(this);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public float calculateMax(float weight, float reps) {
        if (reps == 1) return weight;
        return (weight * (1 + reps/30));
    }
}

