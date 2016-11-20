package com.afollestad.mvpanddaggerexample.modules;

import com.afollestad.mvpanddaggerexample.interactors.ItemsInteractor;
import com.afollestad.mvpanddaggerexample.presenters.MainPresenter;
import com.afollestad.mvpanddaggerexample.presenters.MainPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Modules aren't used by you directly, they're used by Dagger. @Provides annotated methods are
 * used to lookup classes during injection. @Singleton indicates that only one instance of the object
 * is used, and used everywhere when injected.
 *
 * @author Aidan Follestad (afollestad)
 */
@Module
public class PresenterModule {

    @Provides
    @Singleton
    static MainPresenter providesMain(ItemsInteractor itemsInteractor) {
        // The parameter here is injected by dagger also, no need to provide it.
        return new MainPresenterImpl(itemsInteractor);
    }
}