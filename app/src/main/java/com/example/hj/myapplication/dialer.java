package com.example.hj.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class dialer extends Fragment implements View.OnClickListener,View.OnTouchListener {
    TextView editText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_dialer,container,false);
        LinearLayout bt1= (LinearLayout) view.findViewById(R.id.bt1);
        LinearLayout bt2= (LinearLayout) view.findViewById(R.id.bt2);
        LinearLayout bt3= (LinearLayout) view.findViewById(R.id.bt3);
        LinearLayout bt4= (LinearLayout) view.findViewById(R.id.bt4);
        LinearLayout bt5= (LinearLayout) view.findViewById(R.id.bt5);
        LinearLayout bt6= (LinearLayout) view.findViewById(R.id.bt6);
        LinearLayout bt7= (LinearLayout) view.findViewById(R.id.bt7);
        LinearLayout bt8= (LinearLayout) view.findViewById(R.id.bt8);
        LinearLayout bt9= (LinearLayout) view.findViewById(R.id.bt9);
        LinearLayout bt10= (LinearLayout) view.findViewById(R.id.bt10);
        LinearLayout bt11= (LinearLayout) view.findViewById(R.id.bt11);
        LinearLayout bt12= (LinearLayout) view.findViewById(R.id.bt12);
        LinearLayout bt13= (LinearLayout) view.findViewById(R.id.bt13);
        LinearLayout bt14= (LinearLayout) view.findViewById(R.id.bt14);
        LinearLayout bt15= (LinearLayout) view.findViewById(R.id.bt15);
        editText= (TextView) view.findViewById(R.id.edittext);
        LinearLayout del= (LinearLayout) view.findViewById(R.id.del);
        bt1.setOnClickListener(this);
        bt1.setOnTouchListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        bt10.setOnClickListener(this);
        bt11.setOnClickListener(this);
        bt12.setOnClickListener(this);
        bt13.setOnClickListener(this);
        bt14.setOnClickListener(this);
        bt15.setOnClickListener(this);
        del.setOnClickListener(this);
        del.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                editText.setText(null);
                return  false;
            }
        });
        return view;
    }

    @Override
    public void onClick(View view) {
        String str=editText.getText().toString();
        switch (view.getId()) {
            case R.id.bt1:
                str += "1";
                editText.setText(str);
                break;
            case R.id.bt2:
                str += "2";
                editText.setText(str);
                break;
            case R.id.bt3:
                str += "3";
                editText.setText(str);
                break;
            case R.id.bt4:
                str += "4";
                editText.setText(str);
                break;
            case R.id.bt5:
                str += "5";
                editText.setText(str);
                break;
            case R.id.bt6:
                str += "6";
                editText.setText(str);
                break;
            case R.id.bt7:
                str += "7";
                editText.setText(str);
                break;
            case R.id.bt8:
                str += "8";
                editText.setText(str);
                break;
            case R.id.bt9:
                str += "9";
                editText.setText(str);
                break;
            case R.id.bt10:
                str += "*";
                editText.setText(str);
                break;
            case R.id.bt11:
                str += "0";
                editText.setText(str);
                break;
            case R.id.bt12:
                str += "#";
                editText.setText(str);
                break;
            case R.id.bt13: {
                if(editText.getText()!=null)
                {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + editText.getText()));
                    startActivity(intent);
                }
            }
            case R.id.del: {
                try {
                    editText.setText(str.substring(0, str.length()-1));
                } catch (Exception e) {
                    editText.setText("");
                }

                break;
                }

            }
        }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
            //更改为按下时的背景图片
            view.setBackgroundColor(Color.GRAY);
        }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
            view.setBackgroundColor(Color.WHITE);}
            return false;
    }
}
