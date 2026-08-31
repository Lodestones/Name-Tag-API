package gg.lode.nametagapi.api.nick;

import org.jetbrains.annotations.Nullable;

/**
 * The shape of a nickname — how it is built, not what it is about.
 * <p>
 * A name carries every form that applies to it, and they overlap on purpose:
 * {@code xFrost_99} is a {@link #GAMER_TAG}, {@link #UNDERSCORE} and
 * {@link #NUMBERED} all at once, so excluding any one of the three rules it
 * out. Forms are derived from the text itself, so this set only changes when
 * the classifier does.
 *
 * @see NickRequest
 */
public enum NickForm {

    /** A single dictionary word: {@code Willow}. */
    PLAIN_WORD("plain_word"),
    /** Two words run together: {@code SilverBrook}. */
    COMPOUND("compound"),
    /** Contains a digit anywhere: {@code Panda9}. */
    NUMBERED("numbered"),
    /** Ends in something that reads as a year: {@code Comet2011}. */
    YEAR("year"),
    /** Contains an underscore: {@code dust_devil}. */
    UNDERSCORE("underscore"),
    /** A digit standing in for a letter inside a word: {@code 3lectroFox}. */
    LEETSPEAK("leetspeak"),
    /** Short enough to read as a handle rather than a name. */
    SHORT_HANDLE("short_handle"),
    /** Long enough to wrap awkwardly in a tab list. */
    LONG_NAME("long_name"),
    /** Carries a gamer-tag prefix: {@code xFrost}, {@code ItzMaple}. */
    GAMER_TAG("gamer_tag"),
    /** No lowercase letters: {@code BLIZZARD}. */
    ALL_CAPS("all_caps"),
    /** No uppercase letters: {@code driftwood}. */
    ALL_LOWERCASE("all_lowercase"),
    /** Mixed case somewhere other than the first letter. */
    MIXED_CASE("mixed_case");

    private final String wireName;

    NickForm(String wireName) {
        this.wireName = wireName;
    }

    /** The name this form travels under. */
    public String wireName() {
        return wireName;
    }

    /**
     * The form with the given wire name, or {@code null} when nothing matches.
     * Case-insensitive.
     */
    public static @Nullable NickForm fromWireName(@Nullable String wireName) {
        if (wireName == null) return null;
        for (NickForm form : values()) {
            if (form.wireName.equalsIgnoreCase(wireName)) return form;
        }
        return null;
    }
}
