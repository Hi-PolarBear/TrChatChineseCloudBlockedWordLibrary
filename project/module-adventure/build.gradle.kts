dependencies {
    compileOnly(project(":project:common"))
    compileOnly(project(":project:module-nms"))
    compileOnly("net.kyori:adventure-platform-bukkit:4.4.0")
    compileOnly(fileTree(rootDir.resolve("libs")))
}

taboolib { subproject = true }