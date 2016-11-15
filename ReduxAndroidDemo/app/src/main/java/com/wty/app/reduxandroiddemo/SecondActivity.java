package com.wty.app.reduxandroiddemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wty.app.reduxandroiddemo.action.SecondActionCreater;
import com.wty.app.reduxandroiddemo.reduce.SecondReduce;
import com.wty.app.reduxandroiddemo.state.SecondState;
import com.wty.app.reduxlib.BaseReduxActivity;
import com.wty.app.reduxlib.state.ReduxState;
import com.wty.app.reduxlib.store.ReduxStore;

public class SecondActivity extends BaseReduxActivity {

    private TextView ButtonTwo;
    private SecondReduce reduce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButtonTwo = (TextView) findViewById(R.id.buttonTwo);
        init();
        render(null);
    }

    @Override
    protected void onStateChange(ReduxState state) {
        if (state instanceof SecondState) {
            render((SecondState) state);
        }
    }

    private void render(SecondState state) {
        if (state == null)
            return;
        if (state.isLoading()) {
            ButtonTwo.setText("。。。");
        } else {
            ButtonTwo.setText(state.getText());
        }
    }

    private void init() {
        reduce = new SecondReduce();
        ReduxStore.getInstance().addReduce(reduce);

        ButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SecondActionCreater().changeText();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ReduxStore.getInstance().removeReduce(reduce);
    }

}
