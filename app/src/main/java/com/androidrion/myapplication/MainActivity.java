package com.androidrion.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int textSize = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtSeekBar = findViewById(R.id.textView);
        final TextView textView2 = findViewById(R.id.textView2);
        SeekBar seekBar = findViewById(R.id.seekBar);

        txtSeekBar.setTextSize(textSize);
        textView2.setText(seekBar.getProgress() + "/" + seekBar.getMax());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progress = 0;

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView2.setText(progress + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                textSize = textSize + (progressValue - progress);
                progress = progressValue;
                txtSeekBar.setTextSize(textSize);
            }
        });

    }
}
