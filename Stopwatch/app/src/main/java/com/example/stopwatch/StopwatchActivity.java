package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

public class StopwatchActivity extends AppCompatActivity {

    private int seconds=0;
    private boolean running;
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        if(savedInstanceState!=null){
            seconds=savedInstanceState.getInt("seconds");
            running=savedInstanceState.getBoolean("running");
            wasRunning=savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();
    }

    public void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        saveInstanceState.putInt("seconds",seconds);
        saveInstanceState.putBoolean("running",running);
        saveInstanceState.putBoolean("wasRunnig",wasRunning);

    }
/*
    @Override
    protected void onStop() {    //if stopwatch is running and onStop() and onStart() are overridden, app stops the stopwatch if activity gets invisible from the user.
        super.onStop();          //after it gets visible again, will automatically resume the stopwatch
        wasRunning=running;      // onStop()-->onRestart()-->onStart()-->onResume()
        running=false;

    }

    @Override
    public void onStart(){
        super.onStart();

        if(wasRunning)
            running=true;
    }
*/
    @Override
    protected void onResume() {
        super.onResume();
        if(wasRunning)
            running=true;
    }

    @Override
    protected void onPause() {  //in case activity gets destroyed(screen rotation),stopwatch stops increm.
        super.onPause();        //because running is set to false before onSaveInstanceState() gets called,so the state is saved with running as false
        wasRunning=running;
        running=false;
    }


    public void onClickStart(View view){

        running=true;
    }

    public void onClickStop(View view){

        running=false;
    }

    public void onClickReset(View view){

        running=false;
        seconds=0;
    }

    private void runTimer(){

        final TextView timeView=(TextView)findViewById(R.id.time_view);
        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours=seconds/3600;
                int minutes=(seconds%3600)/60;
                int secs=seconds%60;
                String time=String.format(Locale.getDefault(),"%d:%02d:%02d",hours,minutes,secs);
                timeView.setText(time);

                if(running){
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });

    }
}
