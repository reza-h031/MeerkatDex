package ir.companymeerkats.meerkatdex.view.navigation

sealed class Screen(
    val route: String
) {

    data object Home : Screen("home")

    data object Search : Screen("search")

    data object More : Screen("more")

    data object GameDetail : Screen("game/{gameId}") {
        fun createRoute(gameId: Long): String {
            return "game/$gameId"
        }
    }
}