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

    public MiPerfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MiPerfilFragment.
     */
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
        }

        /*String carpetaFuente = "fonts/galette-med.otf";
        Typeface fuentePerfil = Typeface.createFromAsset(getActivity().getAssets(), carpetaFuente);


        EditText txt_nombre = getActivity().findViewById(R.id.txt_nombre);
        EditText txt_colegio = getActivity().findViewById(R.id.txt_colegio);
        EditText txt_ciudad = getActivity().findViewById(R.id.txt_ciudad);
        EditText txt_mail = getActivity().findViewById(R.id.txt_mail);
        EditText txt_contrasenia = getActivity().findViewById(R.id.txt_contrasenia);

        txt_nombre.setTypeface(fuentePerfil);
        txt_colegio.setTypeface(fuentePerfil);
        txt_ciudad.setTypeface(fuentePerfil);
        txt_mail.setTypeface(fuentePerfil);
        txt_contrasenia.setTypeface(fuentePerfil);*/


      /*  final Button buttonGuardar = getActivity().findViewById(R.id.btn_guardar);
        //buttonGuardar.setTypeface(fuentePerfil);
        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d (tag,"Si llamo a la funcion");
                Toast.makeText(getActivity(), "Se Guardo correctamente", Toast.LENGTH_SHORT).show();
                Intent intent05 = new Intent(getActivity().getApplicationContext(),CursosActivity.class);
                startActivity(intent05);
            }
        });

        final Button buttonCancelar = getActivity().findViewById(R.id.btn_cancelar);
        //buttonCancelar.setTypeface(fuentePerfil);
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d (tag,"Si llamo a la funcion");
                Toast.makeText(getActivity(), "Se Cancelo correctamente", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity().getApplicationContext(), CursosActivity.class);
                startActivity(intent);
            }
        });*/

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
