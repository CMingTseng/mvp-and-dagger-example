package com.afollestad.mvpanddaggerexample.modules;

import android.content.Context;

import com.afollestad.mvpanddaggerexample.ExampleApplication;
import com.afollestad.mvpanddaggerexample.annotations.ForApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Aidan Follestad (afollestad)
 */
@Module
public class AndroidModule {

    private final ExampleApplication application;

    public AndroidModule(ExampleApplication application) {
        this.application = application;
    }

    /**
     * Allow the application context to be injected but require that it be annotated with
     * {@link ForApplication @Annotation} to explicitly differentiate it from an activity context.
     */
    @Provides
    @Singleton
    @ForApplication
    Context provideApplicationContext() {
        return application;
    }
}