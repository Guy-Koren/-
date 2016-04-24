package co.il.guykoren;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplashScreen extends Activity implements Logger {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        log("Layout loaded successfully");
        RES.sections = new ArrayList<>();
        try {
            Parse.initialize(new Parse.Configuration.Builder(this).applicationId(Secret.APP_ID).clientKey(Secret.CLIENT_KEY).server(Secret.SERVER).build());
            log("Parse initialized successfully");
        } catch (IllegalStateException ignored) {
            if (RES.sections.isEmpty()) {
                log("Parse initialization failed.");
                Toast.makeText(getApplicationContext(), getString(R.string.error1), Toast.LENGTH_LONG).show();
                finish();
            }
        }
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Sections");
        query.whereExists("title");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> response, ParseException e) {
                for (int i = 0; i < response.size() - 1; i++) {
                    if (response.get(i).getCreatedAt().after(response.get(i + 1).getCreatedAt())) {
                        ParseObject temp = response.get(i);
                        response.set(i, response.get(i + 1));
                        response.set(i + 1, temp);
                        i = 0;
                    }
                    log(response.toString());
                }
                for (int i = 0; i < response.size() - 1; i++) {
                    if (response.get(i).getCreatedAt().after(response.get(i + 1).getCreatedAt())) {
                        ParseObject temp = response.get(i);
                        response.set(i, response.get(i + 1));
                        response.set(i + 1, temp);
                        i = 0;
                    }
                    log(response.toString());
                }
                for (ParseObject object : response) {
                    RES.sections.add(new Section(object.getString("title"), object.getString("desc"), object.getObjectId(), object.getList("files_name"), object.getList("files_url")));
                }

                log("Successfully retrieved data");
                log("Finishing activity");
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
                log("Activity finished");

            }
        });

    }

    @Override
    public void log(String msg) {
        Log.d("SplashScreen ", msg);
    }
}
