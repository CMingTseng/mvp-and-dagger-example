package com.afollestad.mvpanddaggerexample.presenters;

import com.afollestad.mvpanddaggerexample.interactors.ItemsInteractor;
import com.afollestad.mvpanddaggerexample.views.MainViews;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Aidan Follestad (afollestad)
 */
public class MainPresenterImpl implements MainPresenter, ItemsInteractor.LoadListener {

    private ItemsInteractor itemsInteractor;
    private MainViews views;

    @Inject
    public MainPresenterImpl(ItemsInteractor itemsInteractor) {
        this.itemsInteractor = itemsInteractor;
    }

    @Override
    public void onResume(MainViews views) {
        this.views = views;
        views.showProgress();
        itemsInteractor.loadItems(this);
    }

    @Override
    public void onItemClicked(int index) {
        views.showMessage("Clicked item: " + index);
    }

    @Override
    public void onPause() {
        views = null;
    }

    @Override
    public void onLoaded(List<String> items) {
        views.setItems(items);
        views.hideProgress();
    }
}