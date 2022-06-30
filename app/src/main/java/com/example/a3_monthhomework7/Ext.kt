package com.example.a3_monthhomework7

import android.content.Context
import android.widget.Toast

fun Context.makeToast(context: Context, name:Animal){
    Toast.makeText(context, "Вы удалили " + name, Toast.LENGTH_SHORT).show()
}