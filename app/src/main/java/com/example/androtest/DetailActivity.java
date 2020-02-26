package com.example.androtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        Intent myIntent = getIntent();
        String nom = myIntent.getStringExtra(MyAdapter.EXTRA_NOM);
        String tel = myIntent.getStringExtra(MyAdapter.EXTRA_TEL);
        String desc = myIntent.getStringExtra(MyAdapter.EXTRA_DESCRIPTION);

        TextView textView = findViewById(R.id.textView2);
        textView.setText(nom);

        TextView textView1 = findViewById(R.id.textView4);
        textView1.setText(tel);

        ImageView iv = (ImageView) findViewById(R.id.imageView2);
        iv.setImageResource(Integer.parseInt(desc));

    }
}
