package com.example.gauranggoel.atgtaskintern;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Bundle tempBundle;
    public static int k=0;
    FragmentManager fm;
    FragmentTransaction ft;
    public static final String TAG="main";
    MenuItem  item1;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    item1=item;
                    if(k!=0)
                   {
                       switchToFragment1();
                   }
                    Log.d(TAG,"navigation home");
                    return true;
                case R.id.navigation_dashboard:
                    if(k==0)
                    {
                        switchToFragment2();
                    }
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
        tempBundle=savedInstanceState;
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
        k=0;
        getSupportFragmentManager().popBackStack();
        //getFragmentManager().popBackStack();
        ft=fm.beginTransaction();
        ft.replace(R.id.content, new HomeFragment()).commit();
    }
    public void switchToFragment2() {
        k=1;
        ft=fm.beginTransaction();
        ft.replace(R.id.content, new SearchFragment()).addToBackStack( "tag" ).commit();
    }

    @Override
    public void onBackPressed() {
        k=0;
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
            View view =findViewById(R.id.navigation_home);
            view.performClick();
          }
        else{
            super.onBackPressed();
        }
    }

}
