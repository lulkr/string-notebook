package kr.lul.stringnotebook.domain.foundation

import kr.lul.stringnotebook.domain.foundation.Configuration.ID_PREFIX_NOTEBOOK_ANCHOR
import kr.lul.stringnotebook.domain.foundation.Configuration.generateId
import kr.lul.stringnotebook.domain.notebook.Note
import kr.lul.stringnotebook.domain.property.PositionProperty
import kotlin.random.Random
import kotlin.uuid.ExperimentalUuidApi

/**
 * 어떤 [kr.lul.stringnotebook.domain.notebook.Note]의 위치.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
interface Anchor : Note {
    companion object {
        internal fun id(suffix: Long = Random.nextLong(0xFFFFFFFFFFFFL)) = ID_PREFIX_NOTEBOOK_ANCHOR.generateId(suffix)
    }

    /**
     * 종류.
     */
    var type: AnchorType

    /**
     * 위치.
     */
    val position: PositionProperty
}