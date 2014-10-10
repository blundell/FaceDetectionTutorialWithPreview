FaceDetectionTutorial
=====================

Explantory tutorial can be found here: http://blog.blundell-apps.com/tut-front-camera-face-detection-explained/

Load your front facing camera like this

`FrontCameraRetriever.retrieveFor(context);`

Add a preview to your activity layout

```java
SurfaceView cameraSurface = new CameraSurfaceView(context, camera, this);
((FrameLayout) findViewById(R.id.helloWorldCameraPreview)).addView(cameraSurface);
```

Listen for face detection like this

```java
@Override
public void onFaceDetected() {
   
}

@Override
public void onFaceTimedOut() {

}

@Override
public void onFaceDetectionNonRecoverableError() {

}
```
