package com.udacity.android.javajokes.data;


import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.udacity.android.javajokes.model.Joke;


import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Wrapper class around Retrofit library.
 *
 */
final class RetrofitClient {


    private static RetrofitClient sInstance;
    private static Retrofit mRetrofit;


    private RetrofitClient() {
        mRetrofit = new Retrofit.Builder()
            .baseUrl(JokesDataSource.JOKES_API_BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(createGsonConverter())
            .build();
    }

    static synchronized RetrofitClient getInstance() {
        if (sInstance == null) {
                sInstance = new RetrofitClient();
        }

        return sInstance;
    }

    private static Converter.Factory createGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(
                new TypeToken<Joke>() {}.getType(),
                new JokeDeserializer());

        return GsonConverterFactory.create(gsonBuilder.create());
    }

    JokesAPI getJokesAPI() { return mRetrofit.create(JokesAPI.class); }


}
