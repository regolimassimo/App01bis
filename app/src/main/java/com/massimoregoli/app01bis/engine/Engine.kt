package com.massimoregoli.app01bis.engine

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import com.massimoregoli.app01bis.R
import com.massimoregoli.app01bis.activities.SecondActivity

fun onClick(mainActivity: Context, v: View, resultLauncher: ActivityResultLauncher<Intent>) {
    val intent = Intent(mainActivity, SecondActivity::class.java)
    intent.putExtra("color", (v as Button).text)
    intent.putExtra("button", v.id)
    resultLauncher.launch(intent)
}
