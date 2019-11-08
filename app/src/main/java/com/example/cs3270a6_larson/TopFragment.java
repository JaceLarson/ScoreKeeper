package com.example.cs3270a6_larson;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {
    View root;


    public TopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_top, container, false);

        EditText editTextPlayerOne = (EditText)root.findViewById(R.id.setNamePlayerOne);
        EditText editTextPlayerTwo = (EditText)root.findViewById(R.id.setNamePlayerTwo);

        editTextPlayerOne.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {



            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {



            }

            @Override
            public void afterTextChanged(Editable editable) {
                Toast.makeText(getActivity().getApplicationContext(), "Enter Player One Name", Toast.LENGTH_SHORT).show();

            }


        });

        editTextPlayerTwo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
                Toast.makeText(getActivity().getApplicationContext(), "Enter Player Two Name", Toast.LENGTH_SHORT).show();

            }

        });



        return root;
    }

    public void playerOneScore(int value) {
        TextView textView = (TextView)root.findViewById(R.id.playerOneScoretxt);
        textView.setText(String.valueOf(value));
    }

    public void playerTwoScore(int value) {
        TextView textView = (TextView)root.findViewById(R.id.playerTwoScoretxt);
        textView.setText(String.valueOf(value));
    }

    public void setCountSeek1Value (int value) {
        SeekBar seekBar = (SeekBar)root.findViewById(R.id.seekBar1);
        seekBar.setProgress(value);
    }

    public void setCountSeek2Value (int value) {
        SeekBar seekBar = (SeekBar)root.findViewById(R.id.seekBar2);
        seekBar.setProgress(value);
    }





}
