package com.example.ivanpillay.atlas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class UserActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private BottomNavigationView bottomNavigationView;

    //  private static Button students, institute, schedule, documents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.u_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.u_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        bottomNavigationView = findViewById(R.id.u_nav_bottom_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Class fragmentClass = null;
                Fragment fragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.nav_bottom_home:
                        fragmentClass = UserHomeFragment.class;
                        break;
                    case R.id.nav_bottom_students:
                        fragmentClass = StudentsFragment.class;
                        break;
                    case R.id.nav_bottom_schedule:
                        fragmentClass = ScheduleFragment.class;
                        break;
                    case R.id.nav_bottom_documents:
                        fragmentClass = DocumentsFragment.class;
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
                return true;
            }
        });
        Fragment initial = fragmentManager.findFragmentById(R.id.u_frame_layout);
        if (initial == null) {
            fragmentManager.beginTransaction().replace(R.id.u_frame_layout, UserHomeFragment.newInstance()).commit();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.u_drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_menu) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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

        if (!dialogs) {
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
