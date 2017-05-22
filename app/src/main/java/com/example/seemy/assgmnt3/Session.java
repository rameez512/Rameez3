package com.example.seemy.assgmnt3;

import android.content.Context;
import android.content.SharedPreferences;


public class Session {
SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context ctxt;

    public Session(Context ctx)
    {
        this.ctxt=ctx;
        pref = ctxt.getSharedPreferences("my app",Context.MODE_PRIVATE);
        editor=pref.edit();

    }

     public void setLoggedin(boolean loggedin){
         editor.putBoolean("loogedinmode" ,loggedin);
         editor.commit();
     }
public boolean loogedin()
{
    return pref.getBoolean("loogedinmode",false);

}



}
