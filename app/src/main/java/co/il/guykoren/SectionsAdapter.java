package co.il.guykoren;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View item = inflater.inflate(R.layout.grid_item, null);

        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            ((TextView) item.findViewById(R.id.tv_title))
                    .setText(sections.get(position).title);
        } else {
            item = (View) convertView;
        }


       /* item.setVisibility(View.INVISIBLE);
        final Animation anim = AnimationUtils.loadAnimation(mContext, R.anim.grow_in);
        anim.setInterpolator(new LinearOutSlowInInterpolator());

        final View finalItem = item;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finalItem.startAnimation(anim);
                finalItem.setVisibility(View.VISIBLE);
            }
        }, position*50);
*/
        return item;
    }

    public void animOut() {

    }

    public void animIn() {

    }

    public void setSections(ArrayList<Section> sections){

    }

}
