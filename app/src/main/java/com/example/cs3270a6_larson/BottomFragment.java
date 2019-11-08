package com.example.cs3270a6_larson;


import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomFragment extends Fragment {
    View root;
    int playerOneScore = 0;
    int playerTwoScore = 0;
    int increment = 1;


    private updateScores listener;

    public void setIncrement(int value) {
        increment = value;
        Toast.makeText(getActivity().getApplicationContext(), "Increment Successfully Set", Toast.LENGTH_SHORT).show();
    }


    interface updateScores{
        void playerOneScore(int value);
        void playerTwoScore(int value);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener=(updateScores) activity;
    }


    public BottomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_bottom, container, false);

        Button addScorePlayerOne = (Button) root.findViewById(R.id.playerOneAddScore);

        addScorePlayerOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerOneScore = playerOneScore + increment;

                listener.playerOneScore(playerOneScore);



            }
        });

        Button addScorePlayerTwo = (Button) root.findViewById(R.id.playerTwoAddScore);

        addScorePlayerTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerTwoScore = playerTwoScore + increment;

                listener.playerTwoScore(playerTwoScore);


            }
        });

        final Button startTimer = (Button)root.findViewById(R.id.timerButton);

        startTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startTimer();



            }
        });

        return root;
    }


    public void startTimer() {

        final TextView textView = (TextView) root.findViewById(R.id.timerSet);



        CountDownTimer timer = new CountDownTimer(30000, 1000) {
            @Override


            public void onTick(long l) {
                textView.setText("" + l / 1000);
            }

            @Override
            public void onFinish() {
                textView.setText("Time's Up!");


            }

        }.start();




    }



}
