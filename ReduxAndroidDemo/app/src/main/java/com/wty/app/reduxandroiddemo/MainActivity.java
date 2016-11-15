package com.wty.app.reduxandroiddemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wty.app.reduxandroiddemo.action.ChangeTextActionCreater;
import com.wty.app.reduxandroiddemo.reduce.ChangeTextReduce;
import com.wty.app.reduxandroiddemo.state.ChangeTextState;
import com.wty.app.reduxandroiddemo.state.SecondState;
import com.wty.app.reduxlib.BaseReduxActivity;
import com.wty.app.reduxlib.state.ReduxState;
import com.wty.app.reduxlib.store.ReduxStore;

public class MainActivity extends BaseReduxActivity {

    private TextView buttonOne;
    private TextView buttonTwo;
    private ChangeTextReduce reduce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonOne = (TextView) findViewById(R.id.buttonOne);
        buttonTwo = (TextView) findViewById(R.id.buttonTwo);
        init();
        render(null);
    }

    @Override
    protected void onStateChange(ReduxState state) {
        if (state instanceof ChangeTextState) {
            render((ChangeTextState) state);
        } else if (state instanceof SecondState) {
            renderSecond((SecondState) state);
        }
    }

    private void render(ChangeTextState state) {
        if (state == null)
            return;
        if (state.isLoading()) {
            buttonOne.setText("。。。");
        } else {
            buttonOne.setText(state.getText());
        }
    }

    private void renderSecond(SecondState state) {
        if (state == null)
            return;
        if (state.isLoading()) {
            buttonOne.setText("。。。");
        } else {
            buttonOne.setText(state.getText());
        }
    }

    private void init() {
        reduce = new ChangeTextReduce();
        ReduxStore.getInstance().addReduce(reduce);

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ChangeTextActionCreater().changeText();
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }

}
