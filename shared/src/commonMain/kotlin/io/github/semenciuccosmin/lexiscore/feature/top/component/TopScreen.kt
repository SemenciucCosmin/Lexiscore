package io.github.semenciuccosmin.lexiscore.feature.top.component

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
import androidx.compose.ui.graphics.Color
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

private const val FIRST = 0
private const val SECOND = 1
private const val THIRD = 2

@Composable
fun TopScreen(
    descendingWords: ImmutableList<Word>,
    words: ImmutableList<Word>,
    query: String,
    sortOption: SortOption,
    onChangeQuery: (String) -> Unit,
    onSelectSortOption: (SortOption) -> Unit,
    onClearClick: () -> Unit,
    onItemClick: (Int) -> Unit,
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
                            TopListItem(
                                index = descendingWords.indexOf(word).inc(),
                                word = word.description,
                                score = word.score,
                                definition = word.definition,
                                onClick = { onItemClick(word.id) },
                                tint = when {
                                    descendingWords.indexOf(word) == FIRST -> Color(0xFFFFD700)
                                    descendingWords.indexOf(word) == SECOND -> Color(0xFF90A4AE)
                                    descendingWords.indexOf(word) == THIRD -> Color(0xFFCD7F32)
                                    else -> MaterialTheme.colorScheme.secondary
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
