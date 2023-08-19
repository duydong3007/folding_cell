package com.example.foldingcell_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvview;

    private itemobject_adapter itemobject_adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvview=findViewById(R.id.rcvview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rcvview.setLayoutManager(linearLayoutManager);
        itemobject_adapter=new itemobject_adapter();

        itemobject_adapter.setdata(getdata());
        rcvview.setAdapter(itemobject_adapter);
    }

    private List<itemobject> getdata() {
        List<itemobject> list=new ArrayList<>();
        for (int i=0;i<20;i++){
            list.add(new itemobject("title"+i,"content"+i));
        }

        return list;
    }
}