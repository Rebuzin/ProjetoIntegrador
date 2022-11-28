package com.example.appmedia;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.appmedia.adapter.ViagemAdapter;
import com.example.appmedia.model.Viagem;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private ListView lvViagem;
    private ArrayList<Viagem> listaViagem;
    private Button btData;
    private EditText edKmInicial;
    private EditText edKmFinal;
    private EditText edLitros;
    private TextView media;
    private Viagem viagemSelecionada;

    private DatePickerDialog datePickerDialog;

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatePicker();
//
//        binding = ActivityMainBinding.infla te(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        setSupportActionBar(binding.appBarMain.toolbar);
//        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        DrawerLayout drawer = binding.drawerLayout;
//        NavigationView navigationView = binding.navView;
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
//                .setOpenableLayout(drawer)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);

        btData = findViewById(R.id.btData);
        btData.setText(getTodaysDate());

        edKmInicial = findViewById(R.id.edKmInicial);
        edKmFinal = findViewById(R.id.edKmFinal);
        edLitros = findViewById(R.id.edLitros);

        lvViagem = findViewById(R.id.lvViagem);
        listaViagem = new ArrayList<>();
        atualizaLista();

        lvViagem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                viagemSelecionada = (Viagem) adapterView.getAdapter().getItem(position);
            }
        });
    }

    private String getTodaysDate(){
        Calendar cal = Calendar.getInstance();
        int ano = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH);
        mes = mes + 1;
        int dia = cal.get(Calendar.DAY_OF_MONTH);

        return makeDateString(dia, mes, ano);
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {
                mes = mes + 1;
                String data = makeDateString(dia, mes, ano);
                btData.setText(data);
            }
        };

        Calendar cal = Calendar.getInstance();
        int ano = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, ano, mes, dia);
    }

    private String makeDateString(int dia, int mes, int ano) {
        return dia + "/" + getMonthFormat(mes) + "/" + ano;
    }

    private String getMonthFormat(int mes) {
        if(mes == 1)
            return "01";
        if(mes == 2)
            return "02";
        if(mes == 3)
            return "03";
        if(mes == 4)
            return "04";
        if(mes == 5)
            return "05";
        if(mes == 6)
            return "06";
        if(mes == 7)
            return "07";
        if(mes == 8)
            return "08";
        if(mes == 9)
            return "09";
        if(mes == 10)
            return "10";
        if(mes == 11)
            return "11";
        if(mes == 12)
            return "12";

        //padrão(nunca deve acontecer)
        return "JAN";
    }

    private void atualizaLista(){
        ViagemAdapter  adapter = new ViagemAdapter(this, listaViagem);
        lvViagem.setAdapter(adapter);
    }

    public void adicionarViagem(View view) {
        Viagem viagem = new Viagem();
        viagem.setData(btData.getText().toString());
        viagem.setKmInicial(edKmInicial.getText().toString());
        viagem.setKmFinal(edKmFinal.getText().toString());
        viagem.setLitros(edLitros.getText().toString());

        listaViagem.add(viagem);
        atualizaLista();

        btData.setText("");
        edKmInicial.setText("");
        edKmFinal.setText("");
        edLitros.setText("");

    }

    public void OpenDate(View view) {
        datePickerDialog.show();
    }

    private class ActivityMainBinding {
    }
}