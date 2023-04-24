package usuario.example.tpanexoa.cargarNotas;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import usuario.example.tpanexoa.listarNotas.ListarViewModel;

public class CargarViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<String>> listaNotas;
    private ListarViewModel listarViewModel;

    public CargarViewModel(@NonNull Application application) {
        super(application);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplication());
        Set<String> notasExistentes = prefs.getStringSet("notas", new HashSet<String>());
        listaNotas = new MutableLiveData<>(new ArrayList<>(notasExistentes));
        listarViewModel = new ListarViewModel(application);
    }

    public LiveData<ArrayList<String>> getListaNotas() {
        return listaNotas;
    }

    public void agregarNota(String nuevaNota) {
        if (!nuevaNota.trim().isEmpty()) {
            ArrayList<String> notas = listaNotas.getValue();
            notas.add(nuevaNota);

            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplication());
            Set<String> notasExistentes = new HashSet<>(notas);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putStringSet("notas", notasExistentes);
            editor.apply();

            listaNotas.setValue(notas);
            listarViewModel.cargarNotas();
        } else {
            Toast.makeText(getApplication(), "No se puede agregar una nota vacía", Toast.LENGTH_SHORT).show();
        }
    }

}

