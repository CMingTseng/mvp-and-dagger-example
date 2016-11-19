package com.afollestad.mvpanddaggerexample.modules;

import com.afollestad.mvpanddaggerexample.interactors.ItemsInteractor;
import com.afollestad.mvpanddaggerexample.presenters.MainPresenter;
import com.afollestad.mvpanddaggerexample.presenters.MainPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Aidan Follestad (afollestad)
 */
@Module
public class PresenterModule {

    @Provides
    @Singleton
    static MainPresenter providesMain(ItemsInteractor itemsInteractor) {
        return new MainPresenterImpl(itemsInteractor);
    }
}