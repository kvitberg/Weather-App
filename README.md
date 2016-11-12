## Ultimate Weather App For Photography - Android


### Link to API's: 

* [Forecast.io](https://darksky.net/dev/docs/forecast)
 * Example: https://api.forecast.io/forecast/INSERT_YOUR_FORECAST_API_KEY/37.8267,-122.423
  * Remember to add your API key
* [YR](http://om.yr.no/verdata/free-weather-data/) 
* [SeNorge] (http://www.senorge.no/index.html?p=senorgeny&st=weather)


### Link to inspirations:
 * [Aurora Alarm](http://auroraalarm.readthedocs.io/en/latest/api_documentation.html)
 * [Sun calculations rewritten to java from](https://github.com/mourner/suncalc/blob/master/suncalc.js)


### 3rd party library
  * [OKHttp](http://square.github.io/okhttp/)

### Extentions to help you read JSON
 * [JSONView for Chrome](https://chrome.google.com/webstore/detail/jsonview/nckmconehaglkoocmmldmilnnpdagigh)


## A little something to freshen up:
###  [Definitions](http://www.restapitutorial.com/lessons/httpmethods.html)

* HTTP: HyperText Transfer Protocol
* GET: Retrieve data from the network
* POST: Create new data over the network
* CRUD: Create/Retrieve/Update/Delete
* [URI vs. URL by Daniel Miessler](https://danielmiessler.com/study/url-uri/#gs.cYS4A2k)


### Remember to add the correct internet permission in the manifest file:
```xml
<uses-permission android:name="android.permission.INTERNET"></uses-permission>
```
When checking for available networks:
```java
ConnectivityManager manager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
```
Remember to fix the permission to access the network state when using the ```getActiveNetworkInfo()``` method

```xml
 <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"></uses-permission>
```

# Forecast.io
### Icons from forecast.io:
* clear-day,
* clear-night, 
* rain,
* snow,
* sleet,
* wind,
* fog,
* cloudy,
* partly-cloudy-day,
* partly-cloudy-night

From the docs:
>  it finds the “worst” weather condition that will happen during the day (4AM to 4AM),
> and uses the icon for it. The only case where a daily icon will show a *-night value is partly-cloudy-night,
> and this is done to match the daily summary text. We already have intentions to change this behavior, 
> because it is confusing

moonPhase - optional, only on daily
 * 0 = New moon
 * 0.25 = First quarter moon
 * 0.5 = Full moon
 * 0.75 = Last quarter moon
 
 sunriseTime optional, only on daily
 sunsetTime optional, only on daily
 windBearing optional
 
