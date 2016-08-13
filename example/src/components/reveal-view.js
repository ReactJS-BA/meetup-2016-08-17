import { PropTypes } from 'react'
import {
  requireNativeComponent,
  View,
} from 'react-native'

const iface = {
  name: 'RevealView',
  propTypes: {
    visible: PropTypes.bool,
    centerX: PropTypes.number,
    centerY: PropTypes.number,
    startRadius: PropTypes.number,
    endRadius: PropTypes.number,
    duration: PropTypes.number,
    ...View.propTypes,
  },
}

export default requireNativeComponent('RNRevealView', iface);