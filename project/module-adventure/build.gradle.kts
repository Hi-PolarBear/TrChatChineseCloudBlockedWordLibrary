dependencies {
    compileOnly(project(":project:common"))
//    compileOnly(project(":project:module-chat"))
    compileOnly("net.kyori:adventure-platform-bukkit:4.4.1")
    compileOnly("net.kyori:adventure-text-serializer-plain:4.24.0")
    // paper native
    compileOnly(fileTree(rootDir.resolve("libs")))
}

taboolib { subproject = true }