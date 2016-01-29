package com.example.administrator.volleydisklrucache;

import android.app.Application;
import android.graphics.Bitmap;

/**
 * Created by Administrator on 2016-01-20.
 */
public class TestApplication extends Application {
    private static int DISK_IMAGECACHE_SIZE = 1024 * 1024 * 10;
    private static Bitmap.CompressFormat DISK_IMAGECACHE_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
    private static int DISK_IMAGECACHE_QUALITY = 100;  //PNG is lossless so quality is ignored but must be provided

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        createImageCache();
    }

    private void createImageCache() {
        ImageCacheManager.getInstance().init(this,
                getPackageCodePath()
                , DISK_IMAGECACHE_SIZE
                , DISK_IMAGECACHE_COMPRESS_FORMAT
                , DISK_IMAGECACHE_QUALITY);
    }
}