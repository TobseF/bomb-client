package de.its.game.client.bomb

enum class BombServerConfig(val ip: String) {
    Android("192.168.0.186"), Desktop("localhost");

    val port = 5000
}