package com.bwie.shoppingcart.home.view;

import android.app.Application;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

public class MApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        DiskCacheConfig diskCacheConfig = DiskCacheConfig.newBuilder(this)
                .setMaxCacheSize(100*1024*1024)
                .setBaseDirectoryPath(getCacheDir())
                .setBaseDirectoryName("image")
                .build();
        ImagePipelineConfig pipelineConfig = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(diskCacheConfig)
                .build();

        Fresco.initialize(this,pipelineConfig);

    }
}
