package com.afollestad.mvpanddaggerexample.views;

import java.util.List;

/**
 * This part is the 'V' in MVP, View. MainActivity implements this interface, it gives the presenter a
 * connection to the UI.
 *
 * @author Aidan Follestad (afollestad)
 */
public interface MainViews {

    void showProgress();

    void setItems(List<String> items);

    void hideProgress();

    void showMessage(String msg);
}