package caisseapp.tiskacorp.fr.caisseapp;

import android.app.Activity;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import caisseapp.tiskacorp.fr.caisseapp.beans.Client;


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
                    rootView = inflater.inflate(R.layout.fragment_home_caisse, container, false);
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
                        ft.replace(R.id.container2,  SimpleHomeFragment.newInstance(1));
                        ft.commit();

                    }});

                button2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        //fragment du formulaire ou du nom
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        //ft.setCustomAnimations(R.animator.fade_in,R.animator.fade_in);
                        ft.replace(R.id.container2,  SimpleHomeFragment.newInstance(2));
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


    public static class SimpleHomeFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static SimpleHomeFragment newInstance(int sectionNumber) {
            SimpleHomeFragment fragment = new SimpleHomeFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public SimpleHomeFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            //avec ça créer la vue qui va bien avec le drawer
            View rootView = null;

            Integer frag = (Integer)this.getArguments().get(ARG_SECTION_NUMBER);

            switch(frag){
                case 1:
                    rootView = inflater.inflate(R.layout.fragment_home_caisse_nouveau_client, container, false);
                    break;
                case 2:
                    rootView = inflater.inflate(R.layout.fragment_home_caisse_list_client, container, false);
                    break;
                case 3:
                    rootView = inflater.inflate(R.layout.fragment_home_caisse_nouveau_client, container, false);
                    break;
                default:
                    rootView = inflater.inflate(R.layout.fragment_home_caisse_nouveau_client, container, false);
            }


            if(frag==1){

                final EditText nom = (EditText)rootView.findViewById(R.id.editNom);
                final EditText prenom = (EditText)rootView.findViewById(R.id.editPrenom);
                final EditText phone = (EditText)rootView.findViewById(R.id.editPhone);
                final EditText adresse = (EditText)rootView.findViewById(R.id.editAdresse);
                final EditText codePostal = (EditText)rootView.findViewById(R.id.editCode);
                final EditText ville = (EditText)rootView.findViewById(R.id.editVille);
                final EditText email = (EditText)rootView.findViewById(R.id.editEmail);
                final DatePicker birthday = (DatePicker)rootView.findViewById(R.id.datePicker);

                final Button button = (Button) rootView.findViewById(R.id.button);

                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        Client client = new Client();
                        if(nom.getText().toString().isEmpty() && prenom.getText().toString().isEmpty()){
                            Toast toast = new Toast(getActivity());
                            toast.makeText(getActivity(),"Le client doit au moins avoir un nom et un prénom !",Toast.LENGTH_LONG);
                            toast.setView(getActivity().getCurrentFocus());
                            toast.show();
                        }
                        client.setNom(nom.getText().toString());
                        client.setPrenom(prenom.getText().toString());
                        client.setAdresse(adresse.getText().toString());
                        if(!phone.getText().toString().isEmpty()){
                            client.setPhone(Integer.valueOf(phone.getText().toString()));
                        }
                        client.setCodePostal(codePostal.getText().toString());
                        client.setVille(ville.getText().toString());
                        client.setEmail(email.getText().toString());

                        int   day  = birthday.getDayOfMonth();
                        int   month= birthday.getMonth();
                        int   year = birthday.getYear();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                        String formatedDate = sdf.format(new Date(year, month, day));
                        try {
                            Date date = sdf.parse(formatedDate);
                            client.setBirthday(date);
                        } catch (ParseException e) {
                            Toast toast = new Toast(getActivity());
                            toast.makeText(getActivity(),"Erreur de parsing de la date",Toast.LENGTH_LONG);
                            toast.setView(getActivity().getCurrentFocus());
                            toast.show();

                        }

                        if(!nom.getText().toString().isEmpty() && !prenom.getText().toString().isEmpty()){
                            client.save();
                            Toast toast = new Toast(getActivity());
                            toast.makeText(getActivity(),"Client enregistré !",Toast.LENGTH_LONG);
                            toast.setView(getActivity().getCurrentFocus());
                            toast.show();

                        }


                    }});

            }

            if(frag==2){

                final ListView clients = (ListView)rootView.findViewById(R.id.listView);

                EditText inputSearch = (EditText)rootView.findViewById(R.id.inputSearch);

                List<Client> clientsList = Client.listAll(Client.class);

                final ArrayList<String> clientsNom = new ArrayList<String>();
                for(Client client :clientsList){
                    if(client.getNom()!=null){
                        clientsNom.add(client.getNom().toString()+" "+client.getPrenom());
                    }

                }

                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                R.layout.list_view_client, R.id.textViewNom, clientsNom.toArray(new String[clientsNom.size()]));

                clients.setAdapter(adapter);

                final ArrayAdapter<String> finalAdapter = adapter;
                inputSearch.addTextChangedListener(new TextWatcher() {

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        finalAdapter.getFilter().filter(s);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

                clients.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position,long arg3) {
                        view.setSelected(true);

                    }
                });

                clients.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view,
                                                   final int arg2, long arg3) {


                        AlertDialog.Builder alert = new AlertDialog.Builder(
                                getActivity());
                        alert.setTitle("Alert!!");
                        alert.setMessage("Voulez vous supprimer ce client ?");
                        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //do your work here

                                clientsNom.remove(arg2);
                                adapter.notifyDataSetChanged();

                                dialog.dismiss();

                            }
                        });
                        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.dismiss();
                            }
                        });

                        alert.show();


                        return false;
                    }

                });

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
