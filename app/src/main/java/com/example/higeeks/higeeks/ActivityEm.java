package com.example.higeeks.higeeks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityEm extends Activity implements View.OnClickListener {

    String EXTRA_MESSAGE = "extra_message";
    String message = "This is a message sent from Em !!!";
    Button btnToYi;
    TextView textMsgFromYi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_em);
        initLayoutComponent();
        String msgReceived = getIntent().getStringExtra(EXTRA_MESSAGE);
        if (!TextUtils.isEmpty(msgReceived)) {
            textMsgFromYi.setText(msgReceived);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnToYi:
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra(EXTRA_MESSAGE, message);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void initLayoutComponent() {

        btnToYi = (Button) findViewById(R.id.btnToYi);
        textMsgFromYi = (TextView) findViewById(R.id.textMsgFromYi);
        btnToYi.setOnClickListener(this);
    }

}
