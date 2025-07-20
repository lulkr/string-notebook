package kr.lul.stringnotebook.ui.organism

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.molecule.NodeProperties
import kr.lul.stringnotebook.state.organism.Context
import kr.lul.stringnotebook.state.organism.NodeState
import kr.lul.stringnotebook.state.organism.ObjectEditContext
import kr.lul.stringnotebook.state.organism.ObjectFocusedContext
import kr.lul.stringnotebook.ui.atom.apply
import kr.lul.stringnotebook.ui.molecule.NodePropertiesDefaults
import kotlin.uuid.ExperimentalUuidApi

@Composable
@ExperimentalStdlibApi
@ExperimentalUuidApi
fun Node(
    node: NodeState,
    context: Context,
    processor: EventProcessor,
    properties: NodeProperties = NodePropertiesDefaults.default()
) {
    logger.v("#Node args : node=$node, context=$context, processor=$processor, properties=${properties.summary}")

    when {
        context is ObjectFocusedContext && node == context.obj ->
            NodeFocused(node, context, processor, properties)

        context is ObjectEditContext && node == context.obj ->
            NodeEditor(node, context, processor, properties)

        else ->
            NodeDefault(node, context, processor, properties)
    }
}

@Composable
@ExperimentalStdlibApi
@ExperimentalUuidApi
fun NodeDefault(
    node: NodeState,
    context: Context,
    processor: EventProcessor,
    properties: NodeProperties = NodePropertiesDefaults.default()
) {
    Text(
        text = node.text,
        modifier = Modifier.apply(properties)
    )
}

@Composable
@ExperimentalStdlibApi
@ExperimentalUuidApi
fun NodeEditor(
    node: NodeState,
    context: ObjectEditContext,
    processor: EventProcessor,
    properties: NodeProperties = NodePropertiesDefaults.editing()
) {
    val focusRequester = remember(node.id, context) { FocusRequester() }
    LaunchedEffect(node.id, context) {
        focusRequester.requestFocus()
    }

    OutlinedTextField(
        value = node.text,
        onValueChange = {
            logger.d("#NodeEditor.onValueChange : node=$node, context=$context, value=$it")
        },
        modifier = Modifier.apply(properties)
            .focusRequester(focusRequester)
    )
}

@Composable
@ExperimentalStdlibApi
@ExperimentalUuidApi
fun NodeFocused(
    node: NodeState,
    context: ObjectFocusedContext,
    processor: EventProcessor,
    properties: NodeProperties = NodePropertiesDefaults.default()
) {
    require(node == context.obj) {
        "focused node does not match context object : node=${node}, context=${context.obj}"
    }

    Text(
        text = node.text,
        modifier = Modifier.apply(properties)
    )
}

