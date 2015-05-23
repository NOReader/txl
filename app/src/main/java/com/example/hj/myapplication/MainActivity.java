package com.example.hj.myapplication;

import android.content.Intent;
import android.gesture.GestureOverlayView;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.TextureView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity {
    GestureDetector mGestureDetector;
    FragmentPagerAdapter fragmentPagerAdapter;
    ViewPager viewPager;
    TextView st;
    TextView dt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                if (Math.abs(velocityY) < 100) {
                    return true;
                }
                if ((e2.getRawY() - e1.getRawY()) > 200) {
                    startActivity(new Intent(MainActivity.this,contact.class));
                    overridePendingTransition(R.anim.slide_up_in, R.anim.slide_up_out);
                    return true;
                }
                if ((e1.getRawY() - e2.getRawY()) > 200) {
                    return true;
                }
                return super.onFling(e1, e2, velocityX, velocityY);
            }
        });
        initviewpager();
    }

    private void initviewpager() {
        dt= (TextView) findViewById(R.id.dt);
        st= (TextView) findViewById(R.id.st);
        final List<Fragment>fdata =new ArrayList<>();
        dialer dialer=new dialer();
        sms sms=new sms();
        fdata.add(dialer);
        fdata.add(sms);
        viewPager= (ViewPager) findViewById(R.id.viewp);
        fragmentPagerAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fdata.get(position);
            }

            @Override
            public int getCount() {
                return fdata.size();
            }
        };
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                dt.setTextColor(Color.BLACK);
                st.setTextColor(Color.BLACK);
                switch (position)
                {
                    case 0:
                    {
                        dt.setTextColor(Color.WHITE);
                        break;
                    }
                    case 1:
                    {
                        st.setTextColor(Color.WHITE);
                        break;
                    }
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        mGestureDetector.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
