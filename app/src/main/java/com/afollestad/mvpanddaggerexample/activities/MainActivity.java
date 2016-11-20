package com.afollestad.mvpanddaggerexample.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.afollestad.mvpanddaggerexample.ExampleApplication;
import com.afollestad.mvpanddaggerexample.R;
import com.afollestad.mvpanddaggerexample.adapters.MainAdapter;
import com.afollestad.mvpanddaggerexample.presenters.MainPresenter;
import com.afollestad.mvpanddaggerexample.views.MainViews;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements MainViews, MainAdapter.ClickListener {

    @Inject
    MainPresenter presenter;
    MainAdapter adapter;
    Unbinder unbinder;

    @BindView(R.id.list)
    RecyclerView recyclerView;
    @BindView(R.id.progress)
    ProgressBar progressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // The component setup in the ExampleApplication takes all Module classes and fills in @Inject
        // annotated fields for you automatically.
        ((ExampleApplication) getApplication()).component().inject(this);

        adapter = new MainAdapter(this);

        // Dagger does not provide View injection, so we use ButterKnife for that.
        unbinder = ButterKnife.bind(this);

        recyclerView.setLayoutManager(new GridLayoutManager(this, getResources().getInteger(R.integer.grid_width)));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Tell the main Presenter that the View layer is visible.
        presenter.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Tell the main Presenter that the View layer is going away.
        presenter.onPause();

        if (isFinishing()) {
            unbinder.unbind();
            unbinder = null;
        }
    }

    @Override
    public void showProgress() {
        progressView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void setItems(List<String> items) {
        adapter.setItems(items);
    }

    @Override
    public void hideProgress() {
        progressView.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    // This click listener is from the RecyclerView adapter that we setup.
    @Override
    public void onClick(int index) {
        presenter.onItemClicked(index);
    }
}