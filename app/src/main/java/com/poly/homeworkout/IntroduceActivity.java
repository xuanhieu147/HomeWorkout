package com.poly.homeworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.poly.homeworkout.user.KindActivity;
import com.poly.homeworkout.user.loginActivity;

public class IntroduceActivity extends AppCompatActivity {
private ImageView imgNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);
        imgNext = findViewById(R.id.imgNext);
        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startActivity(new Intent(getApplicationContext(), loginActivity.class));
            }
        });
    }
}