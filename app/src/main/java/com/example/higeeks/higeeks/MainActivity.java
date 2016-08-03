package com.example.higeeks.higeeks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    Button btnToEm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnToEm:
                Intent intent = new Intent(this, ActivityEm.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void initLayoutComponent() {
        btnToEm = (Button) findViewById(R.id.btnToEm);
    }
}
