package com.daybreak.androidsample.loader.applist;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.daybreak.androidsample.BaseToolBarActivity;
import com.daybreak.androidsample.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AppListLoaderActivity extends BaseToolBarActivity
        implements SearchView.OnQueryTextListener, SearchView.OnCloseListener, LoaderManager.LoaderCallbacks<List<AppEntry>> {

    @BindView(R.id.recycler_view)
    RecyclerView mRecycleView;

    // This is the Adapter being used to display the list's data.
    AppListAdapter mAdapter;

    // The SearchView for doing filtering.
    SearchView mSearchView;

    // If non-null, this is the current filter the user has provided.
    String mCurFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("App List Loader");
        setContentLayout(R.layout.activity_content_app_list_loader);

        ButterKnife.bind(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        mRecycleView.setLayoutManager(gridLayoutManager);
        mAdapter = new AppListAdapter(this);
        mAdapter.setOnItemClickListener((positon, data) -> {
            Toast.makeText(this, "Item clicked: " + positon,
                    Toast.LENGTH_SHORT).show();
        });
        mRecycleView.setAdapter(mAdapter);

        getSupportLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<List<AppEntry>> onCreateLoader(int id, Bundle args) {
        return new AppListLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<AppEntry>> loader, List<AppEntry> data) {
        mAdapter.setData(data);
    }

    @Override
    public void onLoaderReset(Loader<List<AppEntry>> loader) {
        mAdapter.setData(null);
    }

    @Override
    public boolean onClose() {
        if (!TextUtils.isEmpty(mSearchView.getQuery())) {
            mSearchView.setQuery(null, true);
        }
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        mCurFilter = !TextUtils.isEmpty(newText) ? newText : null;
        // mAdapter.getFilter().filter(mCurFilter);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_list_loader_menu_toolbar_layout, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);
        searchView.setIconifiedByDefault(true);
        mSearchView = searchView;

        return true;
    }

}
