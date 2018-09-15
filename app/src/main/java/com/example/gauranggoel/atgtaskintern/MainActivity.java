package com.example.gauranggoel.atgtaskintern;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static int k=0;
    FragmentManager fm;
    FragmentTransaction ft;
    public static final String TAG="main";
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    switchToFragment1();
                    Log.d(TAG,"navigation home");
                    return true;
                case R.id.navigation_dashboard:
                    switchToFragment2();
                    Log.d(TAG,"navigation search");
                    return true;
               /* case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;*/
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


       fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        if(k==0)
            ft.add(R.id.content,new HomeFragment());
        else
            ft.add(R.id.content,new SearchFragment());

        Log.d(TAG,"navigation main");
        ft.commit();
    }
    public void switchToFragment1() {
        ft=fm.beginTransaction();
        ft.replace(R.id.content, new HomeFragment()).commit();
    }
    public void switchToFragment2() {
        k=1;
        ft=fm.beginTransaction();
        ft.replace(R.id.content, new SearchFragment()).commit();
    }

}
