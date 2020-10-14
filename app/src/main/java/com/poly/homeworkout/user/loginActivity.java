package com.poly.homeworkout.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.poly.homeworkout.R;

public class loginActivity extends AppCompatActivity {
    TextView btnDangNhap, btnDangKy;
    EditText edEmail, edPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edEmail = findViewById(R.id.edEmail);
        edPass = findViewById(R.id.edPassword);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnDangKy = findViewById(R.id.btnDangk);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = "admin";
                String pass = "12345";
                if (edEmail.getText().toString().equals(email) && edPass.getText().toString().equals(pass)){
                    Toast.makeText(getApplicationContext(),"Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), KindActivity.class);
                startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i
                        = new Intent(getApplicationContext(),registrationActivity.class);
                startActivity(i);
            }
        });
    }
}