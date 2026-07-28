package io.github.semenciuccosmin.lexiscore.ui.design.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.semenciuccosmin.lexiscore.ui.design.icons.ArrowLeft
import io.github.semenciuccosmin.lexiscore.ui.design.icons.LexiscoreIcons
import io.github.semenciuccosmin.lexiscore.ui.design.theme.Pds

/**
 * A composable that displays a top app bar with an optional title, back navigation
 * icon and a search bar if enabled
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTopBar(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    title: String,
    isSearchEnabled: Boolean,
    onClearClick: () -> Unit,
    onBack: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier,
        navigationIcon = {
            onBack?.let {
                IconButton(onClick = onBack) {
                    Icon(
                        modifier = Modifier.size(Pds.icon.medium),
                        imageVector = LexiscoreIcons.ArrowLeft,
                        contentDescription = null,
                    )
                }
            }
        },
        title = {
            when {
                isSearchEnabled -> {
                    SearchBar(
                        value = value,
                        onValueChange = onValueChange,
                        placeholder = placeholder,
                        onClearClick = onClearClick,
                    )
                }

                else -> {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium,
                    )
                }
            }
        }
    )
}
