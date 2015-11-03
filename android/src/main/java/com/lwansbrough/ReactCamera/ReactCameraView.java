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
    private Camera camera;
    ThemedReactContext context;

    public ReactCameraView(ThemedReactContext context, Camera cm) {
        super(context);
        camera = cm;
        Helper.setCamera(camera);
        Camera.Parameters params = camera.getParameters();
        List<String> focusModes = params.getSupportedFocusModes();
        if(focusModes.contains(Camera.Parameters.FOCUS_MODE_AUTO)) {
            params.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
            camera.setParameters(params);
        }
        camera = cm;
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
    }

    public void maybeUpdateView() {
        return;
    }

    public void surfaceCreated(SurfaceHolder holder) {
        try {
            camera.setPreviewDisplay(holder);
            this.camera.startPreview();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width, int heigth) {
        if(holder.getSurface() == null){return;}
        try{
            this.camera.stopPreview();
        } catch (Exception e) {

        }
        if(getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_PORTRAIT){
            camera.setDisplayOrientation(90);
        }
        try {
            camera.setPreviewDisplay(surfaceHolder);
            camera.startPreview();
        } catch (Exception e){

        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if (camera != null) {
            camera.stopPreview();
        }
    }
}
