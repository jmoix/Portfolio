package com.jasonmoix.portfolio;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public void buttonClick(View view){

        switch (view.getId()){

            case R.id.streamerButton:
                showToast(getString(R.string.buttonToastBegin) + " " +
                        getString(R.string.spotifyStreamerAppTitle).toLowerCase() +
                        getString(R.string.buttonToastEnd));
                break;
            case R.id.scoresButton:
                showToast(getString(R.string.buttonToastBegin) + " " +
                        getString(R.string.scoresAppTitle).toLowerCase() +
                        getString(R.string.buttonToastEnd));
                break;
            case R.id.libraryButton:
                showToast(getString(R.string.buttonToastBegin) + " " +
                        getString(R.string.libraryAppTitle).toLowerCase() +
                        getString(R.string.buttonToastEnd));
                break;
            case R.id.builditButton:
                showToast(getString(R.string.buttonToastBegin) + " " +
                        getString(R.string.buildItBiggerAppTitle).toLowerCase() +
                        getString(R.string.buttonToastEnd));
                break;
            case R.id.xyzButton:
                showToast(getString(R.string.buttonToastBegin) + " " +
                        getString(R.string.xyzReaderAppTitle).toLowerCase() +
                        getString(R.string.buttonToastEnd));
                break;
            case R.id.capstoneButton:
                showToast(getString(R.string.buttonToastBegin) + " " +
                        getString(R.string.capstoneAppTitle).toLowerCase() +
                        getString(R.string.buttonToastEnd));
                break;
        }

    }

    private void initializeMainFragment(){

        FragmentManager fm = getSupportFragmentManager();
        MainFragment fragment = (MainFragment)fm.findFragmentById(R.id.mainFragment);

        if(fragment == null){
            fragment = new MainFragment();
            fm.beginTransaction()
                    .add(R.id.mainFragment, fragment)
                    .commit();
        }

    }

    private void initializeToolbar(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.mainTitle));

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeToolbar();
        initializeMainFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_about:
                showToast(getString(R.string.mainHeader));
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
