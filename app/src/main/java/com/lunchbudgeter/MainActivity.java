package com.lunchbudgeter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NumberPicker np1 = (NumberPicker) findViewById(R.id.picker_ten_pounds);
        NumberPicker np2 = (NumberPicker) findViewById(R.id.picker_unit_pounds);
        NumberPicker np3 = (NumberPicker) findViewById(R.id.picker_ten_pence);
        NumberPicker np4 = (NumberPicker) findViewById(R.id.picker_unit_pence);
        np1.setMaxValue(9);
        np1.setMinValue(0);
        np1.setWrapSelectorWheel(true);
        np2.setMaxValue(9);
        np2.setMinValue(0);
        np2.setWrapSelectorWheel(true);
        np3.setMaxValue(9);
        np3.setMinValue(0);
        np3.setWrapSelectorWheel(true);
        np4.setMaxValue(9);
        np4.setMinValue(0);
        np4.setWrapSelectorWheel(true);

    }
}
