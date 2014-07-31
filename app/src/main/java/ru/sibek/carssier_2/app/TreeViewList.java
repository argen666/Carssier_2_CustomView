package ru.sibek.carssier_2.app;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Developer on 31.07.2014.
 */
public class TreeViewList extends ListView {

    private TextView header;
    private TextView footer;
    private ListView lvMain;
    private RelativeLayout layout;
    //private Context ctx;

    public TreeViewList(Context context) {
        this(context,null);
    }

    public TreeViewList(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TreeViewList(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        //ctx = context;
        ((Activity)getContext())
                .getLayoutInflater()
                .inflate(R.layout.titled_tree_view, this, true);


        layout = (RelativeLayout)findViewById(R.id.layout);
        header = (TextView)findViewById(R.id.tvHeader);
        footer = (TextView)findViewById(R.id.tvFooter);
        lvMain = (ListView)findViewById(R.id.mainList);


    }

    @Override
    public void setAdapter(ListAdapter adapter) {

        if (!(adapter instanceof TreeViewAdapter)) {
            throw new TreeConfigurationException(
                    "The adapter is not of TreeViewAdapter type");
        }
        lvMain.setAdapter(adapter);
    }

    /*public void setAdapter(final TreeViewAdapter adapter) throws Exception {
        if (!(adapter instanceof TreeViewAdapter)) {
            throw new Exception(
                    "The adapter is not of TreeViewAdapter type");
        }

//        String[] names = {"Балансировка","Грузики","Мойка"};
//        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(adapter.ctx, R.layout.list_item,
//                R.id.item_text, names);
        lvMain.setAdapter(adapter);
    }*/
}
