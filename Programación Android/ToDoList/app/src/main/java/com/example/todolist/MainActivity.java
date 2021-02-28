package com.example.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.google.firebase.firestore.QuerySnapshot;


public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String email;
    ListView lv;
    ArrayList<String> tareas;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.list_todo);
        tareas = new ArrayList<>();
        getData();
        loadDatainListview();
    }

    private void loadDatainListview() { //Carga los datos en la Listview para hacerlos visibles
        // below line is use to get data from Firebase
        // firestore using collection in android.

        db.collection("user").document(email).collection("todo").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) { //Llamamos al método success
                        if (!queryDocumentSnapshots.isEmpty()) { //Si la query no está vacía
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) { //Pasamos la lista obtenida a un objeto list-ya

                                String tarea = d.getString("task");
                                tareas.add(tarea);
                            }

                        } else {
                            Toast.makeText(MainActivity.this, "No data found in Database", Toast.LENGTH_SHORT).show();
                        }

                        ArrayAdapter adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.item_todo, R.id.tarea , tareas); //Passamos el ArrayList a un adapter
                        lv.setAdapter(adapter); //Pasamos nuesrto ArrayList adaptado a la ListView para poder verlo por pantalla
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Fail to load data..", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void getData() {
        Bundle extra = getIntent().getExtras();
        email = extra.getString("email");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_resource_file, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void print(String info) {
        Toast toast = Toast.makeText(this, info, Toast.LENGTH_LONG);
        toast.show();
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        EditText textbox = new EditText(this);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("New task")
                .setMessage("What's next?")
                .setView(textbox)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Map<String, Object> list = new HashMap<>();
                        list.put("task", textbox.getText().toString());
                        Map<String, Object> todo = new HashMap<>();
                        todo.put("task", textbox.getText().toString());

                        db.collection("user").document(email).collection("todo").document(textbox.getText().toString()).set(list).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                tareas.clear();
                                db.collection("user").document(email).collection("todo").document(textbox.getText().toString()).get();
                                loadDatainListview();
                            }
                        });
                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
        dialog.show();

        return super.onOptionsItemSelected(item);

    }

    public void doneTask(View view) {
        View parent = (View) view.getParent();
        TextView tareaTextView = (TextView) parent.findViewById(R.id.tarea);
        String tarea = tareaTextView.getText().toString();
        db.collection("user").document(email).collection("todo").document(tarea).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                tareas.clear();
                loadDatainListview();
                print("Well Done!");
            }
        });
    }

    public void modifyTask(View view) {
        EditText textbox = new EditText(this);
        View parent = (View) view.getParent();
        TextView tareaTextView = (TextView) parent.findViewById(R.id.tarea);
        String tarea = tareaTextView.getText().toString();
        db.collection("user").document(email).collection("todo").document(tarea).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                tareas.clear();
                loadDatainListview();
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Modify task")
                        .setMessage("How do you want to rename it?")
                        .setView(textbox)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Map<String, Object> list = new HashMap<>();
                                list.put("task", textbox.getText().toString());
                                Map<String, Object> todo = new HashMap<>();
                                todo.put("task", textbox.getText().toString());

                                db.collection("user").document(email).collection("todo").document(textbox.getText().toString()).set(list).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        tareas.clear();
                                        db.collection("user").document(email).collection("todo").document(textbox.getText().toString()).get();
                                        loadDatainListview();
                                    }
                                });
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                dialog.show();
            }

        });
    }

}
