package com.rizkykhapidsyah.p_progressbar__jvm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ProgressBar PB_Loading_IDJAVA;
    TextView TV_Persen_IDJAVA;
    Button B_Mulai_IDJAVA;

    private int X = 0;
    private Handler varHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PB_Loading_IDJAVA = findViewById(R.id.PB_Loading_IDXML);
        TV_Persen_IDJAVA = findViewById(R.id.TV_Persen_IDXML);
        B_Mulai_IDJAVA = findViewById(R.id.B_Mulai_IDXML);

        B_Mulai_IDJAVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (X < 100) {
                            X += 10;
                            varHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    PB_Loading_IDJAVA.setProgress(X);
                                    if (X == 100) {
                                        PB_Loading_IDJAVA.setProgress(X);
                                        Toast.makeText(getApplicationContext(),
                                                "Download Selesai!",
                                                Toast.LENGTH_LONG).show();
                                        TV_Persen_IDJAVA.setText(X + "%");
                                        B_Mulai_IDJAVA.setText(R.string.B_Mulai_IDXML);
                                    } else {
                                        String Xs = String.valueOf(X);
                                        TV_Persen_IDJAVA.setText(Xs + "%");
                                        B_Mulai_IDJAVA.setText(R.string.B_Mulai_IDXML_2);
                                    }
                                }
                            });
                            try {
                                Thread.sleep(800);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });
    }
}
