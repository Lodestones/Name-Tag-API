package gg.lode.nametagapi;

import gg.lode.nametagapi.api.Skin;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface INameTagAPI {

    void setNickname(Player player, String name);
    void setNickname(Player player, Component component);
    void setSkinFromPlayer(Player player, String playerName);
    void setNickFromPlayer(Player player, String playerName);
    boolean setSkinFromMineskinFromId(Player player, String id);
    boolean setSkinFromMineskinUrl(Player player, String url);
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

    void reset();

}
