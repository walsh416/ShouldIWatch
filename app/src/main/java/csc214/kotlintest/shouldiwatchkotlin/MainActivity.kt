package csc214.kotlintest.shouldiwatchkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import com.google.api.client.googleapis.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    val TAG:String = "MainActivityTAG"

    val testFrag = TestFrag()
    var searchFrag = SearchFrag()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setHasOptionsMenu(true)

//        testFrag.arguments = intent.extras
//        val transaction = fragmentManager.beginTransaction()
//        transaction.add(R.id.fl_frame_mainActivity, testFrag)
//        transaction.commit()
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
                        .commit()
                return super.onOptionsItemSelected(item)
            }
            R.id.menu_settings -> {
                toast("Settings")
                return super.onOptionsItemSelected(item)
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
