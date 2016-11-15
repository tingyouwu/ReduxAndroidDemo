package com.wty.app.reduxandroiddemo.state;


import com.wty.app.reduxlib.state.ReduxState;

/**
 * @Desc 状态1
 **/
public class SecondState implements ReduxState{

    private boolean isLoading;
    private String text;

    public SecondState(boolean isLoading, String text) {
        this.isLoading = isLoading;
        this.text = text;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
