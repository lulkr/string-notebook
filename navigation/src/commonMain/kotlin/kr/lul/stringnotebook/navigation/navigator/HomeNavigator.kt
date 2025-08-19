package kr.lul.stringnotebook.navigation.navigator

import androidx.compose.runtime.Immutable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink
import kr.lul.logger.Logger
import kr.lul.stringnotebook.state.organism.NotebookState
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalUuidApi
@Immutable
class HomeNavigator(
    private val base: BaseNavigator
) : Navigator by base {
    companion object : Destination<HomeNavigator> {
        override val route = "home"
        override val arguments: List<NamedNavArgument> = emptyList()
        override val deepLinks: List<NavDeepLink> = emptyList()

        override fun route(vararg args: Any?) = if (args.isEmpty()) {
            route
        } else {
            throw IllegalArgumentException("HomeNavigator does not accept arguments")
        }
    }

    private val logger = Logger("HomeNavigator")

    override val destination = Companion

    /**
     * 노트북 열기.
     *
     * @param id 노트북 ID.
     */
    fun notebook(id: Uuid) {
        logger.d("#notebook args : id=$id")

        base.navController.navigate(NotebookNavigator.route(id))
    }

    /**
     * 노트북 열기.
     *
     * @param notebook 노트북.
     */
    fun notebook(notebook: NotebookState) {
        logger.d("#notebook args : notebook=$notebook")
        notebook(notebook.id)
    }

    override fun toString() = listOf(
        "base=$base"
    ).joinToString(", ", "HomeNavigator(", ")")
}