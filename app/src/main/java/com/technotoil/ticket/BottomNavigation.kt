package com.technotoil.ticket

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivityBottomNavigationBinding
import com.technotoil.ticket.homefragments.BottomModel
import com.technotoil.ticket.homefragments.HomeFragment
import com.technotoil.ticket.homefragments.favorites.FavoritesFragment
import com.technotoil.ticket.homefragments.orders.OrdersFragment
import com.technotoil.ticket.homefragments.profiles.ProfileFragment
import com.technotoil.ticket.homefragments.sidemenufragments.artists.managevent.ManageEventActivity
import com.technotoil.ticket.homefragments.sidemenufragments.artists.managevent.artistactivity.ArtistsActivity
import com.technotoil.ticket.homefragments.sidemenufragments.artists.orginizer.orgizeactivity.OrginizerActivity
import com.technotoil.ticket.homefragments.sidemenufragments.artists.trendingvenues.VenuesActivity
import com.technotoil.ticket.repositories.MyPreferences
import com.technotoil.ticket.ui.signIn.SignInActivity


class BottomNavigation: BaseActivity<ActivityBottomNavigationBinding, BottomModel, Any?>() {

    override fun getLayout(): Int {
        return R.layout.activity_bottom_navigation
    }

    override fun getVmClass(): Class<BottomModel> {
        return BottomModel::class.java
    }
    lateinit var bnView : BottomNavigationView
    lateinit var logo: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.nvView.setNavigationItemSelectedListener {
        when(it.itemId){

        R.id.logout -> {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Logout")
            builder.setMessage("Are you want to logout")
            builder.setIcon(android.R.drawable.ic_dialog_alert)


            builder.setPositiveButton("Yes"){dialogInterface, which ->
                MyPreferences.clearpref()
                Toast.makeText(applicationContext,"logout success",Toast.LENGTH_LONG).show()
                val intent = Intent(applicationContext, SignInActivity::class.java)
               startActivity(intent)
              finish()
            }

            builder.setNegativeButton("No"){dialogInterface, which ->

            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()


            binding.drawerLayout.closeDrawers()
        }


        R.id.event -> {
            val intent = Intent(applicationContext, ManageEventActivity::class.java)
            startActivity(intent)

            binding.drawerLayout.closeDrawers()
        }
            R.id.artists -> {
                val intent = Intent(applicationContext, ArtistsActivity::class.java)
                startActivity(intent)

                binding.drawerLayout.closeDrawers()
            }

            R.id.organizers -> {
                val intent = Intent(applicationContext, OrginizerActivity::class.java)
                startActivity(intent)

                binding.drawerLayout.closeDrawers()
            }
            R.id.location -> {
                val intent = Intent(applicationContext, VenuesActivity::class.java)
                startActivity(intent)

                binding.drawerLayout.closeDrawers()
            }
//            R.id.ticket-> Toast.makeText(applicationContext,"ticket",Toast.LENGTH_SHORT).show()
//        R.id.Favorites-> Toast.makeText(applicationContext,"Favorites",Toast.LENGTH_SHORT).show()
//        R.id.wallet-> Toast.makeText(applicationContext,"wallet",Toast.LENGTH_SHORT).show()
//        R.id.refund-> Toast.makeText(applicationContext,"refund",Toast.LENGTH_SHORT).show()
//        R.id.notifications-> Toast.makeText(applicationContext,"notifications",Toast.LENGTH_SHORT).show()
//        R.id.reward-> Toast.makeText(applicationContext,"reward",Toast.LENGTH_SHORT).show()
//        R.id.event-> Toast.makeText(applicationContext,"event",Toast.LENGTH_SHORT).show()
//        R.id.fashion-> Toast.makeText(applicationContext,"fashion",Toast.LENGTH_SHORT).show()
//        R.id.location-> Toast.makeText(applicationContext,"location",Toast.LENGTH_SHORT).show()
//        R.id.artists-> Toast.makeText(applicationContext,"artists",Toast.LENGTH_SHORT).show()
//        R.id.organizers-> Toast.makeText(applicationContext,"organizers",Toast.LENGTH_SHORT).show()
//        R.id.smartphone-> Toast.makeText(applicationContext,"smartphone",Toast.LENGTH_SHORT).show()
//        R.id.feedback-> Toast.makeText(applicationContext,"feedback",Toast.LENGTH_SHORT).show()
//        R.id.fAQs-> Toast.makeText(applicationContext,"fAQs",Toast.LENGTH_SHORT).show()
//        R.id.logout-> Toast.makeText(applicationContext,"logout",Toast.LENGTH_SHORT).show()

    }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
    true
}

        logo = findViewById(R.id.circular_img)
        logo.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)

        }


        loadFragment(HomeFragment())
        bnView = findViewById<BottomNavigationView>(R.id.bnView)
        bnView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.order -> {
                    loadFragment(OrdersFragment())
                  //  loadFragment(ArtistsFragment())
                   // loadFragment(ManageEventFragment())
                    true
                }
                R.id.fav -> {
                    loadFragment(FavoritesFragment())
                    //loadFragment(OrganizersFragment())
                    true
                }
                else -> {

                    loadFragment(ProfileFragment())
                    //loadFragment(TrendingVenuesFragment())
                    true}
            }
        }

    }


    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_frame_layout,fragment)
        transaction.commit()
    }


//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.activity_main_drawer, menu)
//        return true
//    }


//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
//    }
}