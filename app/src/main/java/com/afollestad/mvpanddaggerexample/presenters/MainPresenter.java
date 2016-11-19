package com.afollestad.mvpanddaggerexample.presenters;

import com.afollestad.mvpanddaggerexample.views.MainViews;

/**
 * @author Aidan Follestad (afollestad)
 */
public interface MainPresenter {

    void onResume(MainViews views);

    void onItemClicked(int index);

    void onPause();
}