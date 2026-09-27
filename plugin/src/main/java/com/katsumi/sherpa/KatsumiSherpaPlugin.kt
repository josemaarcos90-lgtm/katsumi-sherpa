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

    @UsedByGodot
    fun loadNativeLibraries(): String {
        return try {
            System.loadLibrary("onnxruntime")
            System.loadLibrary("sherpa-onnx-c-api")
            System.loadLibrary("sherpa-onnx-cxx-api")
            System.loadLibrary("sherpa-onnx-jni")
            val message = "KATSUMI SHERPA | NATIVE LIBS OK"
            Log.i(pluginName, message)
            message
        } catch (error: Throwable) {
            val message = "KATSUMI SHERPA | NATIVE LIBS ERROR: ${error.javaClass.simpleName}: ${error.message}"
            Log.e(pluginName, message, error)
            message
        }
    }

    @UsedByGodot
    fun getBridgeVersion(): String = "0.2.0-sherpa-onnx-1.13.8"
}
