package com.mygdx.game

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
class DesktopLauncher {

	fun createApplication(): Lwjgl3Application? {
		return Lwjgl3Application(MyGdxGame(), getDefaultConfiguration())
	}

	private fun getDefaultConfiguration(): Lwjgl3ApplicationConfiguration? {
		val configuration = Lwjgl3ApplicationConfiguration()
		configuration.setTitle("Base template")
		configuration.setForegroundFPS(60)
		configuration.setWindowedMode(Game.width, Game.heigth)
		configuration.setResizable(true)
		return configuration
	}
}

fun main(arg: Array<String>) {
	DesktopLauncher().createApplication()
}
