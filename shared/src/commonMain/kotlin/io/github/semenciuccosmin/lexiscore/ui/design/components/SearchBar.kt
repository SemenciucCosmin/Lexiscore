package io.github.semenciuccosmin.lexiscore.ui.design.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import io.github.semenciuccosmin.lexiscore.ui.design.icons.CloseCircle
import io.github.semenciuccosmin.lexiscore.ui.design.icons.LexiscoreIcons
import io.github.semenciuccosmin.lexiscore.ui.design.icons.SearchWord
import io.github.semenciuccosmin.lexiscore.ui.design.theme.Pds

/**
 * A composable that displays a search bar with a text field, search icon, and clear button.
 *
 * @param value The current text in the search bar.
 * @param onValueChange Callback invoked when the text changes.
 * @param placeholder The placeholder text to display when the search bar is empty.
 * @param onClearClick Callback invoked when the clear button is clicked.
 * @param modifier Modifier to be applied to the search bar.
 */
@Composable
fun SearchBar(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    onClearClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isActive by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused = interactionSource.collectIsFocusedAsState().value
    val shouldClearFocus = !isActive && isFocused
    val shouldRequestFocus = isActive && !isFocused
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(isActive) {
        if (shouldClearFocus) focusManager.clearFocus()
        if (shouldRequestFocus) focusRequester.requestFocus()
    }

    BasicTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        interactionSource = interactionSource,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onSearch = {
                isActive = false
                keyboardController?.hide()
            }
        ),
        textStyle = MaterialTheme.typography.bodyLarge.copy(
            color = MaterialTheme.colorScheme.onSurface
        ),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .background(MaterialTheme.colorScheme.surfaceContainer)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(Pds.spacing.small),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(Pds.spacing.small)
                ) {
                    Icon(
                        imageVector = LexiscoreIcons.SearchWord,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(Pds.icon.small)
                    )

                    Box(Modifier.weight(1f)) {
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onBackground,
                            )
                        }
                        innerTextField()
                    }

                    if (value.isNotBlank()) {
                        Icon(
                            imageVector = LexiscoreIcons.CloseCircle,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(Pds.icon.small)
                                .clickable {
                                    isActive = true
                                    onClearClick()
                                    keyboardController?.hide()
                                }
                        )
                    }
                }
            }
        }
    )
}
