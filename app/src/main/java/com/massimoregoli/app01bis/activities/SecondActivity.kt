package com.massimoregoli.app01bis.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.massimoregoli.app01bis.R
import com.massimoregoli.app01bis.viewmodel.MyViewModel

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val holder = Holder(this) {it, s ->
            if (it.id == R.id.btnCancel) {
                setResult(RESULT_CANCELED)
                finish()
            }
            else {
                val data = Intent()
                data.putExtra("string", s)
                setResult(RESULT_OK, data)
                finish()
            }

        }
    }

    class Holder(val activity: SecondActivity, onClick: (Button, String) -> Unit) {
        var btnOk: Button = activity.findViewById(R.id.btnOk)
        var btnCancel: Button = activity.findViewById(R.id.btnCancel)
        var etText: EditText = activity.findViewById(R.id.etText)

        init {
            btnOk.setOnClickListener { onClick(it as Button, etText.text.toString()) }
            btnCancel.setOnClickListener { onClick(it as Button, "") }
        }
    }
}