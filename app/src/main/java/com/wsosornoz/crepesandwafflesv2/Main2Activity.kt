package com.wsosornoz.crepesandwafflesv2

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import kotlin.system.exitProcess

class Main2Activity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var ban = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)




        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toogle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
            )
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()
        navView.setNavigationItemSelectedListener(this)

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        val supermanFragment = InicioFragment()
        transaction.add(R.id.contenedor, supermanFragment).commit()
    }


    override fun onBackPressed() {
        if (ban==0){
            super.onBackPressed()
            super.onBackPressed();
            finishAffinity();
            System.exit(0);
        }
        else{
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }}
        ban=0


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main2, menu)
        ban=1
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item!!.itemId) {
            R.id.action_settings -> {
                var intent = Intent(this, LoginActivity::class.java)

                startActivityForResult(intent, 1)
            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        when (item.itemId) {
            R.id.nav_inicio-> {
                val inicioFragment = InicioFragment()
                transaction.replace(R.id.contenedor, inicioFragment).commit()
            }
            R.id.nav_menu -> {
                val menuFragment = MenuFragment()
                transaction.replace(R.id.contenedor, menuFragment).commit()
            }
            R.id.nav_localizar -> {
                val localizarFragment = LocalizarFragment()
                transaction.replace(R.id.contenedor, localizarFragment).commit()
            }
            R.id.nav_reservar -> {
                val reservasFragment = ReservasFragment()
                transaction.replace(R.id.contenedor, reservasFragment).commit()
            }
            R.id.nav_calificar -> {
                val calificacionesFragment = CalificacionesFragment()
                transaction.replace(R.id.contenedor, calificacionesFragment).commit()
            }
        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }



}
