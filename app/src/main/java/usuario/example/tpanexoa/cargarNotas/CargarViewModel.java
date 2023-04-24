package usuario.example.tpanexoa.cargarNotas;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import usuario.example.tpanexoa.MiMenu;
import usuario.example.tpanexoa.listarNotas.ListarViewModel;

public class CargarViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<String>> listaNotas;
    private MutableLiveData<String> mensajeToast;

    public CargarViewModel(@NonNull Application application) {
        super(application);
        listaNotas = new MutableLiveData<>(MiMenu.notas);
        mensajeToast = new MutableLiveData<>("");
    }

    public LiveData<ArrayList<String>> getListaNotas() {
        return listaNotas;
    }

    public LiveData<String> getMensajeToast() {
        return mensajeToast;
    }

    public void agregarNota(String nuevaNota) {
        if (!nuevaNota.trim().isEmpty()) {
            ArrayList<String> notas = listaNotas.getValue();
            notas.add(nuevaNota);
            listaNotas.setValue(notas);
            MiMenu.notas = notas; // Actualiza el array de notas en MiMenu
        } else {
            Toast.makeText(getApplication(), "No se puede agregar una nota vacía", Toast.LENGTH_SHORT).show();
        }
    }

}



