package com.example.administrator.omnipotentadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listView);
        String[] strings = {"hello","world","well"};
        List<String> data = new ArrayList<>(Arrays.asList(strings));
        listView.setAdapter(new OmnipotentAdapter<String>(MainActivity.this,data,R.layout.lv_item1) {
            @Override
            public void convert(OmnipotentViewHolder holder, String item) {
                holder.setText(R.id.tv,item);
            }
        });
    }
}
