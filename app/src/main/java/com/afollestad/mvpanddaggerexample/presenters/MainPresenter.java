package com.afollestad.mvpanddaggerexample.presenters;

import com.afollestad.mvpanddaggerexample.views.MainViews;

/**
 * A presenter is the middle-man, and the 'P' in MVP. It sits between the UI (View) layer and Data (Model) layer.
 * The implementation class is instantiated by Dagger.
 *
 * @author Aidan Follestad (afollestad)
 */
public interface MainPresenter {

    void onResume(MainViews views);

    void onItemClicked(int index);

    void onPause();
}