package usuario.example.tpanexoa.Models;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import usuario.example.tpanexoa.R;

public class Dialogo {

    public static void mostrarDialogo(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Título del diálogo");
        builder.setMessage("Mensaje del diálogo");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Acción a realizar cuando se hace click en "Aceptar"
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Acción a realizar cuando se hace click en "Cancelar"
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}