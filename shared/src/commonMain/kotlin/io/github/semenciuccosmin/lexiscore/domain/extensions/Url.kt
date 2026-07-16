package io.github.semenciuccosmin.lexiscore.domain.extensions

/**
 * Opens the given [url] in the system’s default browser.
 * @param url The URL to open (must be absolute).
 * @param platformContext Optional context, required only on Android.
 */
expect fun openUrl(
    url: String,
    platformContext: Any?,
    onFailure: () -> Unit
)