package co.il.guykoren;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by tomer on 4/3/16.
 */
public class SectionsAdapter extends BaseAdapter {
    private Context mContext;
    ArrayList<Section> sections;

    public SectionsAdapter(Context c, ArrayList<Section> sections) {
        mContext = c;
        this.sections = sections;
    }

    public int getCount() {
        return sections.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)   mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View item = inflater.inflate(R.layout.grid_item, null);

        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            ((TextView) item.findViewById(R.id.tv_title))
                    .setText(sections.get(position).title);
            ((TextView) item.findViewById(R.id.tv_desc))
                    .setText(sections.get(position).desc);

        } else {
            item = (View) convertView;
        }


        return item;
    }


}
