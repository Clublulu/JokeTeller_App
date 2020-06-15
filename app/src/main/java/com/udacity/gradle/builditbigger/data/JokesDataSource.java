package com.udacity.gradle.builditbigger.data;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.model.Joke;
import com.udacity.gradle.builditbigger.utility.DataObjectConverter;

import java.io.IOException;
import java.util.List;

/**
 * Data source class that retrieves a joke remotely through Google Cloud Endpoints API.
 *
 */
public final class JokesDataSource {

    private static JokesDataSource sInstance;
    private static MyApi myApiService = null;

    private JokesDataSource() {

    }

    public static synchronized JokesDataSource getInstance() {
        if (sInstance == null ) {
            sInstance = new JokesDataSource();
        }

        return sInstance;
    }


    public List<Joke> getJokes() {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver
            myApiService = builder.build();
        }

        List<Joke> appJokes = null;
        try {
            appJokes = DataObjectConverter.convertJokeModel(myApiService.getJokes().execute().getItems());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return appJokes;
    }

}
