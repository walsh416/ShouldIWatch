package csc214.kotlintest.shouldiwatchkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.SharedPreferencesCompat
import android.util.Log
import android.view.Menu
import android.view.MenuItem

import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), SearchFrag.SearchListener, SettingsFrag.SettingsListener {


    val TAG:String = "MainActivityTAG"

    lateinit var prefs: Prefs

    val testFrag = TestFrag()
    var searchFrag = SearchFrag()
    var settingsFrag = SettingsFrag()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prefs = Prefs(this)
//        setHasOptionsMenu(true)

//        testFrag.arguments = intent.extras
//        val transaction = fragmentManager.beginTransaction()
//        transaction.add(R.id.fl_frame_mainActivity, testFrag)
//        transaction.commit()
    }

    override fun onCancel() {
        toast("Canceled!!!")
//        supportFragmentManager.beginTransaction()
////                .replace(R.id.fl_frame_mainActivity, testFrag)
//                .add(R.id.fl_frame_mainActivity, testFrag)
//                .addToBackStack(null)
//                .commit()
        onBackPressed()
    }

    override fun onOkay() {
        onBackPressed()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        Log.d(TAG, "onCreateOptionsMenu called")
//        getMenuInflater().inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.menu_refreshGames -> {
                toast("Refresh Games")
                return super.onOptionsItemSelected(item)
            }
            R.id.menu_addTeam -> {
                toast("Add team")
                searchFrag = SearchFrag()
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fl_frame_mainActivity, searchFrag)
//                        .add(R.id.fl_frame_mainActivity, searchFrag)
                        .addToBackStack(null)
                        .commit()
                return super.onOptionsItemSelected(item)
            }
            R.id.menu_settings -> {
                toast("Settings")
                settingsFrag = SettingsFrag()
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fl_frame_mainActivity, settingsFrag)
//                        .add(R.id.fl_frame_mainActivity, settingsFrag)
                        .addToBackStack(null)
                        .commit()
                return super.onOptionsItemSelected(item)
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

//    TODO: currently, if in search frag and go to settings frag, back button
//              brings back to search frag... is that good, or should it go home?
    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount

        if(count == 0){
            super.onBackPressed()
        }
        else {
            supportFragmentManager.popBackStack()
        }


    }

}








