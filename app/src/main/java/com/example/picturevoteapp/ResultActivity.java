package com.example.picturevoteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView tvNames[]=new TextView[9];
    RatingBar rBars[]=new RatingBar[9];
    TextView tvTopName;
    ImageView imgTop;
    int imgTopID[]={R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
            R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9 };
    int tvNameIDs[]={R.id.tvName1, R.id.tvName2, R.id.tvName3, R.id.tvName4, R.id.tvName5,
            R.id.tvName6,R.id.tvName7, R.id.tvName8, R.id.tvName9};
    int rBarIDs[]={R.id.rBar1, R.id.rBar2, R.id.rBar3, R.id.rBar4, R.id.rBar5,
            R.id.rBar6, R.id.rBar7, R.id.rBar8, R.id.rBar9};
    Button btnReturn;
    String[] imgNames; //명화 이름들을 받을 배열
    int[] voteResult; // 투표 수들을 받을 배열
    int maxEntry=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btnReturn=findViewById(R.id.btnReturn);
        tvTopName=findViewById(R.id.tvTopName);
        imgTop=findViewById(R.id.imgTop);

        for(int i=0; i<tvNames.length; i++){
            tvNames[i]=findViewById(tvNameIDs[i]);
            rBars[i]=findViewById(rBarIDs[i]);
        }

        Intent gIntent=getIntent();
        imgNames=gIntent.getStringArrayExtra("ImageName");
        voteResult=gIntent.getIntArrayExtra("VoteCount");
        for(int i=0; i<imgNames.length; i++){
            if(voteResult[i] > voteResult[maxEntry]){
                maxEntry=i;
            }
            tvNames[i].setText(imgNames[i]+"("+voteResult[i]+")");
            rBars[i].setRating(voteResult[i]);
        }
        tvTopName.setText(imgNames[maxEntry]);
        imgTop.setImageResource(imgTopID[maxEntry]);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });





    }
}