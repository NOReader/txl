package com.example.hj.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;


public class send extends ActionBarActivity {
    private EditText phone;
    private EditText smstxt;
    private ImageView send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        phone= (EditText) findViewById(R.id.phone);
        send= (ImageView) findViewById(R.id.send);
        smstxt= (EditText) findViewById(R.id.smstxt);
        Intent intent=getIntent();
        phone.setText(intent.getStringExtra("phone"));
        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String phone_number =phone.getText().toString();
                String sms_content = smstxt.getText().toString();
                SmsManager smsManager = SmsManager.getDefault();
                List<String> contents = smsManager.divideMessage(sms_content);
                for (String text : contents) {
                    smsManager.sendTextMessage(phone_number, null, text, null, null);
                }
                Toast.makeText(send.this,"发送成功",Toast.LENGTH_SHORT).show();
                smstxt.setText(null);
                }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_send, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
