package com.coursera.santiago.petagram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.coursera.santiago.petagram.adapter.MascotaAdaptador;
import com.coursera.santiago.petagram.adapter.PageAdapter;
import com.coursera.santiago.petagram.fragment.ListadoMascotaFragment;
import com.coursera.santiago.petagram.fragment.PerfilFragment;
import com.coursera.santiago.petagram.pojo.ListadoMascotas;
import com.coursera.santiago.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ImageButton ibFavoritos;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Toolbar miActionBar = findViewById(R.id.miActionBar);
//        ibFavoritos = miActionBar.findViewById(R.id.ibFavoritos);

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        ibFavoritos = toolbar.findViewById(R.id.ibFavoritos);
        setUpViewPager();

        ibFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Para esta practica no es necesario que esto funcione", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MascotasFavoritas.class);
                startActivity(intent);
            }
        });

//        setSupportActionBar(miActionBar);





        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    private ArrayList <Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new ListadoMascotaFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.dog);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAbout:
                Intent aboutItent = new Intent(this, AboutActivity.class);
                startActivity(aboutItent);
                break;
            case R.id.mContacto:
                Intent contactoIntent = new Intent(this, ContactoActivity.class);
                startActivity(contactoIntent);
                break;
            case R.id.mConfigurar:
                Intent configurarIntent = new Intent(this, ConfiguracionCuentaActivity.class);
                startActivity(configurarIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
