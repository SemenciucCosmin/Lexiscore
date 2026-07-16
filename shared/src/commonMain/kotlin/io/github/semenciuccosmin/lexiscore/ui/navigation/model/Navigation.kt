package io.github.semenciuccosmin.lexiscore.ui.navigation.model

import androidx.navigation3.runtime.NavKey
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

val navigationConfig = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(NavDestination.Main.Review::class, NavDestination.Main.Review.serializer())
            subclass(NavDestination.Main.Top::class, NavDestination.Main.Top.serializer())
            subclass(NavDestination.Main.Favourites::class, NavDestination.Main.Favourites.serializer())
        }
    }
}
