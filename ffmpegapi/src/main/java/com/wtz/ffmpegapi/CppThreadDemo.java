package com.wtz.ffmpegapi;

public class CppThreadDemo {

    static {
        System.loadLibrary("thread_demo");
    }

    public native String stringFromJNI();

    public native void stringToJNI(String string);

    public native void testSimpleThread();

    public native void startProduceConsumeThread();

    public native void stopProduceConsumeThread();

    public native void playPCM(String path);

    public interface OnResultListener {
        void onResult(int code, String msg);
    }

    private OnResultListener onResultListener;

    public void setOnResultListener(OnResultListener onResultListener) {
        this.onResultListener = onResultListener;
    }

    /**
     * C++ 层调用
     */
    public void onResult(int code, String msg) {
        if (onResultListener != null) {
            onResultListener.onResult(code, msg);
        }
    }

    public native void callbackFromC();

    public native void setByteArray(byte[] data);

    public native byte[] getByteArray();

}
