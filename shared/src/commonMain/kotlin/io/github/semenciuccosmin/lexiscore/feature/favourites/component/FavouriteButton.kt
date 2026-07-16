package io.github.semenciuccosmin.lexiscore.feature.favourites.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.semenciuccosmin.lexiscore.ui.design.icons.Heart
import io.github.semenciuccosmin.lexiscore.ui.design.icons.HeartFilled
import io.github.semenciuccosmin.lexiscore.ui.design.icons.LexiscoreIcons
import io.github.semenciuccosmin.lexiscore.ui.design.theme.Pds

@Composable
fun FavouriteButton(
    isChecked: Boolean,
    onClick: () -> Unit
) {
    ElevatedCard(
        onClick = onClick,
        shape = CircleShape
    ) {
        Icon(
            contentDescription = null,
            modifier = Modifier
                .padding(Pds.spacing.small)
                .size(Pds.icon.medium),
            imageVector = when {
                isChecked -> LexiscoreIcons.HeartFilled
                else -> LexiscoreIcons.Heart
            },
            tint = when {
                isChecked -> MaterialTheme.colorScheme.primary
                else -> MaterialTheme.colorScheme.onBackground
            }
        )
    }
}