package co.il.guykoren;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomer on 4/3/16.
 */
public class Section {
    List<Object> files_name;
    String title;
    String desc;
    String id;
    public List<File> files;

    public Section(String title, String desc, String objectId, List<Object> files_name, List<Object> files_url) {
        this.title = title;
        this.desc = desc;
        this.id = objectId;
        this.files = new ArrayList<>();
        if (files_name != null) {
            for (int i = 0; i < files_name.size(); i++) {
                this.files.add(new File((String) files_name.get(i), (String) files_url.get(i)));
            }
        }
        else {
            Log.e("Section ",title+" is empty");
        }
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public class File {
        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }

        String name;
        String url;

        public File(String name, String url) {
            this.name = name;
            this.url = url;
        }
    }
}
