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
public class updateFragment extends Fragment {

      private Button upbutton;
      private EditText Uid,Uname,Uemail;

    public updateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_update, container, false);

        upbutton=view.findViewById(R.id.update_button);
        Uid=view.findViewById(R.id.update_edit_id);
        Uname=view.findViewById(R.id.update_edit_name);
        Uemail=view.findViewById(R.id.update_edit_email);

        upbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uid=Uid.getText().toString();
                String uname=Uname.getText().toString();
                String uemail=Uemail.getText().toString();
                ContactDbHelper contactDbHelper=new ContactDbHelper(getActivity());
                SQLiteDatabase db =contactDbHelper.getWritableDatabase();
                contactDbHelper.updateContact(Integer.parseInt(uid),uname,uemail,db);
                contactDbHelper.close();
                Uid.setText("");
                Uname.setText("");
                Uemail.setText("");
                Toast.makeText(getActivity(),"contact update successfully",Toast.LENGTH_SHORT).show();


            }
        });


        return view;
    }

}
