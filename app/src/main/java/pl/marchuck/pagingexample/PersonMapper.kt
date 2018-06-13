package pl.marchuck.pagingexample

import android.support.annotation.DrawableRes

object PersonMapper {

    @DrawableRes
    fun getGenderDrawable(gender: String): Int {

        return when (gender) {
            "male" -> R.drawable.ic_male
            "female" -> R.drawable.ic_female
            else -> R.drawable.ic_gender_unspecified
        }
    }
}