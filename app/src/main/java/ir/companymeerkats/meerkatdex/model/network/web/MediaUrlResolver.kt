package ir.companymeerkats.meerkatdex.model.network.web

import javax.inject.Inject

class MediaUrlResolver @Inject constructor() {

    private val baseUrl = "http://10.90.14.47:8080/"

    fun resolve(path: String?): String? {
        if (path.isNullOrBlank()) {
            return null
        }

        if (path.startsWith("http://") || path.startsWith("https://")) {
            return path
        }

        return "${baseUrl}storage/${path.trimStart('/')}"
    }
}