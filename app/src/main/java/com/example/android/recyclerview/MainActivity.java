package com.example.android.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CalculatorAdapter adapter;
    List<Calculator> calculatorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatorList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        calculatorList.add(
                new Calculator(
                        1,
                        "One Rep Max",
                        "Calculate your one-rep maxes for your squat, bench, and deadlift.",
                        R.drawable.one_rep_max));

        calculatorList.add(
                new Calculator(
                        2,
                        "TDEE, BMI & Ideal BW",
                        "Find out your TDEE, BMI, and ideal bodyweight.",
                        R.drawable.tdee));

        calculatorList.add(
                new Calculator(
                        3,
                        "Wilks Coefficient",
                        "See where you stand relative to other lifters with your Wilks coefficient",
                        R.drawable.wilks));

        adapter = new CalculatorAdapter(this, calculatorList);
        recyclerView.setAdapter(adapter);
    }
}
