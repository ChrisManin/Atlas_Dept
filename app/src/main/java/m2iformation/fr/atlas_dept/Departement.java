package m2iformation.fr.atlas_dept;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.EmptyStackException;

import static android.text.method.TextKeyListener.clear;

public class Departement {
    private SQLiteDatabase db;
    private String noDept;
    private int noRegion;
    private String nom;
    private String nomStd;
    private int surface;
    private String dateCreation;
    private String chefLieu;
    private String urlWiki;

    public SQLiteDatabase getDb() {
        return db;
    }

    public void setDb(SQLiteDatabase db) {
        this.db = db;
    }

    public String getNoDept() {
        return noDept;
    }

    public void setNoDept(String noDept) {
        this.noDept = noDept;
    }

    public int getNoRegion() {
        return noRegion;
    }

    public void setNoRegion(int noRegion) {
        this.noRegion = noRegion;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomStd() {
        return nomStd;
    }

    public void setNomStd(String nomStd) {
        this.nomStd = nomStd;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getChefLieu() {
        return chefLieu;
    }

    public void setChefLieu(String chefLieu) {
        this.chefLieu = chefLieu;
    }

    public String getUrlWiki() {
        return urlWiki;
    }

    public void setUrlWiki(String urlWiki) {
        this.urlWiki = urlWiki;
    }

    public Departement(Context c) {
        Context ctxt = c;
        DbGeo dbgeo = (DbGeo.getInstance(c));
        db = dbgeo.getWritableDatabase();

    }

    public void select(String no) throws Exception {
        String[] colonnes = {"no_dept", "no_region", "nom", "nom_std", "surface", "date_creation", "chef_lieu", "url_wiki"};
        String critere = "no_dept = '" + no + "'";
        Cursor cursor = db.query("departements", colonnes, critere, null, null, null, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            setNoDept(cursor.getString(0));
            setNoRegion(Integer.parseInt(cursor.getString(1)));
            setNom(cursor.getString(2));
            setNomStd(cursor.getString(3));
            setSurface(Integer.parseInt(cursor.getString(4)));
            setDateCreation(cursor.getString(5));
            setChefLieu(cursor.getString(6));
            setUrlWiki(cursor.getString(7));
        } else {
            throw new EmptyStackException();
        }
    }

    public Departement(Context c, String noDepart) throws Exception {
        Context ctxt = c;
        DbGeo dbgeo = (DbGeo.getInstance(c));
        db = dbgeo.getWritableDatabase();
        select(noDepart);
    }

    public void delete() throws Exception {
        if (!noDept.isEmpty()){
            String critere = "no_dept = " + noDept;
            db.delete("departements", critere, null);
        } else {
            throw new EmptyStackException();
        }
    }

    public void update() throws Exception {
        ContentValues values = new ContentValues();

        values.put("no_region", noRegion);
        values.put("nom", nom);
        values.put("nom_std", nomStd);
        values.put("surface", surface);
        values.put("date_creation", dateCreation);
        values.put("chef_lieu", chefLieu);
        values.put("url_wiki", urlWiki);

        if (!noDept.equals("")) {
            String critere = "no_dept = " + noDept;
            db.update("departements", values, critere, null);                //insert INTO contacts SET nom= "...", tel="..."
        } else {
            throw new EmptyStackException();
        }
    }

    public void insert()throws Exception {
        if (!noDept.isEmpty()) {
            ContentValues values = new ContentValues();
            values.put("no_dept", noDept);
            values.put("no_region", noRegion);
            values.put("nom", nom);
            values.put("nom_std", nomStd);
            values.put("surface", surface);
            values.put("date_creation", dateCreation);
            values.put("chef_lieu", chefLieu);
            values.put("url_wiki", urlWiki);
            try {
                db.insert("departements", "", values);
            } catch (Exception ex) {
                throw ex;
            }
        } else {
            throw new EmptyStackException();
        }
    }
}



