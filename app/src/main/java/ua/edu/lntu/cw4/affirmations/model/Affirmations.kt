package ua.edu.lntu.cw4.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ItemAffirmations(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
