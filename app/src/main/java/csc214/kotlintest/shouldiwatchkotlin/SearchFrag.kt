package csc214.kotlintest.shouldiwatchkotlin

//import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.View
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.toast


/**
 * Created by Tim on 1/22/18.
 */

const val TAG:String = "SearchFragTAG"

class SearchFrag : Fragment(), View.OnClickListener{


    lateinit var editText:EditText

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is onCancel) {
            listener = context
        } else {
            throw ClassCastException(context.toString() + " must implement onCancel.")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView called")
        val view = inflater?.inflate(R.layout.fragment_team_search, container, false)
//        setHasOptionsMenu(true)

        val searchBtn: Button = view!!.find(R.id.bt_teamSearchFrag_search)
        searchBtn.setOnClickListener(this)

        val cancelBtn: Button = view!!.find(R.id.bt_teamSearchFrag_cancel)
        cancelBtn.setOnClickListener(this)

//        val textEt: EditText = view!!.find(R.id.et_teamSearchFrag_textEntered)
        editText = view!!.find(R.id.et_teamSearchFrag_textEntered)

        return view
    }

    override fun onClick(view: View){
        when (view.id){
            R.id.bt_teamSearchFrag_search -> {
                toast("Searching ${editText.text}")
            }
            R.id.bt_teamSearchFrag_cancel -> {
                toast("Canceling")
                listener.onCancel()
            }
            else -> {
                toast("Hit else block in TestFrag onClick function")
                Log.e(TAG, "Hit else block in TestFrag onClick function")
            }
        }
    }


    interface onCancel {
        fun onCancel()
    }

    private lateinit var listener: onCancel
}