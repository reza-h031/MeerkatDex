package ir.companymeerkats.meerkatdex.view.game

import android.content.Context
import android.content.Intent
import android.net.Uri

fun openWebsite(
    context: Context,
    url: String
) {
    val normalizedUrl =
        if (
            url.startsWith("http://") ||
            url.startsWith("https://")
        ) {
            url
        } else {
            "https://$url"
        }

    val intent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse(normalizedUrl)
    )

    context.startActivity(intent)
}