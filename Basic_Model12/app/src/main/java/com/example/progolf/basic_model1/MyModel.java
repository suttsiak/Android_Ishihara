package com.example.progolf.basic_model1;

/**
 * Created by User on 3/4/2560.
 */

public class MyModel {

    private int intRadio;
    private int intButton;

    public interface OnMyModelChangeListener {

        void onMyModelChangeListener(MyModel myModel);

    }

    private OnMyModelChangeListener onMyModelChangeListener;

    public void setOnMyModelChangeListener(OnMyModelChangeListener onMyModelChangeListener) {
        this.onMyModelChangeListener = onMyModelChangeListener;
    }

    public int getIntRadio() {

        return intRadio;

    }   //end getter Radio

    public void setIntRadio(int intRadio) {
        this.intRadio = intRadio;
        if (this.onMyModelChangeListener != null) {
            onMyModelChangeListener.onMyModelChangeListener(this);
        }
    }   //end setter Radio

    public int getIntButton() {

        return intButton;

    }   //end getter Button

    public void setIntButton(int intButton) {
        this.intButton = intButton;
        if (this.onMyModelChangeListener != null) {
            onMyModelChangeListener.onMyModelChangeListener(this);
        }

    }  //end setter Button
}
