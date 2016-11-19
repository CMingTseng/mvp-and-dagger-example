package com.afollestad.mvpanddaggerexample.views;

import java.util.List;

/**
 * @author Aidan Follestad (afollestad)
 */
public interface MainViews {

    void showProgress();

    void setItems(List<String> items);

    void hideProgress();

    void showMessage(String msg);
}