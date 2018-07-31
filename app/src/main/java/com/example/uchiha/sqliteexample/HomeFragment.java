package com.example.uchiha.sqliteexample;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
     private Button bnadd,bnupdate,bndelete,bnview;
     OnDbOpListner ondbopListner;
    public HomeFragment() {
        // Required empty public constructor
    }

    public  interface OnDbOpListner{

            public void dbopPerform(int method);
    }


    Button getBnview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    View view= inflater.inflate(R.layout.fragment_home, container, false);
    bnadd=view.findViewById(R.id.addbutton);
    bnview=view.findViewById(R.id.viewbutton);
    bnupdate=view.findViewById(R.id.updatebutton);
    bndelete=view.findViewById(R.id.deletebutton);
    bnupdate.setOnClickListener(this);
    bnadd.setOnClickListener(this);
    bnview.setOnClickListener(this);
    bndelete.setOnClickListener(this);


    return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.addbutton:
                ondbopListner.dbopPerform(0);
                break;

            case R.id.viewbutton:
                ondbopListner.dbopPerform(1);
                break;

            case R.id.updatebutton:
                ondbopListner.dbopPerform(2);
                break;
            case R.id.deletebutton:
                ondbopListner.dbopPerform(3);
                break;

        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity=(Activity) context;
        try {
            ondbopListner = (OnDbOpListner) activity;
        }
        catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+"must implement the interface method");
        }
    }
}
