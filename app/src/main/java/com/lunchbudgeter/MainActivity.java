package com.lunchbudgeter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    public TextView budgetTextView, day1TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        budgetTextView = (EditText) findViewById(R.id.editTextBudget);
        day1TextView = (EditText) findViewById(R.id.editTextDay1);
        budgetTextView.addTextChangedListener(new CurrencyTextWatcher());
        day1TextView.addTextChangedListener(new CurrencyTextWatcher());

        submitButtonClick();
        calculateButtonClick();
        clearButtonClick();
        clearButtonD1Click();

    }

    public void submitButtonClick() {
        Button a = (Button) findViewById(R.id.btn_confirm_budget);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.editTextBudget);

                String inputValue = editText.getText().toString();
                inputValue = inputValue.replace("£", "0");

                float floatValue = Float.parseFloat(inputValue); //budget float

                Toast.makeText(MainActivity.this, "Budget: " + floatValue, Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void clearButtonClick() {
        Button a = (Button) findViewById(R.id.btn_clear);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editText = (EditText) findViewById(R.id.editTextBudget);

                editText.setText("0.00");

                editText.setSelection(editText.length());

                Toast.makeText(MainActivity.this, "Budget cleared.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void clearButtonD1Click() {
        Button a = (Button) findViewById(R.id.btn_clear_day1);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editText = (EditText) findViewById(R.id.editTextDay1);

                editText.setText("0.00");

                editText.setSelection(editText.length());

                Toast.makeText(MainActivity.this, "Money cleared.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void calculateButtonClick() {
        Button a = (Button) findViewById(R.id.btn_confirm_day1);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.editTextDay1);

                String inputValue = editText.getText().toString();
                inputValue = inputValue.replace("£", "0");

                float floatValue = Float.parseFloat(inputValue); //budget float

                Toast.makeText(MainActivity.this, "Spent: " + floatValue, Toast.LENGTH_SHORT).show();

            }
        });
    }

}

class CurrencyTextWatcher implements TextWatcher {

    boolean mEditing;

    public CurrencyTextWatcher() {
        mEditing = false;
    }

    public synchronized void afterTextChanged(Editable s) {
        if (!mEditing) {
            mEditing = true;

            String digits = s.toString().replaceAll("\\D", "");
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            try {
                String formatted = nf.format(Double.parseDouble(digits) / 100);
                s.replace(0, s.length(), formatted);
            } catch (NumberFormatException nfe) {
                s.clear();
            }

            mEditing = false;
        }
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

}

