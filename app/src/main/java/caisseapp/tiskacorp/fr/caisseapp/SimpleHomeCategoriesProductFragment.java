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
import caisseapp.tiskacorp.fr.caisseapp.beans.PrestationType;
import caisseapp.tiskacorp.fr.caisseapp.beans.ProduitType;

/**
 * Created by Tiska on 10/11/2014.
 */

public class SimpleHomeCategoriesProductFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SimpleHomeCategoriesProductFragment newInstance(int sectionNumber) {
        SimpleHomeCategoriesProductFragment fragment = new SimpleHomeCategoriesProductFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public SimpleHomeCategoriesProductFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //avec ça créer la vue qui va bien avec le drawer
        View rootView = null;

        Integer frag = (Integer)this.getArguments().get(ARG_SECTION_NUMBER);

        switch(frag){
            case 1:
                rootView = inflater.inflate(R.layout.fragment_home_caisse_list_categories_parent, container, false);
                break;
            case 2:
                rootView = inflater.inflate(R.layout.fragment_home_caisse_list_categories_parent, container, false);
                break;
            default:
                rootView = inflater.inflate(R.layout.fragment_home_caisse_list_categories_parent, container, false);
        }


        if(frag==1){


            final ListView prestations = (ListView)rootView.findViewById(R.id.listView);

            EditText inputSearch = (EditText)rootView.findViewById(R.id.inputSearch);

            List<PrestationType> prestationsTypeList = PrestationType.listAll(PrestationType.class);

            final ArrayList<String> prestationName = new ArrayList<String>();

            for(PrestationType presta :prestationsTypeList){
                if(presta.getLibelle()!=null){
                    prestationName.add(presta.getLibelle());
                }

            }

            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                    R.layout.list_view_client, R.id.textViewNom, prestationName.toArray(new String[prestationName.size()]));

            prestations.setAdapter(adapter);

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

            prestations.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position,long arg3) {
                    view.setSelected(true);

                }
            });

            prestations.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

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

                            prestationName.remove(arg2);
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

        if(frag==2){

            final ListView products = (ListView)rootView.findViewById(R.id.listView);

            EditText inputSearch = (EditText)rootView.findViewById(R.id.inputSearch);

            List<ProduitType> productsTypeList = ProduitType.listAll(ProduitType.class);

            final ArrayList<String> productsName = new ArrayList<String>();
            for(ProduitType produit :productsTypeList){
                if(produit.getLibelle()!=null){
                    productsName.add(produit.getLibelle());
                }

            }

            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                    R.layout.list_view_client, R.id.textViewNom, productsName.toArray(new String[productsName.size()]));

            products.setAdapter(adapter);

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

            products.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position,long arg3) {
                    view.setSelected(true);

                }
            });

            products.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

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

                            productsName.remove(arg2);
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
