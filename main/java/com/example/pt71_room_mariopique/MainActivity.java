package com.example.pt71_room_mariopique;

//import android.nfc.Tag;
import com.example.pt71_room_mariopique.db.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pt71_room_mariopique.db.DBManager;
import com.example.pt71_room_mariopique.db.TagDAO;
import com.example.pt71_room_mariopique.db.Tasca;
import com.example.pt71_room_mariopique.db.TascaAmbTags;
import com.example.pt71_room_mariopique.db.TascaDAO;
import com.example.pt71_room_mariopique.db.TascaTag;
import com.example.pt71_room_mariopique.db.TascaTagDAO;

import java.util.List;
import java.util.concurrent.Executors;


public class MainActivity extends AppCompatActivity {

    private DBManager db;
    private TascaDAO tascaDAO;
    private TagDAO tagDAO;

    private TascaTagDAO tascaTagDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        db = DBManager.getDbInstance(this);
        tascaDAO = db.tascaDAO();
        tagDAO = db.tagDAO();
        tascaTagDAO = db.tascaTagDAO();

        Button btnVeureTotes = findViewById(R.id.btnVeureTotes);
        TextView tvResultats = findViewById(R.id.tvResultats);

        btnVeureTotes.setOnClickListener(v -> {
            new Thread(() -> {
                // lista con relación M:N
                List<TascaAmbTags> llista = tascaDAO.getTotesLesTasques();

                // recycler view per mostrar
                StringBuilder sb = new StringBuilder();
                for (TascaAmbTags item : llista) {
                    sb.append("TASCA: ").append(item.tasca.getTitol()).append("\n");
                    sb.append("TAGS: ");
                    for (Tag t : item.tags) {
                        sb.append("[").append(t.getNom()).append("] ");
                    }
                    sb.append("\n\n");
                }

                // run UI fil
                runOnUiThread(() -> tvResultats.setText(sb.toString()));
            }).start();
        });

        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                realizarOperaciones();
            } catch (Exception e) {
                Log.e("ERROR_ROOM", "Error en operaciones: " + e.getMessage());
            }
        });

    }

    private void realizarOperaciones() {
        new Thread(() -> {
            //  AFEGIR TAGS ---
            Tag tag1 = new Tag("Urgent");
            Tag tag2 = new Tag("Escola");
            tascaDAO.insertTag(tag1);
            tascaDAO.insertTag(tag2);

            //  AFEGIR TASQUES
            long ara = System.currentTimeMillis();
            Tasca t1 = new Tasca("Clonar repo", "Repo de mario", "Pendent", ara, ara);
            Tasca t2 = new Tasca("Estudiar", "BD", "Fet", ara, ara);

            // Al insertar, recuperamos el ID generado por la base de datos
            long idT1 = tascaDAO.insertTasca(t1);
            long idT2 = tascaDAO.insertTasca(t2);

            //  ASSIGNAR MÚLTIPLES TAGS A UNA TASCA
            tascaTagDAO.insert(new TascaTag(1, (int)idT1));
            tascaTagDAO.insert(new TascaTag(2, (int)idT1));


            tascaTagDAO.insert(new TascaTag(2, (int)idT2));

            // VEURE TOTES LES TASQUES
            List<TascaAmbTags> llistaTotes = tascaDAO.getTotesLesTasques();
            imprimirResultados(llistaTotes);

            //  VEURE TASQUES FILTRADES PER TAG
            List<TascaAmbTags> nomerUrgents = tascaDAO.getTasquesPerNomDeTag("Urgent");

        }).start();
    }


    private void imprimirResultados(List<TascaAmbTags> llista) {
        for (TascaAmbTags item : llista) {
            Log.d("ROOM_TEST", "Tasca: " + item.tasca.titol + " | Tags: " + item.tags.size());
        }
    }
}