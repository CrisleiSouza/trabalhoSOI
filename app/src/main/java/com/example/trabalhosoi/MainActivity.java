package com.example.trabalhosoi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import controller.Calcular;

public class MainActivity extends AppCompatActivity {

    private EditText etNumber;
    private Button btnCalcular;
    private TextView tvAgain;
    private TextView tvH;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNumber = findViewById(R.id.etNumber);
        etNumber.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvAgain = findViewById(R.id.tvAgain);
        tvAgain.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvH = findViewById(R.id.tvH);
        tvH.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(op -> chama());
    }

    public void chama() {
        tvAgain.setText(null);
        tvH.setText(null);
        if (etNumber.getText().toString().isEmpty()) {
            tvAgain.setText(R.string.tvAgain);
        } else {
            int num = Integer.parseInt(etNumber.getText().toString());

            if (num <= 0 || num >= 20) {
                tvAgain.setText(R.string.tvAgain);
            } else {
                Calcular calc = new Calcular();
                tvH.setText(getString(R.string.tvH) + " " + calc.calculaH(num));
            }
        }
    }
}