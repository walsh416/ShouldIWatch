package csc214.kotlintest.shouldiwatchkotlin

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.toast

/**
 * Created by Tim on 1/23/18.
 */


class SettingsFrag : Fragment(), View.OnClickListener {

    val TAG: String = "SettingsFragTAG"

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is SettingsListener) {
            listener = context
        } else {
            throw ClassCastException(context.toString() + " must implement SettingsListener.")
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_settings, container, false)

        val okayBtn: Button = view!!.find(R.id.bt_settingsFrag_okay)
        okayBtn.setOnClickListener(this)

        val cancelBtn: Button = view!!.find(R.id.bt_settingsFrag_cancel)
        cancelBtn.setOnClickListener(this)

        return view
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.bt_settingsFrag_okay -> {
                toast("Okay!")
                listener.onOkay()
            }
            R.id.bt_settingsFrag_cancel -> {
                toast("Cancel")
                listener.onCancel()
            }
            else -> {
                toast("Hit else block in onClick")
                Log.e(TAG, "Hit else block in onClick")
            }
        }
    }

    interface SettingsListener {
        fun onOkay()
        fun onCancel()
    }

    private lateinit var listener: SettingsListener

}