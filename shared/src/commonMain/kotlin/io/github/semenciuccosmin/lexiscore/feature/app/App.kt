package io.github.semenciuccosmin.lexiscore.feature.app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.metadata
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import io.github.semenciuccosmin.lexiscore.feature.favourites.route.FavouriteRoute
import io.github.semenciuccosmin.lexiscore.feature.review.route.ReviewRoute
import io.github.semenciuccosmin.lexiscore.feature.top.route.TopRoute
import io.github.semenciuccosmin.lexiscore.feature.word.route.WordRoute
import io.github.semenciuccosmin.lexiscore.ui.design.theme.LexiscoreTheme
import io.github.semenciuccosmin.lexiscore.ui.navigation.component.NavigationBar
import io.github.semenciuccosmin.lexiscore.ui.navigation.component.isBottomDestination
import io.github.semenciuccosmin.lexiscore.ui.navigation.model.NavDestination
import io.github.semenciuccosmin.lexiscore.ui.navigation.model.navigationConfig

@Composable
fun App() {
    val backStack = rememberNavBackStack(navigationConfig, NavDestination.Main.Review)

    LexiscoreTheme {
        Scaffold(
            contentWindowInsets = ScaffoldDefaults.contentWindowInsets.only(
                WindowInsetsSides.Bottom
            ),
            bottomBar = {
                AnimatedVisibility(
                    visible = backStack.isBottomDestination,
                    enter = expandVertically() + fadeIn(),
                    exit = shrinkVertically() + fadeOut(),
                ) {
                    NavigationBar(
                        selectedNavKey = backStack.lastOrNull(),
                        onSelectNavKey = { backStack.add(it) },
                    )
                }
            }
        ) { paddingValues ->
            NavDisplay(
                modifier = Modifier.padding(paddingValues),
                backStack = backStack,
                entryProvider = entryProvider {
                    entry<NavDestination.Main.Review>(
                        metadata = metadata {
                            put(NavDisplay.TransitionKey) {
                                fadeIn() togetherWith fadeOut()
                            }
                            put(NavDisplay.PopTransitionKey) {
                                fadeIn() togetherWith fadeOut()
                            }
                            put(NavDisplay.PredictivePopTransitionKey) {
                                fadeIn() togetherWith fadeOut()
                            }
                        }
                    ) {
                        ReviewRoute()
                    }

                    entry<NavDestination.Main.Top>(
                        metadata = metadata {
                            put(NavDisplay.TransitionKey) {
                                fadeIn() togetherWith fadeOut()
                            }
                            put(NavDisplay.PopTransitionKey) {
                                fadeIn() togetherWith fadeOut()
                            }
                            put(NavDisplay.PredictivePopTransitionKey) {
                                fadeIn() togetherWith fadeOut()
                            }
                        }
                    ) {
                        TopRoute()
                    }

                    entry<NavDestination.Main.Favourites>(
                        metadata = metadata {
                            put(NavDisplay.TransitionKey) {
                                fadeIn() togetherWith fadeOut()
                            }
                            put(NavDisplay.PopTransitionKey) {
                                fadeIn() togetherWith fadeOut()
                            }
                            put(NavDisplay.PredictivePopTransitionKey) {
                                fadeIn() togetherWith fadeOut()
                            }
                        }
                    ) {
                        FavouriteRoute(
                            onItemClick = { wordId ->
                                backStack.add(NavDestination.Main.Word(wordId))
                            }
                        )
                    }

                    entry<NavDestination.Main.Word> {
                        WordRoute(
                            wordId = it.wordId,
                            onBack = backStack::removeLast
                        )
                    }
                }
            )
        }
    }
}