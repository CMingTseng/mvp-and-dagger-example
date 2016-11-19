package com.afollestad.mvpanddaggerexample;

import android.app.Application;

import com.afollestad.mvpanddaggerexample.activities.MainActivity;
import com.afollestad.mvpanddaggerexample.modules.AndroidModule;
import com.afollestad.mvpanddaggerexample.modules.InteractorModule;
import com.afollestad.mvpanddaggerexample.modules.PresenterModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Aidan Follestad (afollestad)
 */
public class ExampleApplication extends Application {

    private ApplicationComponent component;

    @Singleton
    @Component(modules = {AndroidModule.class, InteractorModule.class, PresenterModule.class})
    public interface ApplicationComponent {
        void inject(ExampleApplication application);

        void inject(MainActivity mainActivity);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerExampleApplication_ApplicationComponent.builder().build();
        component().inject(this);
    }

    public ApplicationComponent component() {
        return component;
    }
}