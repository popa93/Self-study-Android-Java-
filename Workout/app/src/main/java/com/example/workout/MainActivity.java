package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id) {

        View fragmentContainer=findViewById(R.id.fragment_container);   //if app runs on table will not be null, else null
                                                                        //device auto selects layout(layout/layout-large) based on the device screen size

        if(fragmentContainer!=null){    //tablet case
            WorkoutDetailFragment details=new WorkoutDetailFragment();

            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            details.setWorkout(id);
            transaction.replace(R.id.fragment_container,details);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.addToBackStack(null);
            transaction.commit();


        }else {
            Intent intent = new Intent(this, DetailActivity.class); //phone case
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int) id);
            startActivity(intent);
        }
    }
}
