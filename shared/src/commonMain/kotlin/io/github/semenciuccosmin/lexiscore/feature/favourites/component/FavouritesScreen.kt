package io.github.semenciuccosmin.lexiscore.feature.favourites.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.github.semenciuccosmin.lexiscore.data.model.Word
import io.github.semenciuccosmin.lexiscore.ui.design.components.SearchTopBar
import io.github.semenciuccosmin.lexiscore.ui.design.components.SortOptionDropDownMenuRow
import io.github.semenciuccosmin.lexiscore.ui.design.model.SortOption
import io.github.semenciuccosmin.lexiscore.ui.design.theme.Pds
import kotlinx.collections.immutable.ImmutableList
import lexiscore.shared.generated.resources.Res
import lexiscore.shared.generated.resources.lbl_empty_list
import lexiscore.shared.generated.resources.lbl_favourites
import lexiscore.shared.generated.resources.lbl_word
import org.jetbrains.compose.resources.stringResource

@Composable
fun FavouritesScreen(
    words: ImmutableList<Word>,
    query: String,
    sortOption: SortOption,
    onChangeQuery: (String) -> Unit,
    onSelectSortOption: (SortOption) -> Unit,
    onClearClick: () -> Unit,
    onItemClick: (Int) -> Unit,
    onFavouriteClick: (Int, Boolean) -> Unit,
) {
    Scaffold(
        topBar = {
            SearchTopBar(
                value = query,
                onValueChange = onChangeQuery,
                placeholder = stringResource(Res.string.lbl_word),
                title = stringResource(Res.string.lbl_favourites),
                isSearchEnabled = words.isNotEmpty(),
                onClearClick = onClearClick,
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            SortOptionDropDownMenuRow(
                sortOption = sortOption,
                onSelectSortOption = onSelectSortOption,
            )

            when {
                words.isEmpty() -> {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(Pds.spacing.medium)
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
    }
}
