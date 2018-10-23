package m2iformation.fr.atlas_dept;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Departement dept;
    private EditText etSearch;
    private EditText etNoDept;
    private EditText etNoRegion;
    private EditText etNom;
    private EditText etNomStd;
    private EditText etSurface;
    private EditText etDateCreation;
    private EditText etChefLieu;
    private EditText etUrlWiki;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSearch = findViewById(R.id.etSearch);
        etNoDept = findViewById(R.id.etNoDept);
        etNoRegion = findViewById(R.id.etNoRegion);
        etNom = findViewById(R.id.etNom);
        etNomStd = findViewById(R.id.etNomStd);
        etSurface = findViewById(R.id.etSurface);
        etDateCreation = findViewById(R.id.etDateCreation);
        etChefLieu = findViewById(R.id.etChefLieu);
        etUrlWiki = findViewById(R.id.etUrlWiki);
        dept = new Departement(this);
    }


    public void btSearch(View view) {
        String saisie = etSearch.getText().toString();
        try {
            dept.select(saisie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
