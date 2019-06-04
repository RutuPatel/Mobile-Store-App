package com.example.assignment5;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView T1,T2,T3;
    Button checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        T1 =(TextView) findViewById(R.id.Name);
        T2 =(TextView) findViewById(R.id.Text);
        T3 =(TextView) findViewById(R.id.Price);
        checkout =(Button) findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this,PaymentActivity.class);
                startActivity(intent);
            }
        });




        String Text =  getIntent().getStringExtra("text");
        String Price = getIntent().getStringExtra("price");
        String Name= getIntent().getStringExtra("name");


        T1.setText(Name);
        T2.setText(Text);
        T3.setText(Price);
    }
}
