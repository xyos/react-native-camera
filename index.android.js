var { requireNativeComponent, PropTypes } = require('react-native');

var ReactCameraView = {
    name: 'ReactCameraView',
    propTypes: {
        placeholderprop: PropTypes.string
    }
};

module.exports = requireNativeComponent('ReactCameraView', ReactCameraView);
