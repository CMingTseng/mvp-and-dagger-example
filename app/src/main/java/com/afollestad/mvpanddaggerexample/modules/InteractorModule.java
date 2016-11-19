package com.afollestad.mvpanddaggerexample.modules;

import com.afollestad.mvpanddaggerexample.interactors.ItemsInteractor;
import com.afollestad.mvpanddaggerexample.interactors.ItemsInteractorImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Aidan Follestad (afollestad)
 */
@Module
public class InteractorModule {

    @Provides
    @Singleton
    static ItemsInteractor provideItems() {
        return new ItemsInteractorImpl();
    }
}