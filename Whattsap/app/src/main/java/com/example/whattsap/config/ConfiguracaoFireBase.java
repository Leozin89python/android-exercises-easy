package com.example.whattsap.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfiguracaoFireBase
{

    private static DatabaseReference database;
    private static FirebaseAuth auth;

    //metodo para retornar a instancia do firebasedatabase
    public static DatabaseReference getFirebaseDatabase()
    {
        if(database == null)
        {
            database = FirebaseDatabase.getInstance().getReference();
        }
        return database;
    }

    //metodo para retornar a instancia do firebaseauth

    public static FirebaseAuth getFirebaseAuth()
    {
        if(auth == null)
        {
            auth = FirebaseAuth.getInstance();
        }
        return auth;
    }
}
