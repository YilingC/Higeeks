package com.example.higeeks.higeeks;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    static final String TAG = MainActivity.class.getSimpleName();
    static final String EXTRA_MESSAGE = "extra_message";
    static final String ACTION_Activity_EM = "com.example.higeeks.higeeks.action.ActivityEm";
    static final int NOTIFICATION_ID = 1000;
    String message = "This is a message sent from Yi !!!";
    Button btnToEm, btnNotify;
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
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case R.id.btnNotify:
                pushNotification();
                break;
            default:
                break;
        }
    }

    public void initLayoutComponent() {

        btnToEm = (Button) findViewById(R.id.btnToEm);
        textMsgFromEm = (TextView) findViewById(R.id.textMsgFromEm);
        btnToEm.setOnClickListener(this);
        btnNotify = (Button) findViewById(R.id.btnNotify);
        btnNotify.setOnClickListener(this);

    }

    protected void pushNotification() {

        Log.i(TAG, "push notification");
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent = new Intent(ACTION_Activity_EM);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentIntent(pendingIntent)
        .setContentText("hi, i am message")
        .setContentTitle("You've got a message")
        .setSmallIcon(R.mipmap.ic_launcher);

        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    protected void test() {}
}
