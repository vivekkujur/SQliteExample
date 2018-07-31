package com.example.uchiha.sqliteexample;

import android.app.Activity;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnDbOpListner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragmentContainer)!=null){


            if(savedInstanceState!=null){
                return;
            }

            HomeFragment homeFragment=new HomeFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer,homeFragment).commit();
        }
    }


    @Override
    public void dbopPerform(int method) {

        switch (method){

            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new AddContactFragment()).addToBackStack(null).commit();
                break;

            case 1 :
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new ReadContactFragment() ).addToBackStack(null).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new updateFragment()).addToBackStack(null).commit();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new deleteFragment()).addToBackStack(null).commit();
        }
    }
}
