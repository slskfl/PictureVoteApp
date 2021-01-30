package com.example.picturevoteapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView[] imPic=new ImageView[9];
    Button btnResult;
    int[] imPicId={R.id.imgP1, R.id.imgP2, R.id.imgP3, R.id.imgP4, R.id.imgP5, R.id.imgP6,
            R.id.imgP7, R.id.imgP8, R.id.imgP9};
    String[] imgNames={"독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀", "아래느낌 단 베르앙",
    "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들", "해변에서"};
    int[] voteCount=new int[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar bar=getSupportActionBar();
        bar.setTitle("명화 선호도 투표");
        bar.setDisplayShowHomeEnabled(true);
        btnResult=findViewById(R.id.btnResult);

        for(int i=0; i<imPicId.length; i++){
            imPic[i]=findViewById(imPicId[i]);
        }

        for(int i=0; i<imPicId.length; i++){
            final int index;
            index=i;
            imPic[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),imgNames[index]+"총"
                    +voteCount[index]+"표", Toast.LENGTH_SHORT).show();
                }
            });
        }

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("ImageName", imgNames);
                intent.putExtra("VoteCount", voteCount);
                startActivity(intent);
            }
        });
    }
}