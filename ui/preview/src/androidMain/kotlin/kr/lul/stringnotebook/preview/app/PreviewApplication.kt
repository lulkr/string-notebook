package kr.lul.stringnotebook.preview.app

import android.app.Application
import kr.lul.logger.Logger
import kr.lul.logger.d
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
class PreviewApplication : Application() {
    private val logger = Logger("PreviewApplication")

    override fun onCreate() {
        logger.d { "#onCreated called." }
        super.onCreate()
    }
}