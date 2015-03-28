package com.zzmstring.viewset.UI.every.DiaAty;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.zzmstring.viewset.Adapter.SimpleAdapter;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.View.dialog.dialogplus.DialogPlus;
import com.zzmstring.viewset.View.dialog.dialogplus.GridHolder;
import com.zzmstring.viewset.View.dialog.dialogplus.Holder;
import com.zzmstring.viewset.View.dialog.dialogplus.ListHolder;
import com.zzmstring.viewset.View.dialog.dialogplus.OnCancelListener;
import com.zzmstring.viewset.View.dialog.dialogplus.OnClickListener;
import com.zzmstring.viewset.View.dialog.dialogplus.OnDismissListener;
import com.zzmstring.viewset.View.dialog.dialogplus.OnItemClickListener;
import com.zzmstring.viewset.View.dialog.dialogplus.ViewHolder;

/**
 * Created by zzmstring on 2015/3/28.
 */
public class DiaPlusAty extends Activity{
    private RadioGroup radioGroup;
    private CheckBox headerCheckBox;
    private CheckBox footerCheckBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diaplus_main);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        headerCheckBox = (CheckBox) findViewById(R.id.header_check_box);
        footerCheckBox = (CheckBox) findViewById(R.id.footer_check_box);
        findViewById(R.id.button_bottom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(
                        radioGroup.getCheckedRadioButtonId(),
                        DialogPlus.Gravity.BOTTOM,
                        headerCheckBox.isChecked(),
                        footerCheckBox.isChecked()
                );
            }
        });
        findViewById(R.id.button_center).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(
                        radioGroup.getCheckedRadioButtonId(),
                        DialogPlus.Gravity.CENTER,
                        headerCheckBox.isChecked(),
                        footerCheckBox.isChecked()
                );
            }
        });
        findViewById(R.id.button_top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(
                        radioGroup.getCheckedRadioButtonId(),
                        DialogPlus.Gravity.TOP,
                        headerCheckBox.isChecked(),
                        footerCheckBox.isChecked()
                );
            }
        });

    }
    private void showDialog(int holderId, DialogPlus.Gravity gravity, boolean showHeader, boolean showFooter) {
        boolean isGrid;
        Holder holder;
        switch (holderId) {
            case R.id.basic_holder_radio_button:
                holder = new
                        ViewHolder(R.layout.content);
                isGrid = false;
                break;
            case R.id.list_holder_radio_button:
                holder = new ListHolder();
                isGrid = false;
                break;
            default:
                holder = new GridHolder(3);
                isGrid = true;
        }

        OnClickListener clickListener = new OnClickListener() {
            @Override
            public void onClick(DialogPlus dialog, View view) {
                switch (view.getId()) {
                    case R.id.header_container:
                        Toast.makeText(DiaPlusAty.this, "Header clicked", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.like_it_button:
                        Toast.makeText(DiaPlusAty.this, "We're glad that you like it", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.love_it_button:
                        Toast.makeText(DiaPlusAty.this, "We're glad that you love it", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.footer_confirm_button:
                        Toast.makeText(DiaPlusAty.this, "Confirm button clicked", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.footer_close_button:
                        Toast.makeText(DiaPlusAty.this, "Close button clicked", Toast.LENGTH_LONG).show();
                        break;
                }
                dialog.dismiss();
            }
        };

        OnItemClickListener itemClickListener = new OnItemClickListener() {
            @Override
            public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                TextView textView = (TextView) view.findViewById(R.id.text_view);
                String clickedAppName = textView.getText().toString();
                dialog.dismiss();
                Toast.makeText(DiaPlusAty.this, clickedAppName + " clicked", Toast.LENGTH_LONG).show();
            }
        };

        OnDismissListener dismissListener = new OnDismissListener() {
            @Override
            public void onDismiss(DialogPlus dialog) {
                Toast.makeText(DiaPlusAty.this, "dismiss listener invoked!", Toast.LENGTH_SHORT).show();
            }
        };

        OnCancelListener cancelListener = new OnCancelListener() {
            @Override
            public void onCancel(DialogPlus dialog) {
                Toast.makeText(DiaPlusAty.this, "cancel listener invoked!", Toast.LENGTH_SHORT).show();
            }
        };

        SimpleAdapter adapter = new SimpleAdapter(DiaPlusAty.this, isGrid);
        if (showHeader && showFooter) {
            showCompleteDialog(holder, gravity, adapter, clickListener, itemClickListener, dismissListener, cancelListener);
            return;
        }

        if (showHeader && !showFooter) {
            showNoFooterDialog(holder, gravity, adapter, clickListener, itemClickListener, dismissListener, cancelListener);
            return;
        }

        if (!showHeader && showFooter) {
            showNoHeaderDialog(holder, gravity, adapter, clickListener, itemClickListener, dismissListener, cancelListener);
            return;
        }

        showOnlyContentDialog(holder, gravity, adapter, itemClickListener, dismissListener, cancelListener);
    }

    private void showCompleteDialog(Holder holder, DialogPlus.Gravity gravity, BaseAdapter adapter,
                                    OnClickListener clickListener, OnItemClickListener itemClickListener, OnDismissListener dismissListener, OnCancelListener cancelListener) {
        final DialogPlus dialog = new DialogPlus.Builder(this)
                .setContentHolder(holder)
                .setHeader(R.layout.header)
                .setFooter(R.layout.footer)
                .setCancelable(true)
                .setGravity(gravity)
                .setAdapter(adapter)
                .setOnClickListener(clickListener)
                .setOnItemClickListener(itemClickListener)
                .setOnDismissListener(dismissListener)
                .setOnCancelListener(cancelListener)
                .create();
        dialog.show();
    }

    private void showNoFooterDialog(Holder holder, DialogPlus.Gravity gravity, BaseAdapter adapter,
                                    OnClickListener clickListener, OnItemClickListener itemClickListener, OnDismissListener dismissListener, OnCancelListener cancelListener) {
        final DialogPlus dialog = new DialogPlus.Builder(this)
                .setContentHolder(holder)
                .setHeader(R.layout.header)
                .setCancelable(true)
                .setGravity(gravity)
                .setAdapter(adapter)
                .setOnClickListener(clickListener)
                .setOnItemClickListener(itemClickListener)
                .setOnDismissListener(dismissListener)
                .setOnCancelListener(cancelListener)
                .create();
        dialog.show();
    }

    private void showNoHeaderDialog(Holder holder, DialogPlus.Gravity gravity, BaseAdapter adapter,
                                    OnClickListener clickListener, OnItemClickListener itemClickListener, OnDismissListener dismissListener, OnCancelListener cancelListener) {
        final DialogPlus dialog = new DialogPlus.Builder(this)
                .setContentHolder(holder)
                .setFooter(R.layout.footer)
                .setCancelable(true)
                .setGravity(gravity)
                .setAdapter(adapter)
                .setOnClickListener(clickListener)
                .setOnItemClickListener(itemClickListener)
                .setOnDismissListener(dismissListener)
                .setOnCancelListener(cancelListener)
                .create();
        dialog.show();
    }

    private void showOnlyContentDialog(Holder holder, DialogPlus.Gravity gravity, BaseAdapter adapter,
                                       OnItemClickListener itemClickListener, OnDismissListener dismissListener, OnCancelListener cancelListener) {
        final DialogPlus dialog = new DialogPlus.Builder(this)
                .setContentHolder(holder)
                .setCancelable(true)
                .setGravity(gravity)
                .setAdapter(adapter)
                .setOnItemClickListener(itemClickListener)
                .setOnDismissListener(dismissListener)
                .setOnCancelListener(cancelListener)
                .create();
        dialog.show();
    }
}
