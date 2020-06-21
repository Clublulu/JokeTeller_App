package com.udacity.gradle.builditbigger.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.udacity.android.androidlibrary.model.Joke;
import com.udacity.android.androidlibrary.ui.JokeActivity;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.utility.DataObjectConverter;
import com.udacity.gradle.builditbigger.utility.JokesInstanceInjector;


public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mViewModel;

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "entered onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivityViewModelFactory factory = JokesInstanceInjector.
                provideMainActivityViewModelFactory(getApplicationContext());
        mViewModel = new ViewModelProvider(this, factory).get(MainActivityViewModel.class);
    }

    @Override
    protected void onStart() {
        Log.d(LOG_TAG, "entered onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(LOG_TAG, "entered onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(LOG_TAG, "entered onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(LOG_TAG, "entered onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(LOG_TAG, "entered onDestroy");
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        mViewModel.getRandomJoke().observe(this, joke -> {
            if (joke != null) {
                Joke androidLibraryJoke = DataObjectConverter.convertJokeModel(joke);
                Intent intent = new Intent(getApplicationContext(), JokeActivity.class);
                intent.putExtra(
                        JokeActivity.JOKE_KEY,
                        androidLibraryJoke);
                startActivity(intent);

            }
        });
    }
}
