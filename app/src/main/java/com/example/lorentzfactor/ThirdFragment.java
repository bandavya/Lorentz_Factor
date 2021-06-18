package com.example.lorentzfactor;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.fragment.NavHostFragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdFragment extends Fragment {

/*
    public void asd() {
        if (getActivity() == null) {
            Log.d("yes","it is null");
        }
    }
    protected FragmentActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Activity){
            mActivity =(FragmentActivity) context;
        }
    }

 */
    //Context context = getActivity();
    //SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);

    //SharedPreferences sharedPref = mActivity.getSharedPreferences("bandfile",Context.MODE_PRIVATE);
    //SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    //SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());
    //String url = sharedPref.getString("url", "n/a");
    //static SharedPreferences prefs;
    //Context context;
    //SharedPreferences sharedPref = mContext.getSharedPreferences("bandfile",Context.MODE_PRIVATE);
    //public static SharedPreferences getPrefs(Context context){
    //    return context.getSharedPreferences("bandfile",Context.MODE_PRIVATE);
    //}

    public ThirdFragment() {
        // Required empty public constructor
    }






    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThirdFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThirdFragment newInstance(String param1, String param2) {
        ThirdFragment fragment = new ThirdFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    EditText enterLF, enterVel;
    Button btnSave;
    View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    public void addValues(View view){
        String givenLorentzFactor = enterLF.getText().toString();
        String givenVelocity = enterVel.getText().toString();

        // return if the input fields are blank
        if (TextUtils.isEmpty(givenLorentzFactor) && TextUtils.isEmpty(givenVelocity)) {
            return;
        }
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        enterLF = (EditText) view.findViewById(R.id.enter_lf);
        enterVel = (EditText) view.findViewById(R.id.enter_vel);
        btnSave = (Button) view.findViewById(R.id.save_button);

        view.findViewById(R.id.save_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addValues(view);
                Toast myToast = Toast.makeText(getActivity(),
                        "DATA:  " + enterLF.getText() + "  vel: " + enterVel.getText() ,
                        Toast.LENGTH_LONG);
                myToast.show();
      /*
                //SharedPreferences.Editor editor=getPrefs(context).edit();
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString(String.valueOf(enterLF.getText()), String.valueOf(enterVel.getText()));
                editor.apply();

       */



            }
        });
        view.findViewById(R.id.back_to_lf).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_thirdFragment_to_FirstFragment);
            }
        });

    }

}