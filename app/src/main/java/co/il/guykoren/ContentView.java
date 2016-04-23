package co.il.guykoren;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;


/**
 * Created by tomer on 4/9/16.
 */
public class ContentView extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_view);
        String url = getIntent().getStringExtra("url");
        ((WebView) findViewById(R.id.wv_content)).loadUrl(url);
    }
}
