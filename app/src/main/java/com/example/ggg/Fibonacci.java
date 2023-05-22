package com.example.ggg;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class Fibonacci extends Fragment {
    private EditText numberEditText;
    private Button submitButton;
    private TextView answerTextView,answer_text;


    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.activity_fibonacci, container, false);

        numberEditText = view.findViewById(R.id.number1);
        submitButton = view.findViewById(R.id.submit);
        answerTextView = view.findViewById(R.id.answer);
        answer_text = view.findViewById(R.id.answer_text);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateFibonacci();
            }
        });
        return view;

    }

    private void calculateFibonacci() {
        String input = numberEditText.getText().toString();

        if (input.isEmpty()) {
            Toast.makeText(getContext(), "Please enter a number", Toast.LENGTH_SHORT).show();
            return;
        }

        int count = Integer.parseInt(input);

        if (count <= 0) {
            Toast.makeText(getContext(), "Invalid input. Please enter a positive number", Toast.LENGTH_SHORT).show();
            return;
        }

        StringBuilder sequenceString = new StringBuilder();
        sequenceString.append("The Fibonacci sequence of fn for 0 <= n <= ").append(count).append("\n\n");

        int a = 0;
        int b = 1;
        sequenceString.append(a).append(",  ");
        if (count > 1) {
            sequenceString.append(b).append(", ");
        }

        for (int i = 1; i < count; i++) {
            int c = a + b;
            sequenceString.append(c).append(", ");
            a = b;
            b = c;
        }

        String sequence = removeComma(sequenceString.toString());
        answerTextView.setText(sequence);

        answer_text.setVisibility(View.VISIBLE);
    }

    private String removeComma(String sequence) {
        if (sequence.endsWith(", ")) {
            return sequence.substring(0, sequence.length() - 2);
        } else {
            return sequence;
        }
    }
}
