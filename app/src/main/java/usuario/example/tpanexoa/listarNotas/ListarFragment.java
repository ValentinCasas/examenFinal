package usuario.example.tpanexoa.listarNotas;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import usuario.example.tpanexoa.R;
import usuario.example.tpanexoa.cargarNotas.CargarViewModel;
import usuario.example.tpanexoa.databinding.FragmentCargarBinding;
import usuario.example.tpanexoa.databinding.FragmentListarBinding;

public class ListarFragment extends Fragment {

    private ListarViewModel mViewModel;
    private FragmentListarBinding binding;
    private NotaAdapter mAdapter;

    public static ListarFragment newInstance() {
        return new ListarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentListarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter = new NotaAdapter(new ArrayList<>());
        RecyclerView rvNotas = binding.rvNotas;
        rvNotas.setLayoutManager(new LinearLayoutManager(getContext()));
        rvNotas.setAdapter(mAdapter);

        mViewModel = new ViewModelProvider(this).get(ListarViewModel.class);
        mViewModel.getListaNotas().observe(getViewLifecycleOwner(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> notas) {
                mAdapter.setNotas(notas);
            }
        });

        // Llamar a cargarNotas() después de haber creado la instancia de mViewModel
        mViewModel.cargarNotas();
    }
}


