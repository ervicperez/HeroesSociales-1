package com.heroes.nouveau.hackmap;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;

public class DataActivity extends AppCompatActivity {

    private ImageButton cargar;
    private Button atras;
    private Button siguiente;

    private String APP_DIRECTORY = "VamoAyudar/";
    private String MEDIA_DIRECTORY = APP_DIRECTORY + "media";
    private String TEMPORAL_PICTURE_NAME = "temporal.jpg";

    private final int PHOTO_CODE = 100;
    private final int SELECT_PICTURE = 200;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cargar = (ImageButton)findViewById(R.id.cameraIcon);
        /*atras = (Button)findViewById(R.id.btn_atras);
        siguiente = (Button)findViewById(R.id.btn_siguiente);*/
        imageView = (ImageView)findViewById(R.id.iv_foto);

        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] options = {"Tomar foto", "Elegir de galeria", "Cancelar"};
                final AlertDialog.Builder builder = new AlertDialog.Builder(DataActivity.this);
                builder.setTitle("Elige una opción :D");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int seleccion) {
                        if (options[seleccion] == "Tomar foto") {
                            openCamera();
                        } else if (options[seleccion] == "Elegir de galeria") {
                            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            intent.setType("image/*");
                            startActivityForResult(intent.createChooser(intent, "Selecciona app de imagen"), SELECT_PICTURE);
                        } else if (options[seleccion] == "Cancelar") {
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case PHOTO_CODE:
                if(resultCode == RESULT_OK){
                    String dir = Environment.getExternalStorageDirectory() + File.separator + MEDIA_DIRECTORY + File.separator + TEMPORAL_PICTURE_NAME;
                    decodeBitmap(dir);

                }
                break;
            case SELECT_PICTURE:
                if(resultCode == RESULT_OK){
                    Uri path = data.getData();
                    imageView.setImageURI(path);

                }
                break;
        }
    }

    private void decodeBitmap(String dir) {
        Bitmap bitmap;
        bitmap = BitmapFactory.decodeFile(dir);

        imageView.setImageBitmap(bitmap);
    }

    private void openCamera() {
        File file = new File(Environment.getExternalStorageDirectory(), MEDIA_DIRECTORY);
        file.mkdirs();

        String path = Environment.getExternalStorageDirectory() + File.separator + MEDIA_DIRECTORY + File.separator + TEMPORAL_PICTURE_NAME;

        File newFile = new File(path);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(newFile));
        startActivityForResult(intent, PHOTO_CODE);
    }

    public void nuevaPersona(View view){
        //guarda la información del nuevo registro en la base de datos

        finish();
    }
}
