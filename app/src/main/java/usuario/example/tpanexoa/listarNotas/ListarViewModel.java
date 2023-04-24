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

import usuario.example.tpanexoa.MiMenu;
import usuario.example.tpanexoa.cargarNotas.CargarViewModel;

public class ListarViewModel extends AndroidViewModel {

    public ListarViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<ArrayList<String>> getListaNotas() {
        MutableLiveData<ArrayList<String>> liveData = new MutableLiveData<>();
        ArrayList<String> notasOrdenadas = new ArrayList<>(MiMenu.notas);
        Collections.sort(notasOrdenadas, String.CASE_INSENSITIVE_ORDER);
        liveData.setValue(notasOrdenadas);
        return liveData;
    }



}


