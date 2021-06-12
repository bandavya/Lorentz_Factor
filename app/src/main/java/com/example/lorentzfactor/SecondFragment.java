package com.example.lorentzfactor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Calendar;
import java.util.TimeZone;
import java.lang.Math;

public class SecondFragment extends Fragment {
    TextView spi_tv;

    public static double fact(double n) {
        if (n <= 1)
            return 1;
        else
            return n * fact(n - 1);
    }

    public void main1() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("IST"));
        /* System.out.println("Hour = " + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("Minute = " + cal.get(Calendar.MINUTE));
        System.out.println("Second = " + cal.get(Calendar.SECOND));
        System.out.println("Millisecond = " + cal.get(Calendar.MILLISECOND));

         */

        double spi, th, tm, ts;
        ts = cal.get(Calendar.SECOND);
        tm = cal.get(Calendar.MINUTE);
        th = cal.get(Calendar.HOUR_OF_DAY);
        spi = fact(th)/ (Math.pow(tm, 3) + ts);
        spi_tv.setText(Double.toString(spi));

    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        spi_tv = (TextView) view.findViewById(R.id.spi_factor);

        view.findViewById(R.id.button_prev).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
        view.findViewById(R.id.display_spi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main1();
            }
        });
    }
}