import React, { Component } from 'react'
import {
  AppRegistry,
  StyleSheet,
  View,
  StatusBar,
  NativeModules,
  DeviceEventEmitter,
} from 'react-native'

import BackgroundImage from './src/components/background-image'
import Row from './src/components/row'
import Overlay from './src/components/overlay'
import CityPicker from './src/components/city-picker'
import WeatherBox from './src/components/weather-box'

import * as weatherService from './src/services/weather'

const Geo = NativeModules.Geo

class App extends Component {
  state = {
    city: 'buenos+aires',
  }

  componentDidMount() {
    // NOTE: this is not needed anymore since we have the listener
    // Geo.getCurrentCountry().then(this.handleCountryChange)
    Geo.stalk()
  }

  componentWillMount() {
    DeviceEventEmitter.addListener('countryChanged', this.handleCountryChange)
  }

  componentWillUnmount() {
    DeviceEventEmitter.removeListener('countryChanged', this.handleCountryChange)
  }

  handleCountryChange = (country) => {
    const cities = {
      AR: 'buenos+aires',
      ES: 'madrid',
      IT: 'milan',
      EN: 'londres',
      FR: 'paris',
    }

    this.handleCityChange(cities[country] || 'buenos+aires')
  }

  handleCityChange(city) {
    this.setState({
      city,
      weather: null
    })

    weatherService
      .getForCity(city)
      .then((weather) => this.setState({ weather }))
  }

  render() {
    return (
      <View style={styles.container}>
        <StatusBar hidden></StatusBar>
        <BackgroundImage city={this.state.city} />
        <Row>
          <Overlay />
          <CityPicker
            selectedValue={this.state.city}
            onValueChange={(city) => this.handleCityChange(city)} />
        </Row>
        <Row>
          <Overlay footer={true} />
          <WeatherBox weather={this.state.weather} />
        </Row>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'space-between',
    alignItems: 'center'
  }
})

export default App
