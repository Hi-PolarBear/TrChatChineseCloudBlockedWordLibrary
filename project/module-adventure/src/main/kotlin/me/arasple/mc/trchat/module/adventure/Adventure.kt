package me.arasple.mc.trchat.module.adventure

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer
import org.bukkit.inventory.ItemStack
import taboolib.module.chat.ComponentText
import taboolib.module.chat.impl.AdventureComponent

private val legacySerializer: Any? = try {
    LegacyComponentSerializer.legacySection()
} catch (_: Throwable) {
    null
}

private val gsonSerializer: Any? = try {
    GsonComponentSerializer.gson()
} catch (_: Throwable) {
    null
}

fun gson(component: Component) = (gsonSerializer as GsonComponentSerializer).serialize(component)

fun gson(string: String) = (gsonSerializer as GsonComponentSerializer).deserialize(string)

fun ComponentText.toAdventure(): Component {
    if (this is AdventureComponent) return this.component
    else return gson(this.toRawMessage())
}

fun ComponentText.hoverItemAdventure(item: ItemStack): ComponentText {
    this as? AdventureComponent ?: error("Unsupported component type.")
    this.latest.hoverEvent(item.asHoverEvent())
    return this
}