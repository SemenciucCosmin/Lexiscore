package io.github.semenciuccosmin.lexiscore.domain.extensions

import platform.Foundation.NSURL
import platform.UIKit.UIApplication

actual fun openUrl(url: String, platformContext: Any?, onFailure: () -> Unit) {
    val nsUrl = NSURL.URLWithString(url)
    if (nsUrl != null) {
        UIApplication.sharedApplication.openURL(
            url = nsUrl,
            options = emptyMap<Any?, Any>(),
            completionHandler = null
        )
    }
}