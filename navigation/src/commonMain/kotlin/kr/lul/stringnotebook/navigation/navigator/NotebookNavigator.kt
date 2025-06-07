package kr.lul.stringnotebook.navigation.navigator

import androidx.compose.runtime.Immutable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink
import androidx.navigation.NavType
import androidx.navigation.navArgument
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Immutable
class NotebookNavigator(
    private val base: BaseNavigator
) : Navigator by base {
    @OptIn(ExperimentalUuidApi::class)
    companion object : Destination {
        const val ARG_ID = "id"

        override val routePattern = "Notebook/{$ARG_ID}"

        override val arguments: List<NamedNavArgument> = listOf(
            navArgument(ARG_ID) {
                type = NavType.StringType
                nullable = true
            }
        )

        override val deepLinks: List<NavDeepLink> = emptyList()

        override fun route(vararg args: Any?) = when {
            args.isEmpty() ->
                "Notebook/"

            1 == args.size && args[0] is Uuid ->
                route(args[0] as Uuid)

            else ->
                throw IllegalArgumentException("NotebookNavigator does not accept arguments")
        }

        fun route(id: Uuid) = "Notebook/${id}"
    }

    override val destination: Destination = Companion

    override fun toString() = listOf(
        "base=$base"
    ).joinToString(", ", "NotebookNavigator(", ")")
}