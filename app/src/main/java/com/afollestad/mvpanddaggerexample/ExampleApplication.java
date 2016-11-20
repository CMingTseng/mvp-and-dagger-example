package com.afollestad.mvpanddaggerexample;

import android.app.Application;

import com.afollestad.mvpanddaggerexample.activities.MainActivity;
import com.afollestad.mvpanddaggerexample.modules.InteractorModule;
import com.afollestad.mvpanddaggerexample.modules.PresenterModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Aidan Follestad (afollestad)
 */
public class ExampleApplication extends Application {

    private ApplicationComponent component;

    /**
     * Newly added modules must be added to the @Component annotation here. You must also provide
     * further inject() methods for new classes that want to perform injection.
     */
    @Singleton
    @Component(modules = {InteractorModule.class, PresenterModule.class})
    public interface ApplicationComponent {
        void inject(MainActivity mainActivity);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // This setups up the component which is used by other views (activities/fragments/etc., not Android views) for injection.
        // This pulls all modules which have statically declared @Provides methods automatically.
        component = DaggerExampleApplication_ApplicationComponent.builder().build();
    }

    public ApplicationComponent component() {
        return component;
    }
}