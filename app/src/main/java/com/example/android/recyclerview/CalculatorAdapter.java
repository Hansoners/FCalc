package com.example.android.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
