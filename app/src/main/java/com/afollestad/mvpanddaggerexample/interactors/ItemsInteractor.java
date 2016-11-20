package com.afollestad.mvpanddaggerexample.interactors;

import java.util.List;

/**
 * Interactors are the data layer. This interface has an implementation which is instantiated by Dagger.
 *
 * @author Aidan Follestad (afollestad)
 */
public interface ItemsInteractor {

    interface LoadListener {
        void onLoaded(List<String> items);
    }

    void loadItems(LoadListener listener);
}