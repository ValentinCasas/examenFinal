package usuario.example.tpanexoa.listarNotas;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import usuario.example.tpanexoa.cargarNotas.CargarViewModel;

public class ListarViewModel extends AndroidViewModel {

    private MutableLiveData<List<String>> listaNotas;

    public ListarViewModel(@NonNull Application application) {
        super(application);
        listaNotas = new MutableLiveData<>();
        cargarNotas();
    }

    public LiveData<List<String>> getListaNotas() {
        return listaNotas;
    }

    public void cargarNotas() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplication().getApplicationContext());
        Set<String> notas = prefs.getStringSet("notas", new HashSet<String>());
        ArrayList<String> listaNotas = new ArrayList<>(notas);
        Collections.sort(listaNotas, new Comparator<String>() {
            @Override
            public int compare(String nota1, String nota2) {
                return nota1.compareToIgnoreCase(nota2);
            }
        });
        this.listaNotas.postValue(listaNotas);
    }


    public void agregarNota(String nota) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplication().getApplicationContext());
        SharedPreferences.Editor editor = prefs.edit();
        Set<String> notas = prefs.getStringSet("notas", new HashSet<String>());
        notas.add(nota);
        editor.putStringSet("notas", notas);
        editor.apply();
        cargarNotas();
    }

}

