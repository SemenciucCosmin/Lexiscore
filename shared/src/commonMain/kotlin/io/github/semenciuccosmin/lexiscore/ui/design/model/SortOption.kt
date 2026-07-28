package io.github.semenciuccosmin.lexiscore.ui.design.model

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import lexiscore.shared.generated.resources.Res
import lexiscore.shared.generated.resources.lbl_sort_option_alphabetical
import lexiscore.shared.generated.resources.lbl_sort_option_reverse_alphabetical
import lexiscore.shared.generated.resources.lbl_sort_option_score_ascending
import lexiscore.shared.generated.resources.lbl_sort_option_score_descending
import org.jetbrains.compose.resources.StringResource

enum class SortOption(val labelRes: StringResource) {
    SCORE_DESCENDING(
        labelRes = Res.string.lbl_sort_option_score_descending
    ),
    SCORE_ASCENDING(
        labelRes = Res.string.lbl_sort_option_score_ascending
    ),
    ALPHABETICAL(
        labelRes = Res.string.lbl_sort_option_alphabetical
    ),
    REVERSE_ALPHABETICAL(
        labelRes = Res.string.lbl_sort_option_reverse_alphabetical
    );

    companion object {
        fun toMenuItems(): ImmutableList<MenuItem> {
            return entries.map { sortOption ->
                MenuItem(
                    id = sortOption.name,
                    labelRes = sortOption.labelRes
                )
            }.toImmutableList()
        }
    }
}
