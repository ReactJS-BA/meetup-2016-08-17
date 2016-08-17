# React Native++ - Extendiendo RN con tu código nativo

Esto es una continuación de un [ejemplo anterior](https://github.com/ReactJS-BA/meetup-2016-06-08/tree/master/example).
Si nunca antes usaste React Native te recomendamos primero ver esa intro y luego pasar a este.

## ¿De qué se trata?
En este ejemplo implementamos (solamente para Android) un [**Native Module**](http://facebook.github.io/react-native/releases/0.31/docs/native-modules-android.html) que nos permite obtener el país en el que se encuentra el usuario basado en el GPS del dispositivo.

Además creamos un [**Native UI Component**](http://facebook.github.io/react-native/releases/0.31/docs/native-components-android.html) en el que usamos **Circular Reveal**, una animación provista por Android a partir de Lollipop.

## Instalación
Primero clona este repo que tiene una app de ejemplo
```
git clone git@github.com:ReactJS-BA/meetup-2016-08-17.git MeetupReact2
```

Después movete a la carpeta del proyecto e instalá las dependencias del proyecto
```
cd MeetupReact2/example
npm install
```

Ahora corré la app
```
react-native run-android
```
