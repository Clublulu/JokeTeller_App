package com.udacity.gradle.builditbigger.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.model.Joke;
import com.udacity.gradle.builditbigger.utility.DataObjectConverter;

import java.io.IOException;

/**
 * Data source class that retrieves a joke remotely through Google Cloud Endpoints API.
 *
 */
public final class JokesDataSource {

    private static JokesDataSource sInstance;
    private static MyApi myApiService;
    private MutableLiveData<Joke> mJoke;

    private static final String GCE_ROOT_URL = "http://10.0.2.2:8080/_ah/api/";

    private JokesDataSource() {
        MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(), null)
                .setRootUrl(GCE_ROOT_URL)
                .setGoogleClientRequestInitializer(abstractGoogleClientRequest ->
                        abstractGoogleClientRequest.setDisableGZipContent(true));
        myApiService = builder.build();
        mJoke = new MutableLiveData<>();
    }

    public static synchronized JokesDataSource getInstance() {
        if (sInstance == null ) {
            sInstance = new JokesDataSource();
        }

        return sInstance;
    }

    public void fetchJoke() {
        try {
            Joke joke = DataObjectConverter.convertJokeModel(myApiService.getJoke().execute());
            mJoke.postValue(joke);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LiveData<Joke> getJoke() {
        return mJoke;
    }
}
