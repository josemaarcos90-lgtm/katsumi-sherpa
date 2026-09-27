package com.katsumi.sherpa

import android.util.Log
import org.godotengine.godot.Godot
import org.godotengine.godot.plugin.GodotPlugin
import org.godotengine.godot.plugin.UsedByGodot

class KatsumiSherpaPlugin(godot: Godot) : GodotPlugin(godot) {
    override fun getPluginName() = BuildConfig.GODOT_PLUGIN_NAME

    @UsedByGodot
    fun ping(): String {
        val message = "KATSUMI SHERPA | PLUGIN OK"
        Log.i(pluginName, message)
        return message
    }
}
