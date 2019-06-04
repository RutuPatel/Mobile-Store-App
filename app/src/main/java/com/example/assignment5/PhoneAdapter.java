package com.example.assignment5;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.ViewHolder> {


    private ArrayList<ModelPhone> mlist;
    private Context mcontext;





    public PhoneAdapter(Context context , ArrayList<ModelPhone> list) {

        mcontext = context;
        mlist =list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(mcontext);
        final View view= layoutInflater.inflate(R.layout.layout_phone,viewGroup,false);

        final ViewHolder viewHolder = new ViewHolder(view);



        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {



        final ModelPhone phoneItem = mlist.get(i);

        ImageView image = viewHolder.Item_image;
        final TextView name = viewHolder.Item_name;
        TextView text = viewHolder.Item_text;
        TextView price =  viewHolder.Item_price;

        image.setImageResource(phoneItem.getImage());
        name.setText(phoneItem.getName());
        text.setText(phoneItem.getText());
        price.setText(phoneItem.getPrice());

        viewHolder.item_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext,"test "+String.valueOf(phoneItem.getName()),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mcontext,DetailActivity.class);
                intent.putExtra("name",phoneItem.getName());
                intent.putExtra("price",phoneItem.getPrice());
                intent.putExtra("text",phoneItem.getText());

                mcontext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public  class  ViewHolder extends  RecyclerView.ViewHolder{

        CardView item_phone;
        ImageView Item_image;
        TextView Item_name,Item_text, Item_price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_phone =(CardView) itemView.findViewById(R.id.phone_item);
            Item_image = itemView.findViewById(R.id.item_image);
            Item_name =itemView.findViewById(R.id.item_name);
            Item_text = itemView.findViewById(R.id.item_text);
            Item_price = itemView.findViewById(R.id.item_price);


        }
    }
}
