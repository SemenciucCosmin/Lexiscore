package io.github.semenciuccosmin.lexiscore.ui.design.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.semenciuccosmin.lexiscore.ui.design.model.SortOption
import io.github.semenciuccosmin.lexiscore.ui.design.theme.Pds

@Composable
fun SortOptionDropDownMenuRow(
    sortOption: SortOption,
    onSelectSortOption: (SortOption) -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(modifier = modifier) {
        Row(
            modifier = Modifier.padding(
                horizontal = Pds.spacing.medium,
                vertical = Pds.spacing.small
            )
        ) {
            Spacer(modifier = Modifier.weight(1f))

            DropDownMenu(
                items = SortOption.toMenuItems(),
                selectedItem = SortOption.toMenuItems().first { it.id == sortOption.name },
                onItemSelected = { item ->
                    onSelectSortOption(SortOption.entries.first { it.name == item.id })
                }
            )
        }
    }
}