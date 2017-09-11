package app.proyecto.crianbra.proyecto_moviles;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crianbra.proyecto_moviles.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MiPerfilFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MiPerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MiPerfilFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    String tag = "Lifecycle";

    private OnFragmentInteractionListener mListener;
    //private String bundle;
    private String bundle;

    public MiPerfilFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static MiPerfilFragment newInstance(String param1, String param2) {
        MiPerfilFragment fragment = new MiPerfilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


           //bundle = getArguments().getString("name");
            //String nombre = bundle.getString("name");

        }
        EditText txt_colegio = getActivity().findViewById(R.id.txt_colegio);
        EditText txt_ciudad = getActivity().findViewById(R.id.txt_ciudad);
        EditText txt_mail = getActivity().findViewById(R.id.txt_mail);
        EditText txt_contrasenia = getActivity().findViewById(R.id.txt_edad);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //EditText txt_nombre = getActivity().findViewById(R.id.txt_nombre);
        //txt_nombre.setText(bundle);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mi_perfil, container, false);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
