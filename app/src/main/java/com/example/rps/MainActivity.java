package com.example.rps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button rock,paper,scissors;
    TextView scor;
    ImageView eualeg,androidalege;
    int Player,Droid=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paper = (Button) findViewById(R.id.paper);
        rock = (Button) findViewById(R.id.rock);
        scissors = (Button) findViewById(R.id.scissors);

        scor = (TextView) findViewById(R.id.scor);

        eualeg=(ImageView) findViewById(R.id.eualeg);
        androidalege=(ImageView) findViewById(R.id.androidalege);

        rock.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                eualeg.setImageResource(R.drawable.rock);
                String msg= joaca(0);
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                scor.setText("\t\t\t\t\t\tScor\nEu - "+Integer.toString(Player)+"\t Android - "+Integer.toString(Droid));
            }
        });

        paper.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                eualeg.setImageResource(R.drawable.paper);
                String msg= joaca(2);
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                scor.setText("\t\t\t\t\t\tScor\nEu - "+Integer.toString(Player)+"\t Android - "+Integer.toString(Droid));

            }
        });
        scissors.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                eualeg.setImageResource(R.drawable.scissors);
                String msg= joaca(1);
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                scor.setText("\t\t\t\t\t\tScor\nEu - "+Integer.toString(Player)+"\t Android - "+Integer.toString(Droid));

            }
        });



    }
    public String joaca (int alegeEu){
         Random r = new Random();
         int numarDroid=r.nextInt(3);
            //0=piatra 1= foarfeca 2 = hartie
        if(numarDroid==0)
             androidalege.setImageResource(R.drawable.rock);
        if(numarDroid==1)
            androidalege.setImageResource(R.drawable.scissors);
        if(numarDroid==2)
            androidalege.setImageResource(R.drawable.paper);
        if(alegeEu==numarDroid)
            return "Egalitate!";
        if(alegeEu==0 && numarDroid==1) {
            Player++;
            return "Ai câștigat!";
        }
        if(alegeEu==1 && numarDroid==2) {
            Player++;
            return "Ai câștigat!";
        }
        if(alegeEu==1 && numarDroid==0) {
            Droid++;
            return "Ai pierdut!:(";
        }
        if(alegeEu==2 && numarDroid==1) {
            Droid++;
            return "Ai pierdut!:(";
        }
        if(alegeEu==0 && numarDroid==2) {
            Droid++;
            return "Ai pierdut!:(";
        }
        if(alegeEu==2 && numarDroid==0) {
            Player++;
            return "Ai câștigat!";
        }
        else return "You shouldn't be here O.O ";
    }
}
