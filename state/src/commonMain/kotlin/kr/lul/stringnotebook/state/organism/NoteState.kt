package kr.lul.stringnotebook.state.organism

import kotlinx.datetime.Instant
import kr.lul.stringnotebook.state.molecule.State
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalUuidApi
interface NoteState : State {
    /**
     * @see kr.lul.stringnotebook.domain.notebook.Note.id
     */
    val id: Uuid

    /**
     * @see kr.lul.stringnotebook.domain.notebook.Note.name
     */
    var name: String?

    /**
     * @see kr.lul.stringnotebook.domain.notebook.Note.memo
     */
    var memo: String?

    /**
     * @see kr.lul.stringnotebook.domain.notebook.Note.createdAt
     */
    val createdAt: Instant

    /**
     * @see kr.lul.stringnotebook.domain.notebook.Note.updatedAt
     */
    val updatedAt: Instant
}
