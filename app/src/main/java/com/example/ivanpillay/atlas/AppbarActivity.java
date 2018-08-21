package com.example.ivanpillay.atlas;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class AppbarActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
        boolean dialogs = false;
        if (id == R.id.user_nav_logout) {
            Fragment frag = fragmentManager.findFragmentByTag(LogoutDialogFragment.TAG);
            if (frag != null) {
                fragmentManager.beginTransaction().remove(frag).commit();
            }
            LogoutDialogFragment logoutFragment = LogoutDialogFragment.newInstance();
            logoutFragment.show(fragmentManager, LogoutDialogFragment.TAG);
            dialogs = true;
        } else if (id == R.id.user_nav_about) {
            Fragment frag = fragmentManager.findFragmentByTag(AboutDialogFragment.TAG);
            if (frag != null) {
                fragmentManager.beginTransaction().remove(frag).commit();
            }
            AboutDialogFragment aboutFragment = AboutDialogFragment.newInstance();
            aboutFragment.show(fragmentManager, AboutDialogFragment.TAG);
            dialogs = true;
        }

        if(!dialogs) {
            Class fragmentClass = null;
            Fragment fragment = null;

            if (id == R.id.user_nav_notification) {
                fragmentClass = NotificationFragment.class;
            } else if (id == R.id.user_nav_account) {
                fragmentClass = UserAccountFragment.class;
            } else if (id == R.id.user_nav_settings) {
                fragmentClass = SettingsFragment.class;
            } else if (id == R.id.user_nav_contactus) {
                fragmentClass = ContactUsFragment.class;
            }

            if (fragmentClass != null) {
                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (fragment != null) {
                    fragmentManager.beginTransaction().replace(R.id.u_frame_layout, fragment).commit();
                }
            }
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.u_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
