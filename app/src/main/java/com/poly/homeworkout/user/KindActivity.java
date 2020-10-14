package com.poly.homeworkout.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.poly.homeworkout.MainActivity;
import com.poly.homeworkout.R;
import com.poly.homeworkout.exercise.ExerciseFragment;

public class KindActivity extends AppCompatActivity {
    ImageView imgNam;
    private NumberPicker numPick, numPicker, numPickeT;
    TextView btnStart;
    LinearLayout llinner, llinnern;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kind);
        numPick = findViewById(R.id.numPick);
        numPicker = findViewById(R.id.numPicker);
        numPickeT = findViewById(R.id.numPickeT);
        btnStart = findViewById(R.id.btnStart);
        numPicker.setMinValue(20);
        numPicker.setMaxValue(200);
        numPick.setWrapSelectorWheel(false);
        numPicker.setWrapSelectorWheel(false);
        numPickeT.setWrapSelectorWheel(false);
        imgNam = findViewById(R.id.imgNam);
        llinner = findViewById(R.id.llinner);
        llinnern = findViewById(R.id.llinnern);
        llinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llinner.setSelected(true);
                llinnern.setSelected(false);
                Toast.makeText(getApplicationContext(), "lỗi", Toast.LENGTH_SHORT).show();
            }
        });
        llinnern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llinner.setSelected(false);
                llinnern.setSelected(true);
            }
        });

        numPick.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
            }
        });
        numPick.setMaxValue(249);
        numPick.setMinValue(120);
        numPick.setOrientation(LinearLayout.HORIZONTAL);
        numPickeT.setMaxValue(50);
        numPickeT.setMinValue(15);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

}