package com.roberto.guia04;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import static com.roberto.guia04.MainActivity.lstTareas;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Locale;

public class AddTaskActivity extends AppCompatActivity {

    Button btnFecha, btnHora, btnGuardar;
    EditText edtTitulo, edtDescripcion, edtFecha, edtHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_task);

        btnFecha = findViewById(R.id.btnFecha);
        btnHora = findViewById(R.id.btnHora);
        btnGuardar = findViewById(R.id.btnGuardar);
        edtTitulo = findViewById(R.id.edtTitulo);
        edtDescripcion = findViewById(R.id.edtDescripcion);
        edtFecha = findViewById(R.id.edtFecha);
        edtHora = findViewById(R.id.edtHora);

        // Listener para el botón de hora
        btnHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener la hora actual
                final Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(AddTaskActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        String SeleHora = String.format(Locale.getDefault(), "%02d:%02d", hourOfDay, minute);
                        edtHora.setText(SeleHora);
                    }
                }, hour, minute, true);  // true para formato de 24 horas

                timePickerDialog.show();
            }
        });

        // Listener para el botón de fecha
        btnFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener la fecha actual
                final Calendar c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(AddTaskActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        String FechaSelec = String.format(Locale.getDefault(), "%02d/%02d/%04d", dayOfMonth, month + 1, year);
                        edtFecha.setText(FechaSelec);
                    }
                }, year, month, day);
                datePickerDialog.show(); // Muestra el diálogo
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear una nueva instancia de Tareas
                Tareas tarea = new Tareas();
                // Asignar los valores de los campos EditText a la tarea
                tarea.setTitulo(edtTitulo.getText().toString());
                tarea.setDescripcion(edtDescripcion.getText().toString());
                tarea.setFecha(edtFecha.getText().toString());
                tarea.setHora(edtHora.getText().toString());

                // Añadir la tarea a la lista de tareas (lstTareas)
                lstTareas.add(tarea);

                Toast.makeText(AddTaskActivity.this, "Tarea guardada", Toast.LENGTH_SHORT).show();

                //  Limpiar los campos después de guardar
                edtTitulo.setText("");
                edtDescripcion.setText("");
                edtFecha.setText("");
                edtHora.setText("");

                // Finaliza la actividad después de guardar
                finish();
            }
        });
    }
}
