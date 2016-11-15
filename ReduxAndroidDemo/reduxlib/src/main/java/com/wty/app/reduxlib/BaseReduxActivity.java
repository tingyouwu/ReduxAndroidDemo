package com.wty.app.reduxlib;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wty.app.reduxlib.state.ReduxState;
import de.greenrobot.event.EventBus;

/**
 * @Desc redux 基础activity
 **/
public abstract class BaseReduxActivity extends AppCompatActivity {

    public EventBus eventBus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eventBus = EventBus.getDefault();
        eventBus.register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        eventBus.unregister(this);
    }

    /**
     * 接收想要监听的状态变化
     * @param state
     */
    public void onEvent(ReduxState state) {
        onStateChange(state);
    }

    protected abstract void onStateChange(ReduxState state);
}
