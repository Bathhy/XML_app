package com.example.ite_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.ite_app.databinding.DashboardActivityBinding
import com.example.ite_app.databinding.HomeActivityBinding
import com.google.android.material.tabs.TabLayoutMediator

data class HomeModel(
    val name: String,
    val imgRes: Int
)

val listData = listOf(
    HomeModel(
        name = "Rupp",
        imgRes = R.drawable.rupp
    ),
    HomeModel(
        name = "cadt",
        imgRes = R.drawable.cadt
    ),
    HomeModel(
        name = "ITC",
        imgRes = R.drawable.itc
    ),
    HomeModel(
        name = "MIT",
        imgRes = R.drawable.mit
    ),
)

class MainActivity : AppCompatActivity() {

    //    private lateinit var appBarConfiguration: AppBarConfiguration
//    private lateinit var binding: HomeActivityBinding
    private lateinit var binding: DashboardActivityBinding

   /* override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set Locale Language to Khmer --
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags("km"))
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val homeAdapter = HomeAdapter(
            listPager = listData,
        )
        val firstListAdapter = ListViewAdapter(
            listPager = listData,
        )
        val secListAdapter = ListViewAdapter(
            listPager = listData,
        )
        val findViewPager = findViewById<ViewPager2>(R.id.viewPager)
        val nearMeListView = findViewById<RecyclerView>(R.id.firstRecycle)
        val topPlaceListView = findViewById<RecyclerView>(R.id.secRecycle)
        binding.apply {
            findViewPager.adapter = homeAdapter
            TabLayoutMediator(intoTabLayout, findViewPager) { tab, position -> }.attach()
            nearMeListView.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            nearMeListView.adapter = firstListAdapter
            topPlaceListView.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            topPlaceListView.adapter = secListAdapter
        }
        val button = findViewById<ImageButton>(R.id.modeIcon)
        button.setOnClickListener {
            val darkModeSelected : Boolean = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES
            toggleThemeMode(isDarkMode = !darkModeSelected)
        }

    }
*/
   override fun onCreate(savedInstanceState: Bundle?) {

       super.onCreate(savedInstanceState)
       binding = setContentView(this, R.layout.dashboard_activity)
       onInitBottomNavigationBar()
       enableEdgeToEdge()
   }
  /*  private fun toggleThemeMode(isDarkMode: Boolean) {
        if (isDarkMode) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }*/
    /* override fun onCreateOptionsMenu(menu: Menu): Boolean {
         // Inflate the menu; this adds items to the action bar if it is present.
         menuInflater.inflate(R.menu.menu_main, menu)
         return true
     }
 
     override fun onOptionsItemSelected(item: MenuItem): Boolean {
         // Handle action bar item clicks here. The action bar will
         // automatically handle clicks on the Home/Up button, so long
         // as you specify a parent activity in AndroidManifest.xml.
         return when (item.itemId) {
             R.id.action_settings -> true
             else -> super.onOptionsItemSelected(item)
         }
     }
 
     override fun onSupportNavigateUp(): Boolean {
         val navController = findNavController(R.id.nav_host_fragment_content_main)
         return navController.navigateUp(appBarConfiguration)
                 || super.onSupportNavigateUp()
     }*/

    private fun onInitBottomNavigationBar() {
        onSetFragment(HomeFragment())
        binding.bottomNavigationBar.onItemSelected = { id ->
            when (id) {
                0 -> {
                    onSetFragment(HomeFragment())
                }

                1 -> {
                    onSetFragment(ProductFragment())
                }

                2 -> {
                    onSetFragment(FavoriteFragment())
                }

                3 -> {
                    onSetFragment(ContactFragment())
                }
            }
        }
    }

    private fun onSetFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragementContainerView, fragment)
            commitNow()
        }
    }
}