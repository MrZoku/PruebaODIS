package com.who.organizadortarea;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TareaAdapter extends RecyclerView.Adapter<TareaAdapter.TareaViewHolder> {
    private List<Tarea> tareas;

    public static class TareaViewHolder extends RecyclerView.ViewHolder {
        public CheckBox checkBoxTarea;
        public TextView textViewNombre;

        public TareaViewHolder(View itemView) {
            super(itemView);
            checkBoxTarea = itemView.findViewById(R.id.checkBoxTarea);
            textViewNombre = itemView.findViewById(R.id.textViewNombre);
        }
    }

    public TareaAdapter(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    @NonNull
    @Override
    public TareaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tarea, parent, false);
        return new TareaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TareaViewHolder holder, int position) {
        Tarea tarea = tareas.get(position);
        holder.checkBoxTarea.setChecked(tarea.isCompletada());
        holder.textViewNombre.setText(tarea.getNombre());
    }

    @Override
    public int getItemCount() {
        return tareas.size();
    }
}

