package com.blundell.tutorial;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.blundell.tutorial.cam.FaceDetectionCamera;

@SuppressLint("ViewConstructor") // View can only be inflated programatically
public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private final FaceDetectionCamera camera;
    private final FaceDetectionCamera.Listener listener;

    public CameraSurfaceView(Context context, FaceDetectionCamera camera, FaceDetectionCamera.Listener listener) {
        super(context);
        this.camera = camera;
        this.listener = listener;
        this.getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        camera.initialise(listener, holder);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        if (surfaceDoesNotExist()) {
            return;
        }
        camera.initialise(listener, holder);
    }

    private boolean surfaceDoesNotExist() {
        return getHolder().getSurface() == null;
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // empty. Take care of releasing the Camera preview in your activity.
    }
}
