package co.il.guykoren;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by tomer on 4/9/16.
 */
public class ContentView extends Fragment {
    String url;
    WebView content;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_view, container, false);
        content = (WebView) rootView.findViewById(R.id.wv_content);
        //String url = getActivity().getIntent().getStringExtra("url");
        content.loadUrl(RES.url);
      //  content.setInitialScale(1);
        content.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);


        return rootView;
    }

    public void setUrl(String url){
        RES.url = url;
        content.loadUrl(RES.url);
    }
}
