package com.lwansbrough.ReactCamera;

import android.content.res.Configuration;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.facebook.react.uimanager.ThemedReactContext;

import java.io.IOException;
import java.util.List;

class ReactCameraView extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder surfaceHolder;
    private Camera mCamera;
    ThemedReactContext context;

    public ReactCameraView(ThemedReactContext context, Camera cm) {
        super(context);
        mCamera = cm;
        setCameraParams(mCamera);
        Helper.setCamera(mCamera);
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
    }
    private void setCameraParams(Camera camera){
        Camera.Parameters params = camera.getParameters();
        List<String> focusModes = params.getSupportedFocusModes();
        if(focusModes.contains(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE)) {
            params.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
            camera.setParameters(params);
        }
        List<String> flashModes = params.getSupportedFlashModes();

        // Set the camera to Auto Flash mode.
        if (flashModes != null && flashModes.contains(Camera.Parameters.FLASH_MODE_AUTO)){
            Camera.Parameters parameters = mCamera.getParameters();
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_AUTO);
            mCamera.setParameters(parameters);
        }
    }

    public void maybeUpdateView() {
        return;
    }

    public void surfaceCreated(SurfaceHolder holder) {
        try {
            mCamera.setPreviewDisplay(holder);
            this.mCamera.startPreview();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int heigth) {
        if(holder.getSurface() == null){return;}
        try{
            mCamera.stopPreview();
        } catch (Exception e) {

        }
        if(getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_PORTRAIT){
            mCamera.setDisplayOrientation(90);
        }
        try {
            mCamera.setPreviewDisplay(surfaceHolder);
            mCamera.startPreview();
        } catch (Exception e){

        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if (mCamera != null) {
            mCamera.stopPreview();
        }
    }
}
