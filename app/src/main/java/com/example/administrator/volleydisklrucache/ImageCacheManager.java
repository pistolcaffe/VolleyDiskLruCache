package com.example.administrator.volleydisklrucache;

import android.content.Context;
import android.graphics.Bitmap;

import com.android.volley.toolbox.ImageLoader;

public class ImageCacheManager implements ImageLoader.ImageCache {

    private static ImageCacheManager mInstance;
    private ImageLoader mImageLoader;
    private DiskLruImageCache mDiskCache;

    public static ImageCacheManager getInstance() {
        if (mInstance == null)
            mInstance = new ImageCacheManager();

        return mInstance;
    }

    /**
     * Initializer for the manager. Must be called prior to use.
     *
     * @param context        application context
     * @param uniqueName     name for the cache location
     * @param cacheSize      max size for the cache
     * @param compressFormat file type compression format.
     * @param quality
     */
    public void init(Context context, String uniqueName, int cacheSize, Bitmap.CompressFormat compressFormat, int quality) {
        mDiskCache = new DiskLruImageCache(context, uniqueName, cacheSize, compressFormat, quality);
        mImageLoader = new ImageLoader(ServerProxy.getInstance(context).getRequestQueue(), this);
    }

    @Override
    public Bitmap getBitmap(String key) {
        android.util.Log.e("VolleyDiskLruCache", "ImageCacheManager getBitmap :: key = " + key);
        try {
            return mDiskCache.getBitmap(createKey(key));
        } catch (NullPointerException e) {
            throw new IllegalStateException("Disk Cache Not initialized");
        }
    }

    @Override
    public void putBitmap(String key, Bitmap bitmap) {
        android.util.Log.e("VolleyDiskLruCache", "ImageCacheManager putBitmap :: key = " + key);
        try {
            mDiskCache.put(createKey(key), bitmap);
        } catch (NullPointerException e) {
            throw new IllegalStateException("Disk Cache Not initialized");
        }
    }

    /**
     * Executes and image load
     *
     * @param url      location of image
     * @param listener Listener for completion
     */
    public void getImage(String url, ImageLoader.ImageListener listener) {
        mImageLoader.get(url, listener);
    }

    /**
     * @return instance of the image loader
     */
    public ImageLoader getImageLoader() {
        return mImageLoader;
    }

    /**
     * Creates a unique cache key based on a key value
     *
     * @param key key to be used in key creation
     * @return cache key value
     */
    private String createKey(String key) {
        return String.valueOf(key.hashCode());
    }

}

