package gg.lode.nametagapi.bootstrap;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Lifecycle contract that the runtime-loaded Name Tag implementation
 * fulfils. The public {@code Name-Tag-Loader} jar is a JavaPlugin shim that
 * loads an implementation (via cloud or local jar), instantiates the entry
 * class, and forwards Bukkit lifecycle calls to it.
 *
 * <p>Implementations MUST have a public no-arg constructor so the loader
 * can instantiate them via reflection.
 */
public interface NameTagBootstrap {

    /**
     * Called from {@link JavaPlugin#onLoad()} on the host plugin.
     */
    void onLoad(JavaPlugin host);

    /**
     * Called from {@link JavaPlugin#onEnable()} on the host plugin.
     */
    void onEnable(JavaPlugin host);

    /**
     * Called from {@link JavaPlugin#onDisable()} on the host plugin.
     */
    void onDisable(JavaPlugin host);
}
