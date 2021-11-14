package com.example.temconvertisseur;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.String.*;

public class MainActivity extends AppCompatActivity {
    EditText Nb1,Nb2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Nb1=findViewById(R.id.nb1);
        Nb2=findViewById(R.id.nb2);
        btn=findViewById(R.id.button);

        btn.setOnClickListener(v -> {
            if(Nb1.getText().toString().equals("")&&Nb2.getText().toString().equals("")){
                Toast.makeText(MainActivity.this,"remplir les champs",Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("champs vides").
                        setTitle("error")
                        .setNeutralButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).create().show();

            }
            else if(!Nb1.getText().toString().equals("")&&!Nb2.getText().toString().equals("")){
                if(Float.valueOf(Nb1.getText().toString())!=(Float.valueOf(Nb2.getText().toString())-32) * 5/9) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Remplir un seul champs").
                            setTitle("error")
                            .setNeutralButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            }).create().show();
                }
            }
            else if(Nb1.getText().toString().isEmpty()){
                float res=(Float.valueOf(Nb2.getText().toString())-32) * 5/9;
                Nb1.setText(valueOf(res));
            }
            else{
                float res=(Float.valueOf(Nb1.getText().toString())* 9/5) + 32 ;
                Nb2.setText(valueOf(res));
            }
        });
    }
}