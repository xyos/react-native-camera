'use strict';

var React = require('react-native');
var {
  AppRegistry,
  StyleSheet,
  Text,
  View,
} = React;

var Camera = require('react-native-camera'); //require the camera component

var ReactNativeCameraExample = React.createClass({
  render: function() {
    return (
      <View style={styles.container}>
        <Camera style={styles.camera}></Camera>
      </View>
    );
  }
});

var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  camera: {
      position: 'absolute',
      top: 0, right: 0, bottom: 0, left: 0
  },
});

AppRegistry.registerComponent('ReactNativeCameraExample', () => ReactNativeCameraExample);
