package io.github.semenciuccosmin.lexiscore.ui.design.model

import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.StringResource

data class MenuItem(
    val id: String,
    val labelRes: StringResource,
    val imageVector: ImageVector? = null
)
