package com.example.uchiha.sqliteexample;

public class ContactContract {

    private  ContactContract(){}

    public static class ContactEntry{

        public static final String TABLE_NAME= "contactInfo";
        public  static  final String CONTACT_ID ="contactId";
        public  static  final String NAME="name";
        public static  final  String EMAIL="email";

    }

}
