package io.github.semenciuccosmin.lexiscore.feature.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import io.github.semenciuccosmin.lexiscore.feature.favorites.route.FavoriteRoute
import io.github.semenciuccosmin.lexiscore.feature.review.route.ReviewRoute
import io.github.semenciuccosmin.lexiscore.feature.top.route.TopRoute
import io.github.semenciuccosmin.lexiscore.ui.design.theme.LexiscoreTheme
import io.github.semenciuccosmin.lexiscore.ui.navigation.component.NavigationBar
import io.github.semenciuccosmin.lexiscore.ui.navigation.model.NavDestination
import io.github.semenciuccosmin.lexiscore.ui.navigation.model.navigationConfig

@Composable
fun App() {
    val backStack = rememberNavBackStack(navigationConfig, NavDestination.Main.Review)

    LexiscoreTheme {
        Scaffold(
            bottomBar = {
                NavigationBar(
                    selectedNavKey = backStack.lastOrNull(),
                    onSelectNavKey = { backStack.add(it) },
                )
            },
        ) { paddingValues ->
            NavDisplay(
                modifier = Modifier.padding(paddingValues),
                backStack = backStack,
                entryProvider = entryProvider {
                    entry<NavDestination.Main.Review> {
                        ReviewRoute()
                    }

                    entry<NavDestination.Main.Top> {
                        TopRoute()
                    }

                    entry<NavDestination.Main.Favorites> {
                        FavoriteRoute()
                    }
                }
            )
        }
    }
}