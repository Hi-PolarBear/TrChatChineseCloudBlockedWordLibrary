dependencies {
    compileOnly(project(":project:common"))
//    compileOnly(project(":project:module-chat"))
    compileOnly("net.kyori:adventure-platform-bukkit:4.4.0")
    compileOnly("net.kyori:adventure-text-serializer-plain:4.21.0")
    // paper native
    compileOnly(fileTree(rootDir.resolve("libs")))
}

taboolib { subproject = true }