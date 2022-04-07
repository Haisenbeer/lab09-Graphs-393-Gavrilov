package com.example.lab09_graphs_393_gavrilov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//393 Gavrilov
public class SettingActivity extends AppCompatActivity {

    EditText txt_countDots, txt_xMin, txt_xMax;

    //393 Gavrilov
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        txt_countDots = findViewById(R.id.countDots);
        txt_xMin = findViewById(R.id.xMin);
        txt_xMax = findViewById(R.id.xMax);

        Intent i = getIntent();
    }

    //393 Gavrilov
    public void on_Save_Click(View v)
    {
        Intent i = new Intent();

        int countDots;
        float xMin, xMax;

        try {
            countDots = Integer.parseInt(txt_countDots.getText().toString());
            xMin = Float.parseFloat(txt_xMin.getText().toString());
            xMax = Float.parseFloat(txt_xMax.getText().toString());
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Incorrect input", Toast.LENGTH_SHORT).show();
            return;
        }

        if (xMin > xMax)
        {
            Toast.makeText(this, "xMin is bigger than xMax", Toast.LENGTH_SHORT).show();
            return;
        }

        i.putExtra("countDots", countDots);
        i.putExtra("xMin", xMin);
        i.putExtra("xMax", xMax);

        setResult(RESULT_OK, i);
        finish();
    }

    public void on_Back_Click(View v)
    {
        setResult(RESULT_CANCELED);
        finish();
    }
}