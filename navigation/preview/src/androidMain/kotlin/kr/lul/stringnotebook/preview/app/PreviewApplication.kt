package kr.lul.stringnotebook.preview.app

import android.app.Application
import kr.lul.logger.Logger
import kotlin.uuid.ExperimentalUuidApi

/**
 * 네비게이션 프리뷰를 위한 애플리케이션 클래스
 *
 * @see Application
 */
@ExperimentalUuidApi
class PreviewApplication : Application() {
    private val logger = Logger("PreviewApplication")

    override fun onCreate() {
        logger.i("#onCreated called.")
        super.onCreate()
    }
}