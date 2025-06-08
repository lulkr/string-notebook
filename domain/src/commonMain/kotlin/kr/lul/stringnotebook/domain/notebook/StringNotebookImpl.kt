package kr.lul.stringnotebook.domain.notebook

import kr.lul.stringnotebook.domain.foundation.Anchor
import kr.lul.stringnotebook.domain.foundation.Object
import kr.lul.stringnotebook.domain.foundation.StringNotebook
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
open class StringNotebookImpl(
    override val id: Uuid = StringNotebook.id(),
    override var name: String
) : StringNotebook {
    protected open val _objects = mutableListOf<Object<*>>()
    override val objects: List<Object<*>>
        get() = _objects

    override val anchors: List<Anchor>
        get() = _objects.filterIsInstance<Anchor>()

    override fun get(id: Uuid): Object<*>? = _objects.firstOrNull { id == it.id }

    override fun remove(id: Uuid): Object<*>? {
        val element = get(id)
        _objects.remove(element)
        return element
    }

    override fun remove(anchor: Anchor) {
        _objects.remove(anchor)
    }

    override fun add(anchor: Anchor) {
        _objects.add(anchor)
    }
}