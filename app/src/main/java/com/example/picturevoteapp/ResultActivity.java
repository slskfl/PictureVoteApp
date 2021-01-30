package com.example.picturevoteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView tvNames[]=new TextView[9];
    RatingBar rBars[]=new RatingBar[9];
    int tvNameIDs[]={R.id.tvName1, R.id.tvName2, R.id.tvName3, R.id.tvName4, R.id.tvName5,
            R.id.tvName6,R.id.tvName7, R.id.tvName8, R.id.tvName9};
    int rBarIDs[]={R.id.rBar1, R.id.rBar2, R.id.rBar3, R.id.rBar4, R.id.rBar5,
            R.id.rBar6, R.id.rBar7, R.id.rBar8, R.id.rBar9};
    Button btnResult;
    String[] imgNames;
    int[] voteResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btnResult=findViewById(R.id.btnResult);
        for(int i=0; i<tvNames.length; i++){
            tvNames[i]=findViewById(tvNameIDs[i]);
            rBars[i]=findViewById(rBarIDs[i]);
        }

        Intent gIntent=getIntent();
        imgNames=gIntent.getStringArrayExtra("Imagename");
        voteResult=gIntent.getIntArrayExtra("VoteCount");
        for(int i=0; i<imgNames.length; i++){
            tvNames[i].setText(imgNames[i]+"("+voteResult[i]+")");
            rBars[i].setRating(voteResult[i]);
        }
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });





    }
}