# React Native++ - Extending RN with your own native code

This example follows [this other one](https://github.com/ReactJS-BA/meetup-2016-06-08/blob/master/example/README.en.md).
We recommend you to see that first if you never used React Native before.

## About
In this example we implement (Android only) a [**Native Module**](http://facebook.github.io/react-native/releases/0.31/docs/native-modules-android.html) to get the country the user is located based on the device's GPS.
Also we create a [**Native UI Component**](http://facebook.github.io/react-native/releases/0.31/docs/native-components-android.html) applying the **Circular Reveal** effect, an animation provided by Android since Lollipop.

## Installation
First clone this repo which has a simple example app
```
git clone git@github.com:ReactJS-BA/meetup-2016-08-17.git MeetupReact2
```

Then move to the project folder and install the project dependencies
```
cd MeetupReact2/example
npm install
```

Now run the app
```
react-native run-android
```
