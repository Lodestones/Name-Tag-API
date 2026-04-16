package gg.lode.nametagapi;

import gg.lode.nametagapi.api.Skin;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Copyright 2025 - Lodestone Services LLC
 *
 * @author John Aquino
 */
public interface INameTagAPI {

    void setNickname(Player player, String name);

    void setNickname(Player player, Component component);

    void setSkinFromPlayer(Player player, String playerName);

    void setNickFromPlayer(Player player, String playerName);

    boolean setSkinFromMineskinId(Player player, String id);

    boolean setSkinFromMineskinUrl(Player player, String url);

    boolean setSkinFromTextureAndSignature(Player player, String texture, String signature);


    @Nullable Skin getSkinFromMineskinId(String id);

    @Nullable Skin getSkinFromMineskinUrl(String url);

    void resetNickname(Player player);

    void resetSkin(Player player);

    void resetNick(Player player);

    boolean hasNick(Player player);

    @Nullable String getNick(Player player);

    @Nullable String getNick(UUID uniqueId);

    @Nullable Component getNickComponent(Player player);

    @Nullable Component getNickComponent(UUID uniqueId);

    @Nullable Skin getSkin(Player player);

    @Nullable Skin getSkin(UUID uniqueId);

    void randomNick(Player player);

    /**
     * Randomizes the player's nick and assigns a specific fake rank for TAB display.
     * Permissions are unaffected — only the TAB prefix/suffix changes.
     * Requires LuckPerms. If the group doesn't exist, the nick is still applied without a rank.
     */
    void randomNick(Player player, String groupName);

    /**
     * Nicks the player as an existing player's skin/name, with a specific fake rank for TAB display.
     */
    void setNickFromPlayer(Player player, String playerName, String groupName);

    /**
     * Sets only the display name, with a specific fake rank for TAB display.
     */
    void setNickname(Player player, String name, String groupName);

    /**
     * Applies a fake rank override for TAB display (prefix/suffix) without changing the nick.
     * Requires LuckPerms. Passing an unknown group has no effect.
     */
    void setFakeRank(Player player, String groupName);

    /**
     * Clears the fake rank override, restoring LuckPerms-driven TAB display.
     */
    void clearFakeRank(Player player);

    void resetAllNicks();

    void shouldChangeUniqueId(boolean shouldChange);

    boolean shouldChangeUniqueId();

}
