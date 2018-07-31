package com.example.uchiha.sqliteexample;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadContactFragment extends Fragment {

    private TextView textView;
    public ReadContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_read_contact, container, false);
           textView=view.findViewById(R.id.readtext);

            readContact();

        return view;
    }

    private void readContact()
    {
        ContactDbHelper contactDbHelper=new ContactDbHelper(getActivity());
        SQLiteDatabase db= contactDbHelper.getReadableDatabase();
        Cursor cursor=contactDbHelper.readContact(db);
        String info="";
        while(cursor.moveToNext()){

            String id=Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContract.ContactEntry.CONTACT_ID)));
            String name =cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.NAME));
            String email= cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.EMAIL));


            info= info+"\n\n" + "Id : "+id+"\n\n"+"Name :"+name+"\n\n"+"Email :"+ email;

        }
        textView.setText(info);
        contactDbHelper.close();

    }
}
