package com.tonetag.firstrun;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class PinActivity extends ActionBarActivity {
    private EditText et_pin;
    private TextView tv_inform;

    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSharedPreferences = getSharedPreferences(Controller.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if (mSharedPreferences.contains("pin")){
            setContentView(R.layout.activity_pin);
        }else{
            Intent i  = new Intent(this, ChoicePage.class);
            startActivity(i);
            finish();
        }

        et_pin = (EditText) findViewById(R.id.editText);
        tv_inform = (TextView) findViewById(R.id.textView);
    }

    public void onClick(View view){
        String pin = et_pin.getText().toString();

        String storedPin = mSharedPreferences.getString("pin","1234");

        if(TextUtils.isEmpty(pin)){
            et_pin.setError("PIN must not empty");
            return;
        }

        if(pin.equals(storedPin)){
            tv_inform.setTextColor(Color.GREEN);
            tv_inform.setText("Pin Matches");
        }else{
            tv_inform.setTextColor(Color.RED);
            tv_inform.setText("Pin doesn't match");
        }

    }
}
