import React, { Component } from 'react'
import {
  View,
  StyleSheet,
  Animated,
  Easing,
  Image,
  Dimensions,
  PixelRatio,
} from 'react-native'

import RevealView from './reveal-view'

const images = {
  'buenos+aires': require('../images/buenos-aires.jpg'),
  'milan': require('../images/milan.jpg'),
  'madrid': require('../images/madrid.jpg'),
  'paris': require('../images/paris.jpg'),
  'londres': require('../images/londres.jpg'),
}

const pxRatio = PixelRatio.get()
const h = Dimensions.get('window').height*pxRatio
const w = Dimensions.get('window').width*pxRatio

const screenDiagonal = Math.sqrt(h*h + w*w)

const FullScreenReveal = (props) => (
  <RevealView
    style={styles.fullScreen}
    visible={props.visible}
    centerX={0}
    centerY={0}
    startRadius={0}
    endRadius={screenDiagonal*pxRatio}
    duration={1000}>
    {props.children}
  </RevealView>
)

class BackgroundImage extends Component {
  state = {
    opacity: new Animated.Value(0),
    currentImage: null,
    oldImage: null
  }

  componentDidMount() {
    this.showImageForCity(this.props.city)
  }

  componentWillReceiveProps(newProps) {
    if (newProps.city !== this.props.city) {
      this.showImageForCity(newProps.city)
    }
  }

  showImageForCity(city) {
    this.setState({
      currentImage: images[city],
      oldImage: this.state.currentImage,
      visible: false
    })
  }

  handleImageLoad() {
    this.setState({ visible: true })
  }

  render() {
    const { currentImage, oldImage } = this.state

    return (
      <View style={styles.fullScreen}>
        <Image
          source={oldImage}
          style={styles.fullScreen}
        />
        <FullScreenReveal visible={this.state.visible}>
          <Image
            source={currentImage}
            style={styles.fullScreen}
            onLoad={() => this.handleImageLoad()}
          />
        </FullScreenReveal>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  fullScreen: {
    position: 'absolute',
    top: 0,
    bottom: 0,
    right: 0,
    left: 0,
    width: null,
    height: null,
    backgroundColor: 'transparent'
  },
})

export default BackgroundImage