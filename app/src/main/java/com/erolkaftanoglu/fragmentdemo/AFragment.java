package com.erolkaftanoglu.fragmentdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.erolkaftanoglu.fragmentdemo.utils.BusStation;

/**
 * Created by erol on 25.10.2016.
 */

public class AFragment extends Fragment implements View.OnClickListener{


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BusStation.getBus().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_a,container,false);
        Button b = (Button) root.findViewById(R.id.fragmentbutton);
        b.setOnClickListener(this);
        TextView c = (TextView) root.findViewById(R.id.textviewfragment);

        return root;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        BusStation.getBus().unregister(this);
    }

    @Override
    public void onClick(View view) {
        BusStation.getBus().post("Ben Fragment");
    }
}
