package com.example.workout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class WorkoutDetailFragment extends Fragment {

    private long workoutId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState!=null)
            workoutId=savedInstanceState.getLong("workoutId");
    }

    @Override
    public void onStart() {
        super.onStart();
        View view=getView();// gets the root View of the fragment. the one returned by onCreateView
        TextView title=(TextView)view.findViewById(R.id.textTitle);
        Workout workout=Workout.workouts[(int)workoutId];
        title.setText(workout.getName());
        TextView description=(TextView)view.findViewById(R.id.textDescription);
        description.setText(workout.getDescription());
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putLong("workoutId",workoutId);
    }

    public void setWorkout(long id){
        workoutId=id;
    }
}
