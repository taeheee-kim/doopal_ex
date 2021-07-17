package com.cookandroid.splash_pleazz;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Faq_test extends AppCompatActivity {

    private Context mContext;
    private RecyclerView recyclerview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faq_test);
        this.mContext = getApplicationContext();

        recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        List<Faq_test_Adapter.Item> data = new ArrayList<>();

//        data.add(new Faq_test_Adapter.Item(Faq_test_Adapter.HEADER, "Fruits"));
//        data.add(new Faq_test_Adapter.Item(Faq_test_Adapter.CHILD, "Apple"));
//        data.add(new Faq_test_Adapter.Item(Faq_test_Adapter.CHILD, "Orange"));
//        data.add(new Faq_test_Adapter.Item(Faq_test_Adapter.CHILD, "Banana"));
//        data.add(new Faq_test_Adapter.Item(Faq_test_Adapter.HEADER, "Cars"));
//        data.add(new Faq_test_Adapter.Item(Faq_test_Adapter.CHILD, "Audi"));
//        data.add(new Faq_test_Adapter.Item(Faq_test_Adapter.CHILD, "Aston Martin"));
//        data.add(new Faq_test_Adapter.Item(Faq_test_Adapter.CHILD, "BMW"));
//        data.add(new Faq_test_Adapter.Item(Faq_test_Adapter.CHILD, "Cadillac"));

        Faq_test_Adapter.Item Q1 = new Faq_test_Adapter.Item(Faq_test_Adapter.HEADER, "Q1: 곽두팔에 대해 설명해 주세요");
        Q1.invisibleChildren = new ArrayList<>();
        Q1.invisibleChildren.add(new Faq_test_Adapter.Item(Faq_test_Adapter.CHILD, "곽두팔은 ~~서비스 입니다."));


        Faq_test_Adapter.Item Q2 = new Faq_test_Adapter.Item(Faq_test_Adapter.HEADER, "Q2");
        Q2.invisibleChildren = new ArrayList<>();
        Q2.invisibleChildren.add(new Faq_test_Adapter.Item(Faq_test_Adapter.CHILD, "A2"));


        Faq_test_Adapter.Item Q3 = new Faq_test_Adapter.Item(Faq_test_Adapter.HEADER, "Q3");
        Q3.invisibleChildren = new ArrayList<>();
        Q3.invisibleChildren.add(new Faq_test_Adapter.Item(Faq_test_Adapter.CHILD, "A3"));


        Faq_test_Adapter.Item Q4 = new Faq_test_Adapter.Item(Faq_test_Adapter.HEADER, "Q4");
        Q4.invisibleChildren = new ArrayList<>();
        Q4.invisibleChildren.add(new Faq_test_Adapter.Item(Faq_test_Adapter.CHILD, "A4"));


        Faq_test_Adapter.Item Q5 = new Faq_test_Adapter.Item(Faq_test_Adapter.HEADER, "Q5");
        Q5.invisibleChildren = new ArrayList<>();
        Q5.invisibleChildren.add(new Faq_test_Adapter.Item(Faq_test_Adapter.CHILD, "A5"));


        Faq_test_Adapter.Item Q6 = new Faq_test_Adapter.Item(Faq_test_Adapter.HEADER, "Q6");
        Q6.invisibleChildren = new ArrayList<>();
        Q6.invisibleChildren.add(new Faq_test_Adapter.Item(Faq_test_Adapter.CHILD, "A6"));




        data.add(Q1);
        data.add(Q2);
        data.add(Q3);
        data.add(Q4);
        data.add(Q5);
        data.add(Q6);


        recyclerview.setAdapter(new Faq_test_Adapter(data));
    }


}
