package io.github.semenciuccosmin.lexiscore.domain.extensions

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri

actual fun openUrl(url: String, platformContext: Any?, onFailure: () -> Unit) {
    val context = platformContext as? Context ?: return
    val intent = Intent(Intent.ACTION_VIEW, url.toUri()).apply {
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }

    try {
        context.startActivity(intent)
    } catch (_: Exception) {
        onFailure()
    }
}