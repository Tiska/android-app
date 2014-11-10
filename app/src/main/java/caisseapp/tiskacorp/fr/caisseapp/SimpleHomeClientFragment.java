package caisseapp.tiskacorp.fr.caisseapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import caisseapp.tiskacorp.fr.caisseapp.beans.Client;

/**
 * Created by Tiska on 10/11/2014.
 */

public class SimpleHomeClientFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SimpleHomeClientFragment newInstance(int sectionNumber) {
        SimpleHomeClientFragment fragment = new SimpleHomeClientFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public SimpleHomeClientFragment() {
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
