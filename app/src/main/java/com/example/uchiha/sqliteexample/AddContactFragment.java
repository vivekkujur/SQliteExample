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
public class AddContactFragment extends Fragment {

private Button bnsave;
EditText eid,ename,eemail;
    public AddContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_contact, container, false);

        bnsave=view.findViewById(R.id.save_button);
        eid=view.findViewById(R.id.update_edit_id);
        ename=view.findViewById(R.id.update_edit_name);
        eemail=view.findViewById(R.id.update_edit_email);

        bnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Eid= eid.getText().toString();
                String Ename=ename.getText().toString();
                String Eemail=eemail.getText().toString();

                ContactDbHelper contactDbHelper=new ContactDbHelper(getActivity());
                SQLiteDatabase database= contactDbHelper.getWritableDatabase();
                contactDbHelper.addContact(Integer.parseInt(Eid),Ename,Eemail,database);
                contactDbHelper.close();
                eid.setText("");
                ename.setText("");
                eemail.setText("");
                Toast.makeText(getActivity(),"contact save successfully",Toast.LENGTH_SHORT).show();




            }
        });


      return  view;
    }

}
