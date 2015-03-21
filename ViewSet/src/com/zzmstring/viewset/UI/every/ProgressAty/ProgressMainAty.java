package com.zzmstring.viewset.UI.every.ProgressAty;

import android.app.ListActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
/**
 * Created by zzmstring on 2015/3/21.
 */
public class ProgressMainAty extends ListActivity {
    private String[] examples = new String[]{"Default", "Empty content", "Custom layout", "List", "Grid"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, examples);
        setListAdapter(arrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(this, ProgressActivity.class);
        intent.putExtra(ProgressActivity.EXTRA_TITLE, examples[position]);
        switch (position) {
            case 0:
                intent.putExtra(ProgressActivity.EXTRA_FRAGMENT, ProgressActivity.FRAGMENT_DEFAULT);
                break;
            case 1:
                intent.putExtra(ProgressActivity.EXTRA_FRAGMENT, ProgressActivity.FRAGMENT_EMPTY_CONTENT);
                break;
            case 2:
                intent.putExtra(ProgressActivity.EXTRA_FRAGMENT, ProgressActivity.FRAGMENT_CUSTOM_LAYOUT);
                break;
            case 3:
                intent.putExtra(ProgressActivity.EXTRA_FRAGMENT, ProgressActivity.FRAGMENT_LIST);
                break;
            case 4:
                intent.putExtra(ProgressActivity.EXTRA_FRAGMENT, ProgressActivity.FRAGMENT_GRID);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}
