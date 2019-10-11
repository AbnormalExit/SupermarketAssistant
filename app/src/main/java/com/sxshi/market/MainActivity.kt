package com.sxshi.market

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.sxshi.market.utils.toast

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    private var latestTime: Long = 0
    override fun onBackPressed() {
        val backStackEntryCount = supportFragmentManager.backStackEntryCount
        if (backStackEntryCount < 1) {
            if (System.currentTimeMillis() - latestTime > 2000) {
                latestTime = System.currentTimeMillis()
                toast("再按一次退出程序")
                return
            } else {
                finish()

            }
        }
        super.onBackPressed()
    }
}
