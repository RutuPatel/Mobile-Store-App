package com.example.assignment5;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public class PhoneFragment extends Fragment {

    View v;
    private ArrayList<ModelPhone> PhoneList ;
    private  RecyclerView  recyclerView;

    public  PhoneFragment(){

    }




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_new_phone,container,false);
        recyclerView =(RecyclerView) v.findViewById(R.id.phone_recyclerView);
        PhoneAdapter phoneAdapter = new PhoneAdapter(getContext(),PhoneList);
        recyclerView.setLayoutManager( new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(phoneAdapter);


        return v;



    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PhoneList = new ArrayList<>();
        PhoneList.add( new ModelPhone(R.drawable.phone,"Iphone 6s", "64 GB","$ 450"));
        PhoneList.add( new ModelPhone(R.drawable.pixel,"Pixel 3XL", "128 GB","$ 1450"));
        PhoneList.add( new ModelPhone(R.drawable.note9,"Note 9", "64 GB","$ 950"));
        PhoneList.add( new ModelPhone(R.drawable.iphonexsmax,"Iphone XS Max", "256 Gb","$ 1650"));
        PhoneList.add( new ModelPhone(R.drawable.s10,"Samsung Galaxy s10+", "64 GB","$ 1550"));
        PhoneList.add( new ModelPhone(R.drawable.phone,"Iphone 6s", "64 GB","$ 450"));
        PhoneList.add( new ModelPhone(R.drawable.pixel,"Pixel 3XL", "128 GB","$ 1450"));
        PhoneList.add( new ModelPhone(R.drawable.note9,"Note 9", "64 GB","$ 950"));
        PhoneList.add( new ModelPhone(R.drawable.iphonexsmax,"Iphone XS Max", "256 Gb","$ 1650"));
        PhoneList.add( new ModelPhone(R.drawable.s10,"Samsung Galaxy s10+", "64 GB","$ 1550"));




    }


}
