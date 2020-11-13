package com.example.greenchallenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//Infos von: http://www.willemer.de/informatik/android/activity.htm

public class StartCO2Challenge<InfoText> extends AppCompatActivity {

    private EditText userName;
    private TextView infoText;
    private Button btn_login;
    private Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {





        //Die Methode onCreate wird aufgerufen, wenn die Activity gerade erzeugt wurde.
        // Diese Methode wird typischerweise für jede Activity überschrieben,
        // schon um den Bildschirm zu initialisieren.
        // Zuallererst wird mit super.onCreate(bundle) die Methode onCreate der Basisklasse aufgerufen.
        //Bundle: Der Parameter Bundle enthält den Zustand der Activity, den Sie eventuell bei
        // einem zuvor unerwarteten Abbruch durch das Laufzeitsystem durch Überschreiben
        // der Methode onSaveInstanceState noch gesichert haben.
        super.onCreate(savedInstanceState);
        //mit setContentView wird die XML-Layout-Datei geladen
        //jede Acitivity hat eine xml-Layout-datei
        setContentView(R.layout.activity_start_co2_challenge);


        setupViews();

        btn_login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                checkAccount(userName.getText().toString(),infoText);
            }
        });


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (StartCO2Challenge.this, MainActivity.class);
                startActivity(intent);
            }
        });


        }
    private void setupViews(){
        userName = findViewById(R.id.editName);
        infoText = findViewById(R.id.textInfo);
        btn_login = findViewById(R.id.btn_Login);
        btn_back = findViewById(R.id.btn_back);
    }



    private void checkAccount(String userName, TextView infoText){
        //if (account noch nicht existent), lege neuen Account an
        if (userName.isEmpty()) {
            infoText.setText("Please enter a name");
        }
        else if(!userName.equals("Sarah")){
            infoText.setText(String.valueOf(userName) + " is wrong.Only Sarah is a valid user name");
    } else {infoText.setText("Super gemacht!");}
    }
}
