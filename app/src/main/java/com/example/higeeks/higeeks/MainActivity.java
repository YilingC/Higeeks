package com.example.higeeks.higeeks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    String EXTRA_MESSAGE = "extra_message";
    String message = "This is a message sent from Yi !!!";
    Button btnToEm;
    TextView textMsgFromEm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayoutComponent();
        String msgReceived = getIntent().getStringExtra(EXTRA_MESSAGE);
        if (!TextUtils.isEmpty(msgReceived)) {
            textMsgFromEm.setText(msgReceived);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnToEm:
                Intent intent = new Intent(this, ActivityEm.class);
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void initLayoutComponent() {

        btnToEm = (Button) findViewById(R.id.btnToEm);
        textMsgFromEm = (TextView) findViewById(R.id.textMsgFromEm);
    }
}
