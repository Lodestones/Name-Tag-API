package gg.lode.nametagapi;

import gg.lode.nametagapi.api.Skin;
import gg.lode.nametagapi.api.nick.NickRequest;
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
     * Nicks the player with a random name matching the given request.
     * <p>
     * A filtered request is answered by the shared pool directly rather than
     * from the warm local pool, which holds unfiltered names only — so unlike
     * {@link #randomNick(Player)} it costs a network round-trip and the nick
     * lands a moment later. Filters narrow the pool without binding it: when
     * too few names match, the pool widens rather than failing, so the name
     * may not honour every part of the request.
     *
     * @param request what kind of name to ask for; {@link NickRequest#any()}
     *                behaves exactly like {@link #randomNick(Player)}
     */
    void randomNick(Player player, NickRequest request);

    /**
     * Generates a single random, available nickname without touching any
     * online {@link Player}. Intended for consumers that disguise non-player
     * entities (e.g. packet NPCs). Performs network calls (cloud nick service
     * and/or Mojang availability checks) — call OFF the main thread.
     *
     * @return a random username, or {@code null} if generation failed.
     */
    @Nullable String getRandomNick();

    /**
     * Generates a single random nickname matching the given request, without
     * touching any online {@link Player}. Performs network calls — call OFF
     * the main thread.
     * <p>
     * The name is <strong>not</strong> reserved. With no player to hold it,
     * the claim on the shared pool is handed straight back, so the same name
     * may go to someone else moments later. Fine for disguising a packet NPC;
     * not something to persist.
     * <p>
     * Filters narrow the pool without binding it — see
     * {@link #randomNick(Player, NickRequest)}.
     *
     * @param request what kind of name to ask for
     * @return a random username, or {@code null} if generation failed.
     */
    @Nullable String getRandomNick(NickRequest request);

    /**
     * Returns a random skin (texture + signature) drawn from the built-in skin
     * pool, without touching any online {@link Player}. Intended for consumers
     * that disguise non-player entities (e.g. packet NPCs). Performs a Mojang
     * fetch — call OFF the main thread.
     *
     * @return a random {@link Skin}, or {@code null} if the fetch failed.
     */
    @Nullable Skin getRandomSkin();

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
