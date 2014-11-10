package caisseapp.tiskacorp.fr.caisseapp;

import android.app.Activity;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ImageButton;


public class HomeActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.home, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {


            View rootView = null;

            Integer frag = (Integer)this.getArguments().get(ARG_SECTION_NUMBER);

            switch(frag){
                case 1:
                    rootView = inflater.inflate(R.layout.fragment_home_caisse, container, false);
                    break;
                case 2:
                    rootView = inflater.inflate(R.layout.fragment_home_new_products, container, false);
                    break;
                case 3:
                    rootView = inflater.inflate(R.layout.fragment_home_caisse, container, false);
                    break;
                default:
                    rootView = inflater.inflate(R.layout.fragment_home_caisse, container, false);
            }


            //traiter les diférents cas

            if(frag==1){
                final ImageButton button = (ImageButton) rootView.findViewById(R.id.imageButton);
                final ImageButton button2 = (ImageButton) rootView.findViewById(R.id.imageButton2);
                final ImageButton button3 = (ImageButton) rootView.findViewById(R.id.imageButton3);
                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        //fragment du formulaire ou du nom
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        //ft.setCustomAnimations(R.animator.fade_in,R.animator.fade_in);
                        ft.replace(R.id.container2,  SimpleHomeClientFragment.newInstance(1));
                        ft.commit();

                    }});

                button2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        //fragment du formulaire ou du nom
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        //ft.setCustomAnimations(R.animator.fade_in,R.animator.fade_in);
                        ft.replace(R.id.container2,  SimpleHomeClientFragment.newInstance(2));
                        ft.commit();

                    }});
            }
            if(frag==2){
                final ImageButton button = (ImageButton) rootView.findViewById(R.id.imageButton);
                final ImageButton button2 = (ImageButton) rootView.findViewById(R.id.imageButton2);
                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        //fragment du formulaire ou du nom
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        //ft.setCustomAnimations(R.animator.fade_in,R.animator.fade_in);
                        ft.replace(R.id.container2,  SimpleHomeCategoriesProductFragment.newInstance(1));
                        ft.commit();

                    }});

                button2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        //fragment du formulaire ou du nom
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        //ft.setCustomAnimations(R.animator.fade_in,R.animator.fade_in);
                        ft.replace(R.id.container2,  SimpleHomeCategoriesProductFragment.newInstance(2));
                        ft.commit();

                    }});
            }



            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((HomeActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }



    }



}
