package com.erolkaftanoglu.fragmentdemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.erolkaftanoglu.fragmentdemo.utils.BusStation;
import com.squareup.otto.Subscribe;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    Button a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        BusStation.getBus().register(this);
        a = (Button) findViewById(R.id.button);
        a.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        AFragment a = new AFragment();
        fragmentTransaction.add(R.id.activity_main,a);
        fragmentTransaction.commit();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BusStation.getBus().unregister(this);
    }

    @Subscribe
    public void writeHello(String a){
        Log.v("OTTO", a + "world");

    }
}
