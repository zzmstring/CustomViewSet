package com.zzmstring.viewset.Bean;




import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;
import com.zzmstring.viewset.Utils.orhan.Logger;

/**
 * Created by zzmstring on 2015/4/22.
 */
public class TestJob extends Job {
    private long localId;
    private String text;
    public TestJob(String text) {
        super(new Params(20).requireNetwork().persist().groupBy("post_tweet"));//order of tweets matter, we don't want to send two in parallel
        //use a negative id so that it cannot collide w/ twitter ids
        //we have to set local id here so it gets serialized into job (to find tweet later on)
        localId = -System.currentTimeMillis();
        this.text = text;
    }
    @Override
    public void onAdded() {
        Logger.v("onAdded",3);

    }

    @Override
    public void onRun() throws Throwable {
        Logger.v("onRun",3);

    }

    @Override
    protected void onCancel() {
        Logger.v("onCancel",3);

    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        Logger.v("shouldReRunOnThrowable",3);
        return false;
    }
}
