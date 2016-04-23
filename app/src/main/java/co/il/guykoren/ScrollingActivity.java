package co.il.guykoren;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        assert toolbar != null;
        toolbar.setTitle(RES.sections.get(RES.selected_section).title);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        for (final Section.File file : RES.sections.get(RES.selected_section).files) {
            Log.d("FILE ", file.getName());
            LayoutInflater inflater =
                    (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View inflated = inflater.inflate(R.layout.list_item, null);
            ((TextView) inflated.findViewById(R.id.tvTitle)).setText(file.getName());
            inflated.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), ContentView.class);
                    intent.putExtra("url", file.getUrl());
                    //startActivity(intent);
                    RES.url = file.getUrl();

                    getSupportFragmentManager().beginTransaction()
                            .add(android.R.id.content, new ContentView())
                            .commit();

                }
            });
            ((LinearLayout) findViewById(R.id.listWrapper)).addView(inflated);
        }

    }
}
