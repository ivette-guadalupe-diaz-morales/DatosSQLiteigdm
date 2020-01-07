package igdmitics.tesoem.edu.datossqliteigdm.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatosHelper extends SQLiteOpenHelper {

    private static  DatosHelper datosHelper = null;
    private  static String NOMBREDB ="bdAgenda7t11";
    private static int VERSION_DB=1;

    public static class  tabladatos{
        public static String TABLA ="tbAgenda";
        public static String COLUMNA_ID= "id";
        public static String COLUMNA_NOMBRE="nombre";
        public static String COLUMNA_EDAD="edad;";
        public static String COLUMNA_CORREO = "correo";
    }

    public static String CONSULTA_CREAR_TABLA = String.format("create table %s (%s integer not null primary key autoincrement, %s varchar, %s integer, %s varchar);", tabladatos.TABLA, tabladatos.COLUMNA_ID, tabladatos.COLUMNA_NOMBRE, tabladatos.COLUMNA_EDAD, tabladatos.COLUMNA_CORREO);

    public static String CONSULTA_ELIMINAR_TABLA= "drop table if exists " + tabladatos.TABLA;

    public static   DatosHelper getInstance(Context context){
        if (datosHelper == null){
            datosHelper = new DatosHelper(context.getApplicationContext());

        }
        return  datosHelper;
    }

    public DatosHelper(Context context){
        super(context,NOMBREDB,null,VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CONSULTA_CREAR_TABLA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CONSULTA_ELIMINAR_TABLA);
        onCreate(db);

    }
}
