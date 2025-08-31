package kr.lul.stringnotebook.state.organism

import kotlinx.datetime.Instant
import kr.lul.stringnotebook.state.molecule.State
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalUuidApi
interface NoteState : State {
    /**
     * @see kr.lul.stringnotebook.domain.foundation.Note.id
     */
    val id: Uuid

    /**
     * @see kr.lul.stringnotebook.domain.foundation.Note.name
     */
    var name: String?

    /**
     * @see kr.lul.stringnotebook.domain.foundation.Note.memo
     */
    var memo: String?

    /**
     * @see kr.lul.stringnotebook.domain.foundation.Note.createdAt
     */
    val createdAt: Instant

    /**
     * @see kr.lul.stringnotebook.domain.foundation.Note.updatedAt
     */
    val updatedAt: Instant
}
