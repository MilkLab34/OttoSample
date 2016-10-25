package com.erolkaftanoglu.fragmentdemo.utils;

import com.squareup.otto.Bus;

/**
 * Created by erol on 25.10.2016.
 */

public class BusStation {
    static Bus bus = new Bus();

    public static Bus getBus(){
        return bus;
    }
}
