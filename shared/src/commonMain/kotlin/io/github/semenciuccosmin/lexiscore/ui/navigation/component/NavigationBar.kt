package io.github.semenciuccosmin.lexiscore.ui.navigation.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import io.github.semenciuccosmin.lexiscore.ui.design.theme.Pds
import io.github.semenciuccosmin.lexiscore.ui.navigation.model.NavigationBarEntry
import org.jetbrains.compose.resources.stringResource

@Composable
fun NavigationBar(
    selectedNavKey: NavKey?,
    onSelectNavKey: (NavKey) -> Unit,
    modifier: Modifier = Modifier,
) {
    BottomAppBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surfaceContainerLow
    ) {
        NavigationBarEntry.entries.forEach { item ->
            NavigationBarItem(
                selected = selectedNavKey == item.navKey,
                onClick = { onSelectNavKey(item.navKey) },
                icon = {
                    Icon(
                        modifier = Modifier.size(Pds.icon.sMedium),
                        imageVector = item.imageVector,
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = stringResource(item.titleRes))
                }
            )
        }
    }
}
