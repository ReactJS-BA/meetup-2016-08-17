package com.example.geo;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by gaguirre on 8/11/16.
 */
public class GeoModule extends ReactContextBaseJavaModule implements LocationListener {
    private final LocationManager locationManager;

    public GeoModule(ReactApplicationContext reactContext) {
        super(reactContext);
        locationManager = (LocationManager) getReactApplicationContext()
                .getSystemService(Context.LOCATION_SERVICE);
    }

    @Override
    public String getName() {
        return "Geo";
    }

    @ReactMethod
    public void getCurrentCountry(Promise promise) {
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        promise.resolve(getCountryFromLocation(location));
    }

    @ReactMethod
    public void stalk() {
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 100, this);
    }

    @Override
    public void onLocationChanged(Location location) {
        String countryCode = getCountryFromLocation(location);
        getReactApplicationContext()
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit("countryChanged", countryCode);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    private String getCountryFromLocation(Location location) {
        String countryCode = null;

        try {
            if (location != null) {
                Geocoder gcd = new Geocoder(getReactApplicationContext(), Locale.getDefault());
                List<Address> addresses = gcd
                        .getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                countryCode = addresses == null || addresses.isEmpty() ? null :
                        addresses.get(0).getCountryCode();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return countryCode;
    }
}
