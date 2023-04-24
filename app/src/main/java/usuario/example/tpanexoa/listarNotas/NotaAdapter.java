package usuario.example.tpanexoa.listarNotas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import usuario.example.tpanexoa.R;

public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.ViewHolder> {

    private List<String> mNotas;

    public NotaAdapter(List<String> notas) {
        mNotas = notas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nota, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nota = mNotas.get(position);
        holder.bind(nota);
    }

    @Override
    public int getItemCount() {
        return mNotas.size();
    }

    public void setNotas(List<String> notas) {
        mNotas = notas;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTituloTextView;
        private TextView mDetalleTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTituloTextView = itemView.findViewById(R.id.tvTitulo);
            mDetalleTextView = itemView.findViewById(R.id.tvDetalle);
        }

        public void bind(String nota) {
            mTituloTextView.setText(nota);
            mDetalleTextView.setText(nota);
        }
    }
}
