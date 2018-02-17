package com.example.administrator.newyear;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by Administrator on 2018/2/17.
 */

public class TestFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_test, container, false);
        myTosat(view.toString(),LENGTH_LONG);
        return view;
    }
    Toast toast;



    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.button).setOnClickListener(onClickListener);
        view.findViewById(R.id.button2).setOnClickListener(onClickListener);
        ((EditText)view.findViewById(R.id.edit_text_text_1)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("TestFragment", "beforeTextChanged"+ " "+s + " " + start +" "+count + " " +after);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("TestFragment", "onTextChanged"+ " "+s + " " + start +" " +before + " " +count);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("TestFragment", "afterTextChanged"+ " "+s + " ");
            }
        });
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            myTosat("button" + v,LENGTH_LONG);
        }
    };

    public void myTosat(String string, int length){
        if(toast!=null){
            toast.cancel();
        }
        toast= Toast.makeText(getActivity(), string, length);
        toast.show();
    }
}
