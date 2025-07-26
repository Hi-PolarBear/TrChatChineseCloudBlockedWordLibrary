package me.arasple.mc.trchat.api.event

import me.arasple.mc.trchat.module.display.ChatSession
import me.arasple.mc.trchat.module.display.channel.Channel
import me.arasple.mc.trchat.module.display.channel.PrivateChannel
import taboolib.module.chat.ComponentText
import taboolib.module.chat.Components
import taboolib.platform.type.BukkitProxyEvent

/**
 * TrChatEvent
 * me.arasple.mc.trchat.api.event
 *
 * @author ItsFlicker
 * @since 2021/8/20 20:53
 */
class TrChatEvent(
    val channel: Channel,
    val session: ChatSession,
    var component: ComponentText,
    @Deprecated("Only for chat preview")
    val forward: Boolean = true
) : BukkitProxyEvent() {

    val player = session.player

    var message = component.toLegacyText()
        set(value) {
            field = value
            component = Components.text(value)
        }

    init {
        if (channel is PrivateChannel) {
            val event = TrChatPrivateEvent(channel, session, component)
            event.call()
            this.isCancelled = event.isCancelled
            this.component = event.component
        }
    }

}