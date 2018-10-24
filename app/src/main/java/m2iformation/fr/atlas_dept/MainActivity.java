package m2iformation.fr.atlas_dept;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
            etNoDept.setText(dept.getNoDept());
            etNoRegion.setText(String.valueOf(dept.getNoRegion()));
            etNom.setText(dept.getNom());
            etNomStd.setText(dept.getNomStd());
            etSurface.setText(String.valueOf(dept.getSurface()));
            etDateCreation.setText(dept.getDateCreation());
            etChefLieu.setText(dept.getChefLieu());
            etUrlWiki.setText(dept.getUrlWiki());

            etNoDept.setEnabled(false);

        } catch (Exception e) {
            Toast.makeText(this, "Ce numéro de département n'existe pas !", Toast.LENGTH_LONG).show();
        }
    }

    public void btClear(View view) {
        dept = new Departement(this);
        etNoDept.setText("");
        etNoRegion.setText("");
        etNom.setText("");
        etNomStd.setText("");
        etSurface.setText("");
        etDateCreation.setText("");
        etChefLieu.setText("");
        etUrlWiki.setText("");


    }

    public void btInsert(View view) {
        dept.setNoDept(etNoDept.getText().toString());
        dept.setNoRegion(Integer.parseInt(etNoRegion.getText().toString()));
        dept.setNom(etNom.getText().toString());
        dept.setNomStd(etNomStd.getText().toString());
        dept.setSurface(Integer.parseInt(etSurface.getText().toString()));
        dept.setDateCreation(etDateCreation.getText().toString());
        dept.setChefLieu(etChefLieu.getText().toString());
        dept.setUrlWiki(etUrlWiki.getText().toString());

        try {
            dept.insert();
            Toast.makeText(this, "Département inséré dans la base de données.", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "Insertion impossible", Toast.LENGTH_LONG).show();
        }
    }


    public void btUpdate(View view) {
        dept.setNoDept(etNoDept.getText().toString());
        dept.setNoRegion(Integer.parseInt(etNoRegion.getText().toString()));
        dept.setNom(etNom.getText().toString());
        dept.setNomStd(etNomStd.getText().toString());
        dept.setSurface(Integer.parseInt(etSurface.getText().toString()));
        dept.setDateCreation(etDateCreation.getText().toString());
        dept.setChefLieu(etChefLieu.getText().toString());
        dept.setUrlWiki(etUrlWiki.getText().toString());

       try{
           dept.update();
           Toast.makeText(this, "Département mis à jour.", Toast.LENGTH_LONG).show();
       }catch (Exception e){
           Toast.makeText(this, "Mise à jour impossible", Toast.LENGTH_LONG).show();
       }
    }

    public void btDelete(View view) {
        dept.setNoDept(etNoDept.getText().toString());
        dept.setNoRegion(Integer.parseInt(etNoRegion.getText().toString()));
        dept.setNom(etNom.getText().toString());
        dept.setNomStd(etNomStd.getText().toString());
        dept.setSurface(Integer.parseInt(etSurface.getText().toString()));
        dept.setDateCreation(etDateCreation.getText().toString());
        dept.setChefLieu(etChefLieu.getText().toString());
        dept.setUrlWiki(etUrlWiki.getText().toString());


        try {
            dept.delete();
            btClear(view);
            Toast.makeText(this, "Département supprimé !", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "Suppression impossible", Toast.LENGTH_SHORT).show();
        }
    }
}
