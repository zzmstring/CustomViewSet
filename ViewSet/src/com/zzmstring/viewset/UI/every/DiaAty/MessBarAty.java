package com.zzmstring.viewset.UI.every.DiaAty;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import com.zzmstring.viewset.Base.BaseActivity;
import com.zzmstring.viewset.R;
import com.zzmstring.viewset.View.messagebar.MessageBar;

/**
 * Created by zzmstring on 2015/5/3.
 */
public class MessBarAty extends BaseActivity implements MessageBar.OnMessageClickListener {
    private static final String STATE_MESSAGEBAR = "net.simonvt.messagebar.samples.SampleActivity.messageBar";
    private static final String STATE_COUNT = "net.simonvt.messagebar.samples.SampleActivity.count";

    private MessageBar mMessageBar;

    private TextView mTextView;

    private int mCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        setContentView(R.layout.messbar_main);
        mTextView = (TextView) findViewById(R.id.messageClickedTextView);

        mMessageBar = new MessageBar(this);
        mMessageBar.setOnClickListener(this);

        findViewById(R.id.withText).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMessageBar.show("Message #" + mCount);
                mCount++;
            }
        });

        findViewById(R.id.withTextAndButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putInt("count", mCount);
                mMessageBar.show("Message #" + mCount, "Button!", R.drawable.ic_messagebar_undo, b);
                mCount++;
            }
        });
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {

    }
    @Override
    public void onMessageClick(Parcelable token) {
        Bundle b = (Bundle) token;
        final int count = b.getInt("count");
        mTextView.setText("You clicked message #" + count);
    }
}
