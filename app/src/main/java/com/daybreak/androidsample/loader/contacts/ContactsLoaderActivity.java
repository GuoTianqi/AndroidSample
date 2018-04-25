package com.daybreak.androidsample.loader.contacts;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.daybreak.androidsample.BaseToolBarActivity;
import com.daybreak.androidsample.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactsLoaderActivity
        extends
        BaseToolBarActivity
        implements
        SearchView.OnQueryTextListener,
        LoaderManager.LoaderCallbacks<Cursor>,
        AdapterView.OnItemClickListener {

    private final static String[] CONTACTS_SUMMARY_PROJECTION = new String[] {
            ContactsContract.Contacts._ID,
            ContactsContract.Contacts.DISPLAY_NAME,
            ContactsContract.Contacts.CONTACT_STATUS,
            ContactsContract.Contacts.CONTACT_PRESENCE,
            ContactsContract.Contacts.PHOTO_ID,
            ContactsContract.Contacts.LOOKUP_KEY,
    };

    private final static int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 0x01;

    @BindView(R.id.list_view)
    ListView mListView;

    private SimpleCursorAdapter mAdapter;
    private String mCurFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentLayout(R.layout.activity_content_contacts_loader);

        ButterKnife.bind(this);

        mAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2, null,
                new String[] {ContactsContract.Contacts.DISPLAY_NAME,
                        ContactsContract.Contacts.CONTACT_STATUS},
                new int[] {android.R.id.text1, android.R.id.text2});

        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {
                Toast.makeText(this, "shouldShowRequestPermission",
                        Toast.LENGTH_SHORT).show();

                ActivityCompat.requestPermissions(this,
                        new String[] { Manifest.permission.READ_CONTACTS },
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[] { Manifest.permission.READ_CONTACTS },
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            }
        } else {
            getSupportLoaderManager().initLoader(0, null, this);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getSupportLoaderManager().initLoader(0, null, this);
                } else {
                    finish();
                }

                return;
            }
            default:
                return;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.loader_contacts_menu_toolbar_layout, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        Uri baseUri;
        if (mCurFilter != null) {
            baseUri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_FILTER_URI,
                    Uri.encode(mCurFilter));
        } else {
            baseUri = ContactsContract.Contacts.CONTENT_URI;
        }

        // Now create and return a CursorLoader that will take care of
        // creating a Cursor for the data being displayed.
        String select = "((" + ContactsContract.Contacts.DISPLAY_NAME + " NOTNULL) AND ("
                + ContactsContract.Contacts.HAS_PHONE_NUMBER + "=1) AND ("
                + ContactsContract.Contacts.DISPLAY_NAME + " != '' ))";
        return new CursorLoader(this, baseUri,
                CONTACTS_SUMMARY_PROJECTION, select, null,
                ContactsContract.Contacts.DISPLAY_NAME + " COLLATE LOCALIZED ASC");
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        mCurFilter = !TextUtils.isEmpty(newText) ? newText : null;
        getSupportLoaderManager().restartLoader(0, null, this);
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Item clicked: " + id, Toast.LENGTH_SHORT).show();
    }
}
