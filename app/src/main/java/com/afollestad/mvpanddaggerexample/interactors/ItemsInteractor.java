package com.afollestad.mvpanddaggerexample.interactors;

import java.util.List;

/**
 * @author Aidan Follestad (afollestad)
 */
public interface ItemsInteractor {

    interface LoadListener {
        void onLoaded(List<String> items);
    }

    void loadItems(LoadListener listener);
}