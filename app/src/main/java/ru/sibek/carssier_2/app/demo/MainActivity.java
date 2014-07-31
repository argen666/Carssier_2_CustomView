package ru.sibek.carssier_2.app.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import ru.sibek.carssier_2.app.R;
import ru.sibek.carssier_2.app.TreeViewAdapter;
import ru.sibek.carssier_2.app.TreeViewList;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.titled_tree_view);

        // находим список
        ListView lvMain = (ListView) findViewById(R.id.mainList);
        final RelativeLayout header = (RelativeLayout)findViewById(R.id.header);
        final RelativeLayout footer = (RelativeLayout)findViewById(R.id.footer);
        final String[] names = {"Балансировка",
                "Грузики",
                //"Алюминиевые до 15гр","Алюминиевые до 15-60гр","Грузик-липучка (пластина)","Грузик-липучка","Металлические до 15гр","Металлические до 15-60гр","Грузик-липучка (пластина)","Грузик-липучка",
                "Мойка"};//,
                //"Мойка мылом","Мойка шампунем","Мойка голыми бабами"};
        // создаем адаптер
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item,
//                R.id.item_text, names);
       /* TreeViewList tw = (TreeViewList) findViewById(R.id.mainTreeView);
        try {
            tw.setAdapter(new TreeViewAdapter(this,names));
        } catch (Exception e) {
            e.printStackTrace();
            Log.v("QQQ", ">>>>>>>>>=" + e);
        }
        Toast.makeText(MainActivity.this,
                tw.toString(), Toast.LENGTH_SHORT).show();
*/
        // присваиваем адаптер списку
        lvMain.setAdapter(new TreeViewAdapter(this,names));



        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> l, View v, int position,
                                    long id) {
                Log.v("QQQ", ">>>>>>>>>=" + position + "__ " + id);
                if (position==names.length-1)
                {
                    header.setVisibility(View.VISIBLE);
                    ((TextView)header.getChildAt(0)).setText(names[position]);
                    footer.setVisibility(View.GONE);

                } else {
                    header.setVisibility(View.VISIBLE);
                    ((TextView)header.getChildAt(0)).setText(names[position]);
                    footer.setVisibility(View.VISIBLE);
                    ((TextView)footer.getChildAt(0)).setText(names[position+1]);
                }
            }
        });

    }

    public void onMyButtonClick(View view) {

                Toast.makeText(MainActivity.this,
                        "Option Button is clicked!", Toast.LENGTH_SHORT).show();

       /* imageButton = (ImageButton) findViewById(R.id.drawer_item_icon2);
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(MainActivity.this,
                        "Order In Work Button is clicked!", Toast.LENGTH_SHORT).show();

            }

        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
