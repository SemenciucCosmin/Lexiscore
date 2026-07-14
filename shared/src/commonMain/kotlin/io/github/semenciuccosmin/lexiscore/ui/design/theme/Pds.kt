package io.github.semenciuccosmin.lexiscore.ui.design.theme

import io.github.semenciuccosmin.lexiscore.ui.design.dimension.DefaultIcon
import io.github.semenciuccosmin.lexiscore.ui.design.dimension.DefaultSpacing
import io.github.semenciuccosmin.lexiscore.ui.design.dimension.DefaultStroke

/**
 * Provides access to the default dimensions used in the application.
 */
object Pds {
    val spacing: DefaultSpacing
        get() = DefaultSpacing()

    val icon: DefaultIcon
        get() = DefaultIcon()

    val stroke: DefaultStroke
        get() = DefaultStroke()
}
