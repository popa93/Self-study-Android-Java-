package com.example.starbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);

        ArrayAdapter<Drink> listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,Drink.drinks);  //adapter uses toString(Drink.java) method to return the name of each drink
        ListView listDrinks=findViewById(R.id.list_drinks);
        listDrinks.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener=new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    Intent intent=new Intent(DrinkCategoryActivity.this,DrinkActivity.class);
                    intent.putExtra(DrinkActivity.EXTRA_DRINKID,(int)id);   //if will not cast id from long to int will get nullpointerexception on line 18 in DrinkActivity
                    startActivity(intent);
            }
        };

        listDrinks.setOnItemClickListener(itemClickListener);


    }
}
