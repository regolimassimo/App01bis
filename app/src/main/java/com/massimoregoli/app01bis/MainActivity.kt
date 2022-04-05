package com.massimoregoli.app01bis


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.massimoregoli.app01bis.engine.onClick
import com.massimoregoli.app01bis.viewmodel.MyViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var holder : Holder
    private lateinit var myViewModel: MyViewModel
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes
            val data: Intent? = result.data
            if (data != null) {
                myViewModel.setName(data.getStringExtra("string")?:"")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm()
        ui()
    }

    private fun vm() {
        myViewModel =
            ViewModelProvider(this)[MyViewModel::class.java]

        myViewModel.doAction(this) {
            holder.setText(it)
        }

    }

    private fun ui() {
        holder = Holder(this) {
            val msg = getString(R.string.message)
            val color = when(it.id) {
                R.id.btnGreen -> getString(R.string.gr)
                R.id.btnBlue -> getString(R.string.bl)
                else -> getString(R.string.rd)
            }
            val finalMessage = msg + color
            holder.setText(finalMessage)

            onClick(this, it, resultLauncher)



        }
//        holder.setText(getString(R.string.ciao_mamma))
    }

    class Holder(activity: MainActivity, onClick: (Button) -> Unit) {
        fun setText(finalMessage: String) {
            tvInfo.text = finalMessage
        }

        private var btnRed: Button = activity.findViewById(R.id.btnRed)
        private var btnBlue: Button = activity.findViewById(R.id.btnBlue)
        private var btnGreen: Button = activity.findViewById(R.id.btnGreen)
        private var tvInfo: TextView = activity.findViewById(R.id.tvInfo)

        init {
            btnRed.setOnClickListener {
                onClick(it as Button)
            }
            btnBlue.setOnClickListener {
                onClick(it as Button)
            }
            btnGreen.setOnClickListener {
                onClick(it as Button)
            }

        }

    }
}