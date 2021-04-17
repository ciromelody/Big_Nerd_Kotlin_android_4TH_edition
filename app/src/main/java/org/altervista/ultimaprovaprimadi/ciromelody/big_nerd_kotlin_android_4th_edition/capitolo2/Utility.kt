package org.altervista.ultimaprovaprimadi.ciromelody.big_nerd_kotlin_android_4th_edition.capitolo2

import android.content.Context
import android.view.Gravity
import android.widget.Toast

class Utility {
    public fun visualizza_il_dato_ricevuto(context: Context, profileName: String?) {

        var toast = Toast.makeText(
            context,
            profileName,
            Toast.LENGTH_SHORT
        )
        toast.setGravity(Gravity.TOP or Gravity.RIGHT, 21, 34)
        toast.show()
    }
}