package me.arasple.mc.trchat.module.internal.hook.impl

import me.arasple.mc.trchat.module.internal.hook.Hook
import me.arasple.mc.trchat.module.internal.hook.type.HookVanish
import org.bukkit.OfflinePlayer
import org.sayandev.sayanvanish.bukkit.api.SayanVanishBukkitAPI.Companion.user
import taboolib.common.platform.Platform

@Hook([Platform.BUKKIT])
class HookSayanVanish : HookVanish() {

    override fun isVanished(player: OfflinePlayer): Boolean {
        if (!isHooked) {
            return false
        }
        return player.user()?.isVanished ?: return false
    }

}