package com.nutsinc.ribbit;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Ali on 5/26/15.
 */
public class RibbitApplication extends Application {



    @Override
    public void onCreate(){
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "QuTEzDibsN70PKfRCdN3waFzzlQBdw3nceWnYJzs", "AkTwoM1uFJ6oGkOTd8V2HzHFfGBWTsoZD0vac3Hn");
    }
}
