package kr.lul.stringnotebook.preview.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import kr.lul.logger.Logger
import kr.lul.logger.i

class DummyActivity : ComponentActivity() {
    private val logger = Logger("DummyActivity")

    override fun onCreate(savedInstanceState: Bundle?) {
        logger.i { "#onCreate args : savedInstanceState=$savedInstanceState" }

        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
        }
    }
}