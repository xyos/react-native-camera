This is a first try on an android version of react-native-camera.
There is no functionality besides a "camera view" so please dont use this for anything serious.

Steps to add this to your react-native android project:
* `npm install https://github.com/timmh/react-native-camera.git`
* add to your `settings.gradle`:
```
include ':com.lwansbrough.ReactCamera'
project(':include ':com.lwansbrough.ReactCamera').projectDir = new File(settingsDir, '../node_modules/react-native-camera/android')
```
* add to your `build.gradle`:
```
dependencies {
    ...
    compile project(':com.lwansbrough.ReactCamera')
}
```
* add to your `MainActivity.java`:
	* `import com.facebook.react.CompositeReactPackage;`
	* `import com.lwansbrough.ReactCamera.*;`
	* in `onCreate`:
	```
	CompositeReactPackage myReactPackage = new CompositeReactPackage(new MainReactPackage(), new ReactCameraPackage());
	```
	```
	mReactInstanceManager = ReactInstanceManager.builder()
		...
		.addPackage(myReactPackage)
		...
	```
