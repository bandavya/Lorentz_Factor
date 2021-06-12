package com.example.lorentzfactor;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {
    EditText vel;
    TextView lf;
    String s;
    Integer v;
    private View view;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public boolean getNumbers() {
        //vel =(EditText ) findViewById(R.id.lorentz_input);
        s = vel.getText().toString();
        //lf = (TextView) view.findViewById(R.id.answer_output);
        if (s.equals(null)) {

            String result = "Please enter a value";
            lf.setText(result);

            return false;
        }
        else {
            // converting string to int.
            v = Integer.parseInt(vel.getText().toString());

        }

        return true;
    }

    private void lorentz(View view)
    {

        if ((getNumbers( ))) {
            int c = 300000000;

            double lfac = 1/Math.sqrt(1-(Math.pow(v, 2)/ Math.pow(c, 2)));;
            lf.setText(Double.toString(lfac));
        }
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        vel =(EditText ) view.findViewById(R.id.lorentz_input);
        lf = (TextView) view.findViewById(R.id.answer_output);
        view.findViewById(R.id.spi_value).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        view.findViewById(R.id.calc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lorentz(view);
            }
        });
    }
}