package ua.edu.lntu.cw4.affirmations.data

import ua.edu.lntu.cw4.R
import ua.edu.lntu.cw4.affirmations.model.ItemAffirmations

class Datasource() {
    fun loadAffirmations(): List<ItemAffirmations> {
        return listOf<ItemAffirmations>(
            ItemAffirmations(R.string.affirmationitem1, R.drawable.image1),
            ItemAffirmations(R.string.affirmationitem2, R.drawable.image2),
            ItemAffirmations(R.string.affirmationitem3, R.drawable.image3),
            ItemAffirmations(R.string.affirmationitem4, R.drawable.image4),
            ItemAffirmations(R.string.affirmationitem5, R.drawable.image5),
            ItemAffirmations(R.string.affirmationitem6, R.drawable.image6),
        )
    }
}
