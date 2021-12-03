package hu.example.szamolo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import androidx.appcompat.app.AppCompatActivity;

public class RectangleActivity extends AppCompatActivity implements View.OnClickListener {
    Button computeButton, menuButton;
    EditText tvA, tvB;
    TextView resCircum, resArea;
    DecimalFormat df = new DecimalFormat();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);
        computeButton = findViewById(R.id.btn_compute);
        menuButton = findViewById(R.id.btn_menu);
        tvA = findViewById(R.id.textASide);
        tvB = findViewById(R.id.textBSide);
        resArea = findViewById(R.id.resultArea);
        resCircum = findViewById(R.id.resultCircumference);
        computeButton.setOnClickListener(this);
        menuButton.setOnClickListener(this);
        df.setMaximumFractionDigits(2);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_compute) {
            String valA = tvA.getText().toString();
            String valB = tvB.getText().toString();
            if(valA.length()>0 && valB.length()>0) {
                double a = Double.parseDouble(valA);
                double b = Double.parseDouble(valB);
                if(a>0 && b>0) {
                    resCircum.setText(df.format((a+b)*2));
                    resArea.setText(df.format(a*b));
                }else {
                    Toast.makeText(this, R.string.number_please, Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(this, R.string.number_please, Toast.LENGTH_SHORT).show();
            }

        }else if (view.getId() == R.id.btn_menu) {
            finish();
        }
    }
}
