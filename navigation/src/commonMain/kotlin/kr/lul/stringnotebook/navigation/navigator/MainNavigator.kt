package kr.lul.stringnotebook.navigation.navigator

import androidx.compose.runtime.Immutable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink
import kr.lul.logger.Logger
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Immutable
@OptIn(ExperimentalUuidApi::class)
class MainNavigator(
    private val base: BaseNavigator
) : Navigator by base {
    companion object : Destination {
        override val routePattern = "Main"
        override val arguments: List<NamedNavArgument> = emptyList()
        override val deepLinks: List<NavDeepLink> = emptyList()
        override fun route(vararg args: Any?) = if (args.isEmpty()) {
            routePattern
        } else {
            throw IllegalArgumentException("MainNavigator does not accept arguments")
        }
    }

    private val logger = Logger("MainNavigator")

    override val destination = Companion

    /**
     * 새 노트북.
     */
    fun notebook() {
        logger.d("#notebook called.")

        base.navController.navigate(NotebookNavigator.route())
    }

    /**
     * 노트북 열기.
     */
    fun notebook(id: Uuid) {
        logger.d("#notebook args : id=$id")

        base.navController.navigate(NotebookNavigator.route(id))
    }

    override fun toString() = listOf(
        "base=$base"
    ).joinToString(", ", "MainNavigator(", ")")
}