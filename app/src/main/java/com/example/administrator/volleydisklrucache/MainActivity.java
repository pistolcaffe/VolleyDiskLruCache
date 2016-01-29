package com.example.administrator.volleydisklrucache;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int[] mResId = {R.id.ci_1, R.id.ci_2, R.id.ci_3};
    private String[] mUrls = {"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR5aPq7OdSiuO7tyteLxRp6cr1-XY2qrKZPRsjHtYF2DjjmVva_1A",
            "http://cfile24.uf.tistory.com/image/205F30404ED69956255316",
            "http://cfile219.uf.daum.net/image/26544D4F533D4037081931"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < mResId.length; i++) {
            ((CircleNetworkImageView) findViewById(mResId[i])).loadCircleBitmap(mUrls[i]);
        }
    }
}
