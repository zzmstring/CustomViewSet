package com.zzmstring.viewset.UI;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.View.Crouton.Configuration;
import com.zzmstring.viewset.View.Crouton.Crouton;
import com.zzmstring.viewset.View.Crouton.Style;

/**
 * Created by ZGL on 2015/2/6.
 */
public class CroutonActivity extends BaseActivity implements AdapterView.OnItemSelectedListener{
    private static final Style INFINITE = new Style.Builder().
            setBackgroundColorValue(Style.holoBlueLight).build();
    private static final Configuration CONFIGURATION_INFINITE = new Configuration.Builder()
            .setDuration(Configuration.DURATION_INFINITE)
            .build();

    private CheckBox displayOnTop;
    private Spinner styleSpinner;
    private EditText croutonTextEdit;
    private EditText croutonDurationEdit;
    private Crouton infiniteCrouton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crouton_activity);
        croutonTextEdit = (EditText) findViewById(R.id.edit_text_text);
        croutonDurationEdit = (EditText) findViewById(R.id.edit_text_duration);
        styleSpinner = (Spinner) findViewById(R.id.spinner_style);
        styleSpinner.setOnItemSelectedListener(this);
        displayOnTop = (CheckBox) findViewById(R.id.display_on_top);

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_show: {
                showCrouton();
                break;
            }

            default: {
                if (infiniteCrouton != null) {
                    Crouton.hide(infiniteCrouton);
                    infiniteCrouton = null;
                }
                break;
            }
        }
    }
    private void showCrouton() {
        Style croutonStyle = getSelectedStyleFromSpinner();

        if (croutonStyle != null) {
            showBuiltInCrouton(croutonStyle);
        } else {
            showAdvancedCrouton();
        }
    }

    private Style getSelectedStyleFromSpinner() {

        switch ((int) styleSpinner.getSelectedItemId()) {
            case 0: {
                return Style.ALERT;
            }

            case 1: {
                return Style.CONFIRM;
            }

            case 2: {
                return Style.INFO;
            }

            case 3: {
                return INFINITE;
            }

            default: {
                return null;
            }
        }
    }

    private String getCroutonText() {
        String croutonText = croutonTextEdit.getText().toString().trim();

        if (TextUtils.isEmpty(croutonText)) {
            croutonText = getString(R.string.text_demo);
        }
        return croutonText;
    }

    private void showBuiltInCrouton(final Style croutonStyle) {
        String croutonText = getCroutonText();
        showCrouton(croutonText, croutonStyle, Configuration.DEFAULT);
    }

    private void showAdvancedCrouton() {
        switch (styleSpinner.getSelectedItemPosition()) {
            case 4: {
                showCustomCrouton();
                break;
            }

            case 5: {
                showCustomViewCrouton();
                break;
            }
        }
    }

    private void showCustomCrouton() {
        String croutonDurationString = getCroutonDurationString();

        if (TextUtils.isEmpty(croutonDurationString)) {
            showCrouton(getString(R.string.warning_duration), Style.ALERT, Configuration.DEFAULT);
            return;
        }

        int croutonDuration = Integer.parseInt(croutonDurationString);
        Style croutonStyle = new Style.Builder().build();
        Configuration croutonConfiguration = new Configuration.Builder().setDuration(croutonDuration).build();

        String croutonText = getCroutonText();

        showCrouton(croutonText, croutonStyle, croutonConfiguration);
    }

    private void showCustomViewCrouton() {
        View view = View.inflate(this,R.layout.crouton_custom_view, null);
        final Crouton crouton;
        if (displayOnTop.isChecked()) {
            crouton = Crouton.make(this, view);
        } else {
            crouton = Crouton.make(this, view, R.id.alternate_view_group);
        }
        crouton.show();
    }

    private String getCroutonDurationString() {
        return croutonDurationEdit.getText().toString().trim();
    }

    private void showCrouton(String croutonText, Style croutonStyle, Configuration configuration) {
        final boolean infinite = INFINITE == croutonStyle;

        if (infinite) {
            croutonText = getString(R.string.infinity_text);
        }

        final Crouton crouton;
        if (displayOnTop.isChecked()) {
            crouton = Crouton.makeText(this, croutonText, croutonStyle);
        } else {
            crouton = Crouton.makeText(this, croutonText, croutonStyle, R.id.alternate_view_group);
        }
        if (infinite) {
            infiniteCrouton = crouton;
        }
        crouton.setOnClickListener(this).setConfiguration(infinite ? CONFIGURATION_INFINITE : configuration).show();
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch ((int) l) {

            case 4: { // Custom Style
                croutonTextEdit.setVisibility(View.VISIBLE);
                croutonDurationEdit.setVisibility(View.VISIBLE);
                break;
            }

            case 5: { // Custom View
                croutonTextEdit.setVisibility(View.GONE);
                croutonDurationEdit.setVisibility(View.GONE);
                break;
            }

            default: {
                croutonTextEdit.setVisibility(View.VISIBLE);
                croutonDurationEdit.setVisibility(View.GONE);
                break;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
