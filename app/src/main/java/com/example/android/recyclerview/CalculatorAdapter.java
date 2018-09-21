package com.example.android.recyclerview;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CalculatorAdapter extends RecyclerView.Adapter<CalculatorAdapter.CalculatorViewHolder>{


    private Context mCtx;
    private List<Calculator> calculatorList;

    public CalculatorAdapter(Context mCtx, List<Calculator> calculatorList) {
        this.mCtx = mCtx;
        this.calculatorList = calculatorList;
    }

    @NonNull
    @Override
    public CalculatorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout, null);
        return new CalculatorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CalculatorViewHolder calculatorViewHolder, int i) {
        Calculator calculator = calculatorList.get(i);
        calculatorViewHolder.textViewTitle.setText(calculator.getTitle());
        calculatorViewHolder.textViewDesc.setText(calculator.getDescription());
        calculatorViewHolder.imageView.setImageDrawable(mCtx.getResources().getDrawable(calculator.getImage()));

        final Calculator c = calculatorList.get(i);

        calculatorViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c.getId() == 1) {
                    Intent intent = new Intent(v.getContext(), ORMActivity.class);
                    v.getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return calculatorList.size();
    }

    class CalculatorViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewTitle, textViewDesc;

        public CalculatorViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDesc = itemView.findViewById(R.id.textViewDesc);
        }


    }
}
