package com.who.organizadortarea;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerCategorias;
    private RecyclerView recyclerViewTareas;
    private TareaAdapter tareaAdapter;
    private List<Tarea> listaTareas;
    private EditText editTextNuevaTarea;
    private Button buttonAgregarTarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerCategorias = findViewById(R.id.spinnerCategorias);
        recyclerViewTareas = findViewById(R.id.recyclerViewTareas);
        editTextNuevaTarea = findViewById(R.id.editTextNuevaTarea);
        buttonAgregarTarea = findViewById(R.id.buttonAgregarTarea);

        // Configurar Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.categorias_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategorias.setAdapter(adapter);

        // Configurar RecyclerView
        recyclerViewTareas.setLayoutManager(new LinearLayoutManager(this));

        // Crear una lista de tareas de ejemplo
        listaTareas = new ArrayList<>();
        listaTareas.add(new Tarea("Tarea 1", false));
        listaTareas.add(new Tarea("Tarea 2", true));

        // Configurar el Adapter
        tareaAdapter = new TareaAdapter(listaTareas);
        recyclerViewTareas.setAdapter(tareaAdapter);

        // Configurar botón de agregar tarea
        buttonAgregarTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tareaNombre = editTextNuevaTarea.getText().toString();
                if (!tareaNombre.isEmpty()) {
                    listaTareas.add(new Tarea(tareaNombre, false));
                    tareaAdapter.notifyDataSetChanged();
                    editTextNuevaTarea.setText("");
                }
            }
        });
    }
}
