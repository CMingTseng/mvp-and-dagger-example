package com.afollestad.mvpanddaggerexample.modules;

import com.afollestad.mvpanddaggerexample.interactors.ItemsInteractor;
import com.afollestad.mvpanddaggerexample.interactors.ItemsInteractorImpl;

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
public class InteractorModule {

    @Provides
    @Singleton
    static ItemsInteractor provideItems() {
        return new ItemsInteractorImpl();
    }
}