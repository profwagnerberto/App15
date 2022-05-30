package br.com.aluno.app15;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  SharedPreferences sp;
  EditText meditText1, meditText2;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    meditText1 = findViewById(R.id.editText1);
    meditText2 = findViewById(R.id.editText2);
  }

  public void aoClicarNoSimular(View v){
    sp = getSharedPreferences("MeusDados.dat", Context.MODE_PRIVATE);
    SharedPreferences.Editor ed;
    ed = sp.edit();
    ed.putString("valor", meditText1.getText().toString() );
    ed.putString("quantidade", meditText2.getText().toString() );
    ed.apply();
    Toast.makeText( this, "Salvo", Toast.LENGTH_SHORT ).show();
  }

  public void aoClicarNoLimpar(View v){
    meditText1.setText("");
    meditText2.setText("");
  }

  public void aoClicarNoCarregar(View v){
    sp = getSharedPreferences("MeusDados.dat", Context.MODE_PRIVATE);
    meditText1.setText( sp.getString("valor", "") );
    meditText2.setText( sp.getString("quantidade", "") );
  }
}