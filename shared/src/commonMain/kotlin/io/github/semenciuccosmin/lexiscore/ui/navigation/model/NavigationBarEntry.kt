package io.github.semenciuccosmin.lexiscore.ui.navigation.model

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation3.runtime.NavKey
import io.github.semenciuccosmin.lexiscore.ui.design.icons.Dictionary
import io.github.semenciuccosmin.lexiscore.ui.design.icons.Heart
import io.github.semenciuccosmin.lexiscore.ui.design.icons.Leaderboard
import io.github.semenciuccosmin.lexiscore.ui.design.icons.LexiscoreIcons
import lexiscore.shared.generated.resources.Res
import lexiscore.shared.generated.resources.lbl_favorites
import lexiscore.shared.generated.resources.lbl_review
import lexiscore.shared.generated.resources.lbl_top
import org.jetbrains.compose.resources.StringResource

enum class NavigationBarEntry(
    val imageVector: ImageVector,
    val titleRes: StringResource,
    val navKey: NavKey,
) {
    Review(
        imageVector = LexiscoreIcons.Dictionary,
        titleRes = Res.string.lbl_review,
        navKey = NavDestination.Main.Review
    ),
    Top(
        imageVector = LexiscoreIcons.Leaderboard,
        titleRes = Res.string.lbl_top,
        navKey = NavDestination.Main.Top
    ),
    Favorites(
        imageVector = LexiscoreIcons.Heart,
        titleRes = Res.string.lbl_favorites,
        navKey = NavDestination.Main.Favorites
    )
}
