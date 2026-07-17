package io.github.semenciuccosmin.lexiscore.feature.favourites.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.github.semenciuccosmin.lexiscore.data.model.Word
import io.github.semenciuccosmin.lexiscore.ui.design.theme.Pds
import kotlinx.collections.immutable.ImmutableList
import lexiscore.shared.generated.resources.Res
import lexiscore.shared.generated.resources.lbl_empty_list
import org.jetbrains.compose.resources.stringResource

@Composable
fun FavouritesScreen(
    words: ImmutableList<Word>,
    onItemClick: (Int) -> Unit,
    onFavouriteClick: (Int, Boolean) -> Unit
) {
    when {
        words.isEmpty() -> {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(Pds.spacing.medium)
                    .fillMaxSize()
            ) {
                Text(
                    text = stringResource(Res.string.lbl_empty_list),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
        else -> {
            LazyColumn(
                contentPadding = PaddingValues(Pds.spacing.medium),
                verticalArrangement = Arrangement.spacedBy(Pds.spacing.medium)
            ) {
                items(words) { word ->
                    FavouriteListItem(
                        word = word.description,
                        score = word.score,
                        definition = word.definition,
                        isFavourite = word.isFavourite,
                        onClick = { onItemClick(word.id) },
                        onFavouriteClick = { onFavouriteClick(word.id, !word.isFavourite) },
                    )
                }
            }
        }
    }
}
