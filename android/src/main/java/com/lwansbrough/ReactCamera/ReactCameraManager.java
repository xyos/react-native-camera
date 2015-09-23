package com.lwansbrough.ReactCamera;

import android.content.Context;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.react.uimanager.CatalystStylesDiffMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIProp;
import com.facebook.react.uimanager.ViewProps;

import android.hardware.Camera;

public class ReactCameraManager extends SimpleViewManager<ReactCameraView> {

    public static final String REACT_CLASS = "ReactCameraView";
    private Camera camera = null;

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @UIProp(UIProp.Type.STRING)
    public static final String PROP_PLACEHOLDERPROP = "placeholderprop";

    @Override
    public ReactCameraView createViewInstance(ThemedReactContext context) {
        ReactCameraView view = new ReactCameraView(context, this.getCameraInstance());
        return view;
    }

    public Camera getCameraInstance(){
        if (this.camera != null) {
            return camera;
        } else {
            Camera camera = null;
            try {
                camera = Camera.open();
            }
            catch (Exception e) {

            }
            return camera;
        }
    }

    @Override
    public void updateView(final ReactCameraView view, final CatalystStylesDiffMap props) {
        super.updateView(view, props);
        view.maybeUpdateView();
    }
}
