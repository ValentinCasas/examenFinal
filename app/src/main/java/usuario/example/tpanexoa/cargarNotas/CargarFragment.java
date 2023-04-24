package usuario.example.tpanexoa.cargarNotas;

import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import usuario.example.tpanexoa.R;
import usuario.example.tpanexoa.databinding.FragmentCargarBinding;
import usuario.example.tpanexoa.listarNotas.ListarViewModel;

public class CargarFragment extends Fragment {

    private CargarViewModel cargarViewModel;
    private ListarViewModel listarViewModel;
    private FragmentCargarBinding binding;

    public static CargarFragment newInstance() {
        return new CargarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentCargarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button btnAgregar = binding.btnAgregar;
        EditText etNota = binding.etNota;

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nuevaNota = etNota.getText().toString().trim();
                cargarViewModel.agregarNota(nuevaNota);
                listarViewModel.agregarNota(nuevaNota);
                etNota.setText("");
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        cargarViewModel = new ViewModelProvider(this).get(CargarViewModel.class);
        listarViewModel = new ViewModelProvider(this).get(ListarViewModel.class);
    }
}


