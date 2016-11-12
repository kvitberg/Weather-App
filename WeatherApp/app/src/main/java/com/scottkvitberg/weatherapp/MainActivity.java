package com.scottkvitberg.weatherapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private CurrentWeatherFromForecastIo mCurrentWeather = new CurrentWeatherFromForecastIo();

    private double latitude = 37.8267;
    private double longitude = -122.4233;
    private String apiKey = "";
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String forecastURl = "https://api.darksky.net/forecast/"+
                apiKey + "/" + latitude + "," + longitude + "?units=si";   //si = Celsius etc.
        if(isNetworkAvailable()) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(forecastURl)
                    .build();

            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    // TODO
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        String jsonData = response.body().string();
                        Log.v(TAG, jsonData);
                        if (response.isSuccessful()) {
                            mCurrentWeather = getCurrentDetails(jsonData);

                        } else {
                            alertUser();
                        }
                    } catch (IOException e) {
                        Log.e(TAG, "Exception caught: ", e);
                    }
                    catch (JSONException e ){
                        Log.e(TAG, "Exception caught: ", e);
                    }
                }
            });
        }else{
            noNetworkAvailable();
        }
        Log.d(TAG, "Main UI thread is running!");
    }

    private CurrentWeatherFromForecastIo getCurrentDetails(String jsonData) throws JSONException {
        JSONObject forecast = new JSONObject(jsonData);
        String timezone = forecast.getString("timezone");
        Log.i(TAG, "timezone: " +  timezone);

        JSONObject currently = forecast.getJSONObject("currently");

        CurrentWeatherFromForecastIo currentWeather = new CurrentWeatherFromForecastIo();
        currentWeather.setIcon(currently.getString("icon"));
        currentWeather.setTime(currently.getLong("time"));
        currentWeather.setTimeZone(timezone);
        currentWeather.setTemp(currently.getDouble("temperature"));
        currentWeather.setHumidity(currently.getDouble("humidity"));
        currentWeather.setPercipChance(currently.getDouble("precipProbability"));
        currentWeather.setSummary(currently.getString("summary"));

        return currentWeather;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if(networkInfo != null && networkInfo.isConnected()){
            isAvailable = true;
        }
        return isAvailable;
    }

    private void noNetworkAvailable() {
        NetworkDialogFragment networkDialog = new NetworkDialogFragment();
        networkDialog.show(getFragmentManager(), "error_dialog");
    }

    private void alertUser() {
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.show(getFragmentManager(), "error_dialog");
    }
}
