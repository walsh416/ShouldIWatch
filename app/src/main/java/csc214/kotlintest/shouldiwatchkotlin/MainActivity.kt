package csc214.kotlintest.shouldiwatchkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val TAG:String = "MainActivityTAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setHasOptionsMenu(true)

        val testFrag = TestFrag()
        testFrag.arguments = intent.extras
        val transaction = fragmentManager.beginTransaction()
        transaction.add(R.id.fl_frame_mainActivity, testFrag)
        transaction.commit()
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
                Toast.makeText(this, "Refresh Games", Toast.LENGTH_SHORT).show()
                return super.onOptionsItemSelected(item)
            }
            R.id.menu_addTeam -> {
                Toast.makeText(this, "Add Team", Toast.LENGTH_SHORT).show()
                return super.onOptionsItemSelected(item)
            }
            R.id.menu_settings -> {
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                return super.onOptionsItemSelected(item)
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
