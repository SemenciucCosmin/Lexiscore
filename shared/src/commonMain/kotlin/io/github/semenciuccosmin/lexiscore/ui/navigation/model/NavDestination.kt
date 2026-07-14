package io.github.semenciuccosmin.lexiscore.ui.navigation.model

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface NavDestination : NavKey {

    @Serializable
    data object Main : NavDestination, NavKey {
        @Serializable
        data object Review : NavDestination, NavKey

        @Serializable
        data object Top : NavDestination, NavKey

        @Serializable
        data object Favorites : NavDestination, NavKey
    }
}
