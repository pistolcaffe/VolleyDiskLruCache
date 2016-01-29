package com.example.administrator.volleydisklrucache;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by jun on 2016-01-13.
 */
public class ServerProxy {
    private static ServerProxy mInstance;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private Context mContext;

    private ServerProxy(Context context) {
        mContext = context;
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public static ServerProxy getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new ServerProxy(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }
}