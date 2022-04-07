package com.example.lab09_graphs_393_gavrilov;

//393 Gavrilov
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import math.interp;

public class MainActivity extends AppCompatActivity {

    MySurface s;

    String data[] = { "sqrt(x)", "x^2", "x^3", "sin(x)", "1/x" };

    float xMin, xMax;

    //393 Gavrilov
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s = findViewById(R.id.mySurface);

        s.n = 100;

        s.x = new float[s.n];
        s.y = new float[s.n];

        for (int i = 0; i < s.n; i++)
        {
            s.x[i] = interp.map(i, 0, s.n - 1, 0.0f, (float)Math.PI * 4.0f);
            s.y[i] = (float) Math.cos(s.x[i]);
        }

        s.Update();
        s.invalidate();
    }

    //393 Gavrilov
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

            if (data != null)
            {
                xMax = data.getFloatExtra("xMax", 1);
                xMin = data.getFloatExtra("xMin", 1);

                s.n = data.getIntExtra("countDots", 100);
                s.x = new float[s.n];
                s.y = new float[s.n];

                for (int i = 0; i < s.n; i++)
                {
                    s.x[i] = interp.map(i, 0, s.n - 1, xMin, xMax);
                    s.y[i] = (float) Math.cos(s.x[i]);
                }

                s.Update();
                s.invalidate();
            }

        super.onActivityResult(requestCode, resultCode, data);
    }

    //393 Gavrilov
    public void on_Setting_Click(View v)
    {
        Intent i = new Intent(this, SettingActivity.class);

        startActivityForResult(i, 1);
    }

    public void on_OtherFunction_Click(View v)
    {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);

        adb.setTitle(R.string.itemsFunction);
        adb.setItems(data, myClickListener);

        adb.show();
    }

    //393 Gavrilov
    OnClickListener myClickListener = new OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            xMax = 10;
            xMin = -10;

            s.n = 100;

            s.x = new float[s.n];
            s.y = new float[s.n];
            switch (which)
            {
                case 0:
                    xMax = 30;
                    xMin = 0;

                    for (int i = 0; i < s.n; i++)
                    {
                        s.x[i] = interp.map(i, 0, s.n - 1, xMin, xMax);
                        s.y[i] = (float) Math.sqrt(s.x[i]);
                    }
                    break;
                case 1:
                    for (int i = 0; i < s.n; i++)
                    {
                        s.x[i] = interp.map(i, 0, s.n - 1, xMin, xMax);
                        s.y[i] = (float) s.x[i] * s.x[i];
                    }
                    break;
                case 2:
                    for (int i = 0; i < s.n; i++)
                    {
                        s.x[i] = interp.map(i, 0, s.n - 1, xMin, xMax);
                        s.y[i] = (float) s.x[i] * s.x[i] * s.x[i];
                    }
                    break;
                case 3:
                    for (int i = 0; i < s.n; i++)
                    {
                        s.x[i] = interp.map(i, 0, s.n - 1, xMin, xMax);
                        s.y[i] = (float) Math.sin(s.x[i]);
                    }
                    break;
                case 4:
                    for (int i = 0; i < s.n; i++)
                    {
                        s.x[i] = interp.map(i, 0, s.n - 1, xMin, xMax);
                        s.y[i] = (float) 1/s.x[i];
                    }
                    break;
            }

            s.Update();
            s.invalidate();
        }
    };
}