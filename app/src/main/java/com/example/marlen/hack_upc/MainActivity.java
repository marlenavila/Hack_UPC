package com.example.marlen.hack_upc;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    Spinner spinCategories; //li hem de fotre un hint que digui services o algo
    Button btSearch;
    LinearLayout layout;
    RadioButton btProx,btCity;
    EditText cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btSearch = (Button)findViewById(R.id.bt_search);
        btSearch.setOnClickListener(this);

        cityName = (EditText)findViewById(R.id.editCityName);

        layout = (LinearLayout) findViewById(R.id.cityLayout);

        spinCategories = (Spinner)findViewById(R.id.spinCategories);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, getResources()
                .getStringArray(R.array.categories_array)); //agafo l'array declarada al string.xml
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinCategories.setAdapter(adapter);

        spinCategories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        setUpViews();
    }


    private void setUpViews() {
        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navview);

        //Initializing DrawerLayout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                Intent intent;

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "Home Selected", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.register:
                        Toast.makeText(MainActivity.this, "Register Selected", Toast.LENGTH_SHORT).show();
                        intent = new Intent(getApplicationContext(),Register.class);
                        startActivity(intent);
                        break;

                    case R.id.about:
                        Toast.makeText(MainActivity.this, "About Selected", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer, R.string.closeDrawer){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.bt_search:
                String s = cityName.getText().toString();
                if(s.equals(""))
                    Toast.makeText(this, "Enter a city name", Toast.LENGTH_SHORT).show();
                else{
                    intent = new Intent(getApplicationContext(),List.class);
                    startActivity(intent);
                    btSearch.setVisibility(View.GONE);
                }
                break;
        }
    }

    public void onRadioButtonClicked(View v){
        btProx = (RadioButton)findViewById(R.id.bt_prox);
        btCity = (RadioButton)findViewById(R.id.bt_city);
        boolean checked = ((RadioButton) v).isChecked();
        switch (v.getId()){
            case R.id.bt_prox:
                if(checked){
                    btSearch.setVisibility(View.VISIBLE);
                    layout.setVisibility(View.GONE);
                }
                break;
            case R.id.bt_city:
                if(checked){
                    layout.setVisibility(View.VISIBLE);
                    btSearch.setVisibility(View.VISIBLE);
                }
                break;
        }
    }


}
