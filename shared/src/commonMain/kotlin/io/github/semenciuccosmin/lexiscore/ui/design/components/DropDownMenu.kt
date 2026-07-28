package io.github.semenciuccosmin.lexiscore.ui.design.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.github.semenciuccosmin.lexiscore.ui.design.icons.ChevronDown
import io.github.semenciuccosmin.lexiscore.ui.design.icons.ChevronUp
import io.github.semenciuccosmin.lexiscore.ui.design.icons.LexiscoreIcons
import io.github.semenciuccosmin.lexiscore.ui.design.model.MenuItem
import io.github.semenciuccosmin.lexiscore.ui.design.theme.Pds
import kotlinx.collections.immutable.ImmutableList
import org.jetbrains.compose.resources.stringResource

@Composable
fun DropDownMenu(
    selectedItem: MenuItem,
    items: ImmutableList<MenuItem>,
    onItemSelected: (MenuItem) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = modifier) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(Pds.spacing.small),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { expanded = !expanded }
        ) {
            Text(
                text = stringResource(selectedItem.labelRes),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
            )

            Icon(
                modifier = Modifier.size(Pds.icon.small),
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = null,
                imageVector = when {
                    expanded -> LexiscoreIcons.ChevronUp
                    else -> LexiscoreIcons.ChevronDown
                }
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            containerColor = MaterialTheme.colorScheme.surface,
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = stringResource(item.labelRes),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    },
                    onClick = {
                        expanded = false
                        onItemSelected(item)
                    }
                )
            }
        }
    }
}
