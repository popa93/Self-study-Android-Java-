package com.example.starbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TopLevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);

        AdapterView.OnItemClickListener itemClickListener=new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) { //1 param=the view that was clicked(listview)
                                                                                                    //2 param=which view from list was clicked
                if(position==0){                                                                    //3 param=position of click view in the list
                    Intent intent=new Intent(TopLevelActivity.this,DrinkCategoryActivity.class);                   //4 param=row ID of the underlying data
                    startActivity(intent);

                }
            }
        };

        ListView listView=(ListView)findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);
    }

}
