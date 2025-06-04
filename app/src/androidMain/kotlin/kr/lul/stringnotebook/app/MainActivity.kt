package kr.lul.stringnotebook.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import kr.lul.logger.Logger
import kr.lul.logger.i
import kr.lul.stringnotebook.navigation.Root
import kr.lul.stringnotebook.navigation.compose.rememberBaseNavigator
import kr.lul.stringnotebook.navigation.navigator.SplashNavigator

class MainActivity : ComponentActivity() {
    private val logger = Logger("MainActivity")

    override fun onCreate(savedInstanceState: Bundle?) {
        logger.i { "#onCreate args : savedInstanceState=$savedInstanceState" }

        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            Root(rememberBaseNavigator(SplashNavigator, rememberNavController()))
        }
    }
}