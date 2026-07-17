package io.github.semenciuccosmin.lexiscore.feature.word.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.github.semenciuccosmin.lexiscore.domain.extensions.getContext
import io.github.semenciuccosmin.lexiscore.domain.extensions.openUrl
import io.github.semenciuccosmin.lexiscore.ui.design.icons.LexiscoreIcons
import io.github.semenciuccosmin.lexiscore.ui.design.icons.SearchWord
import io.github.semenciuccosmin.lexiscore.ui.design.theme.Pds
import lexiscore.shared.generated.resources.Res
import lexiscore.shared.generated.resources.lbl_search_online
import org.jetbrains.compose.resources.stringResource

private const val DEX_URL = "https://dexonline.ro/definitie/"

@Composable
fun WordDefinitionCard(
    description: String,
    definition: String,
    modifier: Modifier = Modifier,
) {
    val context = getContext()

    OutlinedCard(modifier = modifier) {
        Column(
            verticalArrangement = Arrangement.spacedBy(Pds.spacing.medium),
            modifier = Modifier
                .padding(Pds.spacing.sMedium)
                .fillMaxWidth()
        ) {
            Text(
                text = description,
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Medium
                )
            )

            Column(
                modifier = Modifier
                    .heightIn(min = 0.dp, max = 200.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = definition,
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontStyle = FontStyle.Italic
                    )
                )
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.medium,
                onClick = { openUrl(DEX_URL + description, context) {} }
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(Pds.spacing.small),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(Pds.icon.small),
                        imageVector = LexiscoreIcons.SearchWord,
                        contentDescription = null,
                    )

                    Text(
                        text = stringResource(Res.string.lbl_search_online),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}
