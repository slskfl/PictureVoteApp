package com.example.picturevoteapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class SortActivity extends AppCompatActivity {

    Button btnStart, btnStop;
    ViewFlipper vFlipper;
    TextView tvRank[]=new TextView[9];
    int tvRankIDs[]={R.id.tvRank1, R.id.tvRank2, R.id.tvRank3, R.id.tvRank4, R.id.tvRank5,
            R.id.tvRank6, R.id.tvRank7, R.id.tvRank8, R.id.tvRank9};
    ImageView imgVs[]=new ImageView[9];
    int imgVIDs[]={R.id.imgV1, R.id.imgV2, R.id.imgV3, R.id.imgV4, R.id.imgV5,
            R.id.imgV6, R.id.imgV7, R.id.imgV8, R.id.imgV9 };
    TextView tvNames[]=new TextView[9];
    int tvNameIDs[]={R.id.tvName1, R.id.tvName2, R.id.tvName3, R.id.tvName4, R.id.tvName5,
            R.id.tvName6, R.id.tvName7, R.id.tvName8, R.id.tvName9};
    int[] imPicId={R.id.imgP1, R.id.imgP2, R.id.imgP3, R.id.imgP4, R.id.imgP5, R.id.imgP6,
            R.id.imgP7, R.id.imgP8, R.id.imgP9};
    String imgNames[];
    int voteResult[];
    int temp;
    String tempStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);

        ActionBar bar=getSupportActionBar();
        bar.setTitle("투표 결과 (뷰플리퍼활용)");
        bar.setDisplayHomeAsUpEnabled(true);

        btnStop=findViewById(R.id.btnStop);
        btnStart=findViewById(R.id.btnStart);
        vFlipper=findViewById(R.id.vFlipper);

        for(int i=0; i<imgVIDs.length; i++){
            tvRank[i]=findViewById(tvRankIDs[i]);
            imgVs[i]=findViewById(imgVIDs[i]);
            tvNames[i]=findViewById(tvNameIDs[i]);
        }
        vFlipper.setFlipInterval(2000);
        Intent gIntent=getIntent();
        imgNames=gIntent.getStringArrayExtra("ImageName");
        voteResult=gIntent.getIntArrayExtra("VoteCount");

        //소트 알고리즘을 수행
        for(int a=0; a<imgNames.length-1; a++){
            for(int b=a+1; b<imgNames.length; b++){
                temp=voteResult[a];
                voteResult[a]=voteResult[b];
                voteResult[b]=temp;
                tempStr=imgNames[a];
                imgNames[a]=imgNames[b];
                imgNames[b]=tempStr;
                temp=imgVIDs[a];
                imgVIDs[a]=imgVIDs[b];
                imgVIDs[b]=temp;
            }
        }
        for(int i=0; i<imgVIDs.length; i++){
            tvRank[i].setText((i+1)+"등");
            imgVs[i].setImageResource(imPicId[i]);
            tvNames[i].setText(imgNames[i]+"(총"+voteResult+")");
        }
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.startFlipping();;
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.stopFlipping();
            }
        });
    }
}