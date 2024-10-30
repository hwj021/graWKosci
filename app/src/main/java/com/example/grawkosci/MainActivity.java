package com.example.grawkosci;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;



public class MainActivity extends AppCompatActivity {
    private Button graj;
    private Button reset;
    private TextView los1;
    private TextView los2;
    private TextView los3;
    private TextView los4;
    private TextView los5;
    private TextView wynikLosowania;
    private TextView wynikGry;
    private TextView liczbaGier;

    private int gry = 0;
    private int wynikLos = 0;
    private int wynikGryCaly = 0;
    private int sum = 0;
    private int[] list = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        graj = findViewById(R.id.graj);
        reset = findViewById(R.id.reset);
        los1 = findViewById(R.id.los1);
        los2 = findViewById(R.id.los2);
        los3 = findViewById(R.id.los3);
        los4 = findViewById(R.id.los4);
        los5 = findViewById(R.id.los5);
        wynikLosowania = findViewById(R.id.wynikLosowania);
        wynikGry = findViewById(R.id.wynikGry);
        liczbaGier = findViewById(R.id.liczbaGier);


        graj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
                updateScore(sum);
                updateRollCount();
                displayDiceResults(list);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });

    }

    private void rollDice(){
        Random rand = new Random();
        sum = 0;

        int a;
        for (int i = 0; i < 5; i++) {
            a = rand.nextInt(6) + 1;
            sum = sum +a;
            list[i] = a;
        }

        wynikLos = sum;
        wynikLosowania.setText("Wynik tego losowania: " + wynikLos);
    }

    private void resetGame(){
        los1.setText("?");
        los2.setText("?");
        los3.setText("?");
        los4.setText("?");
        los5.setText("?");

        wynikLos = 0;
        wynikLosowania.setText("Wynik tego losowania: " + wynikLos);

        wynikGryCaly = 0;
        wynikGry.setText("Wynik gry: " + wynikGryCaly);

        gry = 0;
        liczbaGier.setText("Liczba gier: " +  gry);
    }

    private void updateScore(int newScore){
        wynikGryCaly = wynikGryCaly + newScore;
        wynikGry.setText("Wynik gry: " + wynikGryCaly);
    }

    private void updateRollCount(){
        gry++;
        liczbaGier.setText("Liczba gier: " +  gry);
    }

    private void displayDiceResults(int[] diceResults){
        los1.setText(String.valueOf(diceResults[0]));
        los2.setText(String.valueOf(diceResults[1]));
        los3.setText(String.valueOf(diceResults[2]));
        los4.setText(String.valueOf(diceResults[3]));
        los5.setText(String.valueOf(diceResults[4]));
    }

}