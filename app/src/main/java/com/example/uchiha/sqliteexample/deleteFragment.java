package com.example.uchiha.sqliteexample;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class deleteFragment extends Fragment {
private Button dbn;
private EditText Did;

    public deleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_delete, container, false);

        dbn=view.findViewById(R.id.delete_button);
        Did=view.findViewById(R.id.delete_edit_text);
        dbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String did=Did.getText().toString();
                ContactDbHelper contactDbHelper=new ContactDbHelper(getActivity());
                SQLiteDatabase db =contactDbHelper.getWritableDatabase();
                contactDbHelper.deleteContact(Integer.parseInt(did),db);
                contactDbHelper.close();
                Did.setText("");
                Toast.makeText(getActivity(),"Contact Delete Successfullly",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
