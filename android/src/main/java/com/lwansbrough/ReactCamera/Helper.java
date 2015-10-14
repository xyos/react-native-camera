package com.lwansbrough.ReactCamera;

import android.hardware.Camera;

/**
 * Created by marcell on 10/9/15.
 */
public class Helper {

    private static Camera camera = null;

    public static void setCamera(Camera theCamera) {
        camera = theCamera;
    }

    public static Camera getCamera() {
        return camera;
    }
}
