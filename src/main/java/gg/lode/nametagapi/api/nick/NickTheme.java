package gg.lode.nametagapi.api.nick;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.Objects;

/**
 * What a nickname is about. A name carries at most one.
 * <p>
 * Deliberately not an enum. Themes are a property of the shared name pool, not
 * of this plugin, and new ones are added there without a plugin release — so
 * {@link #of(String)} accepts any theme the pool knows, including ones added
 * after the version of the API you compiled against. The constants below are
 * the themes that existed at the time of writing and are provided for
 * convenience and typo-safety, not as a closed set.
 * <p>
 * An unknown theme is not an error here: the pool answers a request it cannot
 * satisfy by widening, so you get a name rather than nothing.
 *
 * @see NickRequest
 */
public final class NickTheme {

    public static final NickTheme FANTASY = of("fantasy");
    public static final NickTheme CRYPTIC = of("cryptic");
    public static final NickTheme HUMOUR = of("humour");
    public static final NickTheme GAMERTAG = of("gamertag");
    public static final NickTheme NATURE = of("nature");
    public static final NickTheme NAMES = of("names");
    public static final NickTheme TECH = of("tech");
    public static final NickTheme AESTHETIC = of("aesthetic");
    public static final NickTheme WEATHER = of("weather");
    public static final NickTheme WATER = of("water");
    public static final NickTheme MYTH = of("myth");
    public static final NickTheme MUSIC = of("music");
    public static final NickTheme SPORT = of("sport");
    public static final NickTheme FOOD = of("food");
    public static final NickTheme BOOKS = of("books");
    public static final NickTheme COLOUR = of("colour");
    public static final NickTheme MACHINES = of("machines");
    public static final NickTheme MEDIEVAL = of("medieval");
    public static final NickTheme FOREST = of("forest");
    public static final NickTheme PETS = of("pets");
    public static final NickTheme WILDLIFE = of("wildlife");
    public static final NickTheme WINTER = of("winter");
    public static final NickTheme DESERT = of("desert");
    public static final NickTheme MINERALS = of("minerals");
    public static final NickTheme FARMING = of("farming");
    public static final NickTheme SPOOKY = of("spooky");
    public static final NickTheme ROBOTS = of("robots");
    public static final NickTheme PIRATES = of("pirates");
    public static final NickTheme SPACE = of("space");
    public static final NickTheme ART = of("art");
    public static final NickTheme SCHOOL = of("school");
    public static final NickTheme NIGHT = of("night");
    public static final NickTheme CRAFTING = of("crafting");
    public static final NickTheme TRAVEL = of("travel");
    /** Names that don't sit under any one theme. */
    public static final NickTheme MIXED = of("mixed");

    private final String wireName;

    private NickTheme(String wireName) {
        this.wireName = wireName;
    }

    /**
     * The theme with the given name. Case and surrounding whitespace are
     * ignored. Accepts themes this API has never heard of.
     *
     * @throws IllegalArgumentException if the name is blank
     */
    public static @NotNull NickTheme of(@NotNull String wireName) {
        Objects.requireNonNull(wireName, "wireName");
        String normalized = wireName.trim().toLowerCase(Locale.ROOT);
        if (normalized.isEmpty()) throw new IllegalArgumentException("theme name is blank");
        return new NickTheme(normalized);
    }

    /** The name this theme travels under. */
    public @NotNull String wireName() {
        return wireName;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof NickTheme && wireName.equals(((NickTheme) other).wireName);
    }

    @Override
    public int hashCode() {
        return wireName.hashCode();
    }

    @Override
    public String toString() {
        return wireName;
    }
}
