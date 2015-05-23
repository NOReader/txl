package com.example.hj.myapplication;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class sms extends Fragment implements View.OnClickListener {
    int[]res={R.id.a,R.id.b,R.id.c,R.id.d,R.id.e,R.id.f,R.id.g};
    List<ImageView>list=new ArrayList<>();
    List<Map<String,Object>>smslist;
    boolean flag=false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_sms,container,false);
        for(int i=0;i<res.length;i++)
        {
            ImageView imageView= (ImageView) view.findViewById(res[i]);
            imageView.setOnClickListener(this);
            list.add(imageView);
        }
        smslist=new ArrayList<>();
        ListView listView= (ListView) view.findViewById(R.id.smslist);
        SimpleAdapter simpleAdaptersms=new SimpleAdapter(getActivity(),getDatalist(),R.layout.item,new String[]{"img","txt","context"},new int[]{R.id.img,R.id.txt,R.id.context});
        listView.setAdapter(simpleAdaptersms);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getActivity(),send.class));
            }
        });

        return  view;
    }
    public List<Map<String,Object>> getDatalist()
    {

        for(int i=1;i<20;i++)
        {
            Map<String,Object> map=new HashMap<>();
            map.put("img",R.drawable.sms);
            map.put("txt", "短信" + i);
            map.put("context","这是一条很长很长的短信，不服你来咬我");
            smslist.add(map);
        }
        return  smslist;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.a:
            {
                if(flag)
                {
                    closeanim();
                }
                else startanim();
                break;
            }
            case R.id.f:
            {
                startActivity(new Intent(getActivity(),send.class));
            }
        }
    }

    private void closeanim() {
        for(int i=0;i<res.length-1;i++)
        {
            ObjectAnimator animator=ObjectAnimator.ofFloat(list.get(i),"translationY",i*-150,0).setDuration(500);
            animator.start();
            flag=false;
        }
    }

    private void startanim() {
        for(int i=0;i<res.length-1;i++)
        {
            ObjectAnimator animator=ObjectAnimator.ofFloat(list.get(i),"translationY",0f,i*-150).setDuration(500);
            animator.start();
            flag=true;
        }
    }
}
