package com.afollestad.mvpanddaggerexample.interactors;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aidan Follestad (afollestad)
 */
public class ItemsInteractorImpl implements ItemsInteractor {

    @Override
    public void loadItems(LoadListener listener) {
        List<String> items = new ArrayList<>();
        items.add("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/Android_robot.svg/2000px-Android_robot.svg.png");
        items.add("https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/2000px-Google_%22G%22_Logo.svg.png");
        items.add("http://logodatabases.com/wp-content/uploads/2012/03/target-logo.png");
        items.add("http://design.ubuntu.com/wp-content/uploads/ubuntu-logo32.png");
        items.add("https://www.nowmd.com/wp-content/uploads/Microsoft-Logo.png");
        items.add("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f5/Best_Buy_Logo.svg/1280px-Best_Buy_Logo.svg.png");
        listener.onLoaded(items);
    }
}