package com.example.mobylabtema1;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import static com.example.mobylabtema1.Constants.LOCATION_X;
import static com.example.mobylabtema1.Constants.LOCATION_Y;
import static com.example.mobylabtema1.Utils.displayToast;
import static com.example.mobylabtema1.Utils.startMaps;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set title
        setTitle(R.string.awesome_app_title);

        // Set toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Add FAB and set listener
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, R.string.awesome_text, Snackbar.LENGTH_SHORT)
                        .setAction("More", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                displayToast(MainActivity.this, R.string.everyone_awesome_text);
                            }
                        })
                        .show();
            }
        });

        // Add Drawer Layout
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        if (drawer != null) {
            drawer.addDrawerListener(drawerToggle);
        }

        drawerToggle.syncState();

        // Add Navigation View listener
        NavigationView navigationView = findViewById(R.id.nav_view);

        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }

        // Get UI elements
        final RadioGroup radioGroup = findViewById(R.id.radio_group);
        final CheckBox checkBox1 = findViewById(R.id.check_box1);
        final CheckBox checkBox2 = findViewById(R.id.check_box2);
        final ToggleButton toggleButton = findViewById(R.id.toggle_button);
        final EditText editText = findViewById(R.id.edit_text);
        final Button saveButton = findViewById(R.id.save_button);

        // Add save button listener
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder message = new StringBuilder();
                int checkedButton = radioGroup.getCheckedRadioButtonId();

                switch (checkedButton) {
                    case R.id.radio_button1:
                        message.append(getString(R.string.first_rb_selected));
                        break;

                    case R.id.radio_button2:
                        message.append(getString(R.string.second_rb_selected));
                        break;

                    case R.id.radio_button3:
                        message.append(getString(R.string.third_rb_selected));
                        break;
                }

                if (checkBox1.isChecked()) {
                    message.append(getString(R.string.first_cb_selected));
                }

                if (checkBox2.isChecked()) {
                    message.append(getString(R.string.second_cb_selected));
                }

                if (toggleButton.isChecked()) {
                    message.append(getString(R.string.toggle_button_on));
                } else {
                    message.append(getString(R.string.toggle_button_off));
                }

                String text = editText.getText().toString();
                message.append(text.equals("") ?
                        getString(R.string.no_text) : getString(R.string.text_is) + text);

                Log.v(TAG, message.toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        switch (item.getItemId()) {
            case R.id.nav_google_maps:
                drawerLayout.closeDrawer(GravityCompat.START);
                startMaps(this, LOCATION_X, LOCATION_Y);
                return true;
            default:
                return false;
        }
    }

    public void showToastMessage(MenuItem item) {
        displayToast(this, R.string.awesome_text);
    }

    public void showAlertDialogMessage(MenuItem item) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);

        alertBuilder.setTitle(R.string.alert_title)
                .setMessage(R.string.awesome_text)
                .setPositiveButton(R.string.yes_button_text, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        displayToast(MainActivity.this, R.string.everyone_awesome_text);
                    }
                })
                .setNegativeButton(R.string.no_button_text, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        displayToast(MainActivity.this, R.string.sad_text);
                    }
                })
                .show();
    }
}