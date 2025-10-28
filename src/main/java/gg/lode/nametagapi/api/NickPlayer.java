package gg.lode.nametagapi.api;

import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Copyright 2025 - Lodestone Services LLC
 *
 * @author John Aquino
 */
public class NickPlayer {
    private final UUID uuid;
    private final UUID originalUniqueId;
    // Current state (what's stored)
    private String nickname;
    private String skinName;
    private String texture;
    private String signature;
    // Original state
    private String originalName;
    private String originalTexture;
    private String originalSignature;
    // Nicked state
    private String nickedName;
    private String nickedTexture;
    private String nickedSignature;
    private UUID nickedUniqueId;

    public NickPlayer(UUID uuid) {
        this.uuid = uuid;
        this.originalUniqueId = uuid;
        this.nickedUniqueId = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Nullable
    public String getNickname() {
        return nickname;
    }

    public void setNickname(@Nullable String nickname) {
        this.nickname = nickname;
        this.nickedName = nickname;
    }

    @Nullable
    public String getSkinName() {
        return skinName;
    }

    public void setSkinName(@Nullable String skinName) {
        this.skinName = skinName;
    }

    @Nullable
    public String getTexture() {
        return texture;
    }

    public void setTexture(@Nullable String texture) {
        this.texture = texture;
        this.nickedTexture = texture;
    }

    @Nullable
    public String getSignature() {
        return signature;
    }

    public void setSignature(@Nullable String signature) {
        this.signature = signature;
        this.nickedSignature = signature;
    }

    @Nullable
    public Skin getSkin() {
        if (texture != null && signature != null) {
            return new Skin(texture, signature);
        }
        return null;
    }

    public void setSkin(@Nullable Skin skin) {
        if (skin != null) {
            this.texture = skin.texture();
            this.signature = skin.signature();
            this.nickedTexture = skin.texture();
            this.nickedSignature = skin.signature();
        } else {
            this.texture = null;
            this.signature = null;
            this.nickedTexture = null;
            this.nickedSignature = null;
        }
    }

    public boolean hasNick() {
        return nickname != null || skinName != null || texture != null || signature != null;
    }

    public void reset() {
        this.nickname = null;
        this.skinName = null;
        this.texture = null;
        this.signature = null;
        this.nickedName = null;
        this.nickedTexture = null;
        this.nickedSignature = null;
        this.nickedUniqueId = this.originalUniqueId;
    }

    // Original data getters/setters
    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
        if (this.nickedName == null) {
            this.nickedName = originalName;
        }
    }

    public String getOriginalTexture() {
        return originalTexture;
    }

    public void setOriginalTexture(String originalTexture) {
        this.originalTexture = originalTexture;
        if (this.nickedTexture == null) {
            this.nickedTexture = originalTexture;
        }
    }

    public String getOriginalSignature() {
        return originalSignature;
    }

    public void setOriginalSignature(String originalSignature) {
        this.originalSignature = originalSignature;
        if (this.nickedSignature == null) {
            this.nickedSignature = originalSignature;
        }
    }

    public UUID getOriginalUniqueId() {
        return originalUniqueId;
    }

    public UUID getNickedUniqueId() {
        return nickedUniqueId;
    }

    public void setNickedUniqueId(UUID nickedUniqueId) {
        this.nickedUniqueId = nickedUniqueId;
    }

    public String getNickedName() {
        return nickedName;
    }

    public void setNickedName(String nickedName) {
        this.nickedName = nickedName;
        this.nickname = nickedName;
    }

    public String getNickedTexture() {
        return nickedTexture;
    }

    public String getNickedSignature() {
        return nickedSignature;
    }

    public boolean isCurrentlyNicked() {
        return hasNick();
    }
} 
