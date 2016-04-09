package co.il.guykoren;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.joanzapata.pdfview.PDFView;

/**
 * Created by tomer on 4/9/16.
 */
public class ContentView extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_view);
        ((WebView) findViewById(R.id.wv_content)).loadUrl("https://docs.google.com/document/d/1hD-ZmcolXEFAJ_XTomA_q8xQpmibYMOnrmmGZNfuDJU/pub");
    }
}
