package kr.lul.stringnotebook.preview.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import kr.lul.logger.Logger
import kr.lul.logger.i

/**
 * 네비게이션 프리뷰를 위한 메인 액티비티
 *
 * @see ComponentActivity
 */
class MainActivity : ComponentActivity() {
    private val logger = Logger("MainActivity")

    override fun onCreate(savedInstanceState: Bundle?) {
        logger.i { "#onCreate args : savedInstanceState=$savedInstanceState" }

        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
        }
    }
}