package hu.example.szamolo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import androidx.appcompat.app.AppCompatActivity;


public class CircleActivity extends AppCompatActivity implements View.OnClickListener {
    Button computeButton, menuButton;
    TextView tv, resCircumf, resArea;
    DecimalFormat df = new DecimalFormat();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
        computeButton = findViewById(R.id.btn_compute);
        computeButton.setOnClickListener(this);
        menuButton = findViewById(R.id.btn_menu);
        menuButton.setOnClickListener(this);
        tv = findViewById(R.id.textRadius);
        resCircumf = findViewById(R.id.resultCircumference);
        resArea = findViewById(R.id.resultArea);
        df.setMaximumFractionDigits(2);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_compute) {
            String value = tv.getText().toString();
            if(value.length() > 0) {
                double r = Double.parseDouble(value);
                if(r>0){
                        double cf = 2*r*Math.PI;
                        resCircumf.setText(df.format(cf));
                        double a = Math.pow(r,2)*Math.PI;
                        resArea.setText(df.format(a));
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
