package abika.sinau.core.utils

import abika.sinau.core.R
import abika.sinau.core.data.Resource
import abika.sinau.core.data.source.remote.network.ApiResponse
import android.app.Activity
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow


/**
 * @author by Abika Chairul Yusri on 9/18/2022
 */

fun Activity.toastShort(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Activity.toastLong(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Fragment.toastShort(message: String) {
    Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.toastLong(message: String) {
    Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun snackBarShort(view: View, msg: String) {
    Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show()
}

fun snackBarLong(view: View, msg: String) {
    Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show()
}

internal fun ImageView.loadImage(url: String) {
    Glide
        .with(this)
        .load(url)
        .error(R.mipmap.img_placeholder_empty)
        .placeholder(R.mipmap.img_placeholder_empty)
        .into(this)
}