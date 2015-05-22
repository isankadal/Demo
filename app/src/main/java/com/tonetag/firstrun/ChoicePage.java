package com.tonetag.firstrun;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class ChoicePage extends ActionBarActivity {
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_page);

        mSharedPreferences = getSharedPreferences(Controller.SHARED_PREF_NAME, Context.MODE_PRIVATE);


    }

    public void onClick(View view){

        switch (view.getId()){
            case R.id.btn_reg:
                Toast.makeText(this,"Register page invocation todo", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_reset:
                SharedPreferences.Editor editor = mSharedPreferences.edit();
                editor.putString("pin", "1234");
                editor.commit();

                Toast.makeText(this,"pin resets to 1234", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(this, PinActivity.class);
                startActivity(i);
                finish();
                break;
        }

    }
}
