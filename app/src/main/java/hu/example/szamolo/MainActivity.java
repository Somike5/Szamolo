package hu.example.szamolo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button circleButton, rectangleButton;
    Intent i = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circleButton = findViewById(R.id.btn_cicrle);
        rectangleButton = findViewById(R.id.btn_rect);
        circleButton.setOnClickListener(this);
        rectangleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_cicrle){
            i.setClass(this, CircleActivity.class);
            startActivity(i);
        }else if (view.getId() == R.id.btn_rect){
            i.setClass(this, RectangleActivity.class);
            startActivity(i);
        }
    }


}