package io.github.semenciuccosmin.lexiscore.ui.navigation.component

import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import io.github.semenciuccosmin.lexiscore.ui.navigation.model.NavigationBarEntry

val NavBackStack<NavKey>.isBottomDestination: Boolean
    get() = this.lastOrNull() in NavigationBarEntry.entries.map { it.navKey }
