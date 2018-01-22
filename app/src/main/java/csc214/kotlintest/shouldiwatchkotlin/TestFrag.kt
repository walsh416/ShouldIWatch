package csc214.kotlintest.shouldiwatchkotlin

//import android.app.Fragment
import android.support.v4.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.Toast
import android.widget.Toolbar
import kotlinx.android.synthetic.main.test_frag.*

import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.toast

/**
 * Created by Tim on 1/21/18.
 *
 */
class TestFrag : Fragment(), View.OnClickListener {

    val TAG:String = "TestFragTAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView called")
        val view = inflater?.inflate(R.layout.test_frag, container, false)
//        setHasOptionsMenu(true)

        val btn: Button = view!!.find(R.id.bt_click_testFrag)
        btn.setOnClickListener(this)

        return view
    }

    override fun onClick(view: View){
        when (view.id){
            R.id.bt_click_testFrag -> {
                toast("Clicked")
            }
            else -> {
                toast("Hit else block in TestFrag onClick function")
            }
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
//        Log.d(TAG, "onCreateOptionsMenu called")
//        inflater?.inflate(R.menu.main_menu, menu)
////        super.onCreateOptionsMenu(menu, inflater)
//    }

//    override fun onPrepareOptionsMenu(menu: Menu?) {
//        Log.d(TAG, "onPrepareOptionsMenu called")
//    }

//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        when(item?.itemId){
//            R.id.menu_refreshGames -> {
////                Toast.makeText(this, "Refresh Games", Toast.LENGTH_SHORT).show()
//                toast("Refresh Games")
//                return super.onOptionsItemSelected(item)
//            }
//            R.id.menu_addTeam -> {
//                toast("Add Team")
//                return super.onOptionsItemSelected(item)
//            }
//            R.id.menu_settings -> {
//                toast("Settings")
//                return super.onOptionsItemSelected(item)
//            }
//            else -> return super.onOptionsItemSelected(item)
//        }
//    }


//    fun showTestFrag(): Unit{
//
//    }
}