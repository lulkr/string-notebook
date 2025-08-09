package kr.lul.stringnotebook.navigation.navigator

import androidx.compose.runtime.Immutable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink
import androidx.navigation.NavType.Companion.StringType
import androidx.navigation.navArgument
import kr.lul.logger.Logger
import kr.lul.stringnotebook.state.page.NotebookPageState.Companion.ARG_NOTEBOOK_ID
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalUuidApi
@Immutable
class NotebookNavigator(
    private val base: BaseNavigator
) : Navigator by base {
    companion object : Destination<NotebookNavigator> {
        override val route = "notebook/{$ARG_NOTEBOOK_ID}"

        override val arguments: List<NamedNavArgument> = listOf(
            navArgument(ARG_NOTEBOOK_ID) {
                type = StringType
                nullable = false
            }
        )

        override val deepLinks: List<NavDeepLink> = emptyList()

        override fun route(vararg args: Any?): String = when {
            args.size == 1 && args[0] is Uuid ->
                "notebook/${args[0]}"

            else ->
                throw IllegalArgumentException("notebook page should only use Uuid type notebook ID : args=${args.toList()}")
        }
    }

    private val logger = Logger("NotebookNavigator")

    override val destination = Companion

    override fun toString() = "NotebookNavigator(base=$base)"
}