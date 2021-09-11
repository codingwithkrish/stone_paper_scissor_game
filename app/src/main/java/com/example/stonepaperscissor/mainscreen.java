package com.example.stonepaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class mainscreen extends AppCompatActivity {
    Button stone,paper,scissor,reset;
    int humanscore = 0,computerscore=0;
    TextView human,computer;
    ImageView humanimage,computerimage;
    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        stone = findViewById(R.id.stone);
        paper = findViewById(R.id.paper);
        scissor = findViewById(R.id.scissor);
        linearLayout = findViewById(R.id.ll3);
        reset = findViewById(R.id.reset);
        human = findViewById(R.id.human);
        computer = findViewById(R.id.computer);
        humanimage = findViewById(R.id.humanimage);
        computerimage = findViewById(R.id.computerimage);
        stone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                humanimage.setImageResource(R.drawable.stone);
                play("stone");


            }
        });
        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                humanimage.setImageResource(R.drawable.paper);
                play("paper");

            }
        });
        scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                humanimage.setImageResource(R.drawable.scissor);
                play("scissor");

            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                humanscore=0;
                computerscore=0;
                human.setText("Human :"+humanscore);
                computer.setText("Computer :"+computerscore);
            }
        });
    }

    private void play(String human_choice) {
        String computer_choice = "";
        Random r = new Random();
        int computer_choice_num = r.nextInt(3)+1;
        if (computer_choice_num ==1){
            computer_choice="stone";


        }else if (computer_choice_num==2){
            computer_choice="scissor";

        }else {
            computer_choice="paper";

        }

        if (computer_choice=="stone"){
            computerimage.setImageResource(R.drawable.stone);

        }else if (computer_choice=="scissor"){
            computerimage.setImageResource(R.drawable.scissor);
        }else {
            computerimage.setImageResource(R.drawable.paper);

        }

        if (computer_choice==human_choice){
            Toast.makeText(getApplicationContext(),"Draw Nobody wins",Toast.LENGTH_LONG).show();
        }
        else if (computer_choice=="stone" && human_choice=="paper"){
            Toast.makeText(getApplicationContext(),"Human wins",Toast.LENGTH_LONG).show();
            humanscore+=1;
            human.setText("Human :"+humanscore);

        }else if(computer_choice=="stone" && human_choice=="scissor"){
            Toast.makeText(getApplicationContext(),"Computer wins",Toast.LENGTH_LONG).show();
            computerscore+=1;
            computer.setText("Computer :"+computerscore);
        }else if(computer_choice=="paper" && human_choice=="scissor"){
            Toast.makeText(getApplicationContext(),"Human wins",Toast.LENGTH_LONG).show();
            humanscore+=1;
            human.setText("Human :"+humanscore);

        }else if(computer_choice=="paper" && human_choice=="stone"){
            Toast.makeText(getApplicationContext(),"Computer wins",Toast.LENGTH_LONG).show();
            computerscore+=1;
            computer.setText("Computer :"+computerscore);
        }else if(computer_choice=="scissor" && human_choice=="stone"){
            Toast.makeText(getApplicationContext(),"Human wins",Toast.LENGTH_LONG).show();
            humanscore+=1;
            human.setText("Human :"+humanscore);

        }else if(computer_choice=="scissor" && human_choice=="paper"){
            Toast.makeText(getApplicationContext(),"Computer wins",Toast.LENGTH_LONG).show();
            computerscore+=1;
            computer.setText("Computer :"+computerscore);
        }
    }
}