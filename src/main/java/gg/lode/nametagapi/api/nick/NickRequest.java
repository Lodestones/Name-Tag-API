package gg.lode.nametagapi.api.nick;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/**
 * What kind of random nickname to ask for.
 * <p>
 * Every part is optional; an empty request is the same as asking for any name
 * at all. Filters narrow the shared pool rather than binding it — if too few
 * names match, the pool widens and answers with the closest it has instead of
 * failing. So a request is a preference, never a guarantee, and the name you
 * get back may carry a form you excluded when nothing else was left.
 *
 * <pre>{@code
 * NickRequest request = NickRequest.builder()
 *         .theme(NickTheme.SPACE)
 *         .excludeForms(NickForm.LEETSPEAK, NickForm.NUMBERED)
 *         .build();
 * NameTagAPI.get().randomNick(player, request);
 * }</pre>
 *
 * @see NickTheme
 * @see NickForm
 */
public final class NickRequest {

    private static final NickRequest ANY = new NickRequest(null, Collections.emptySet());

    private final @Nullable NickTheme theme;
    private final Set<NickForm> excludedForms;

    private NickRequest(@Nullable NickTheme theme, Set<NickForm> excludedForms) {
        this.theme = theme;
        this.excludedForms = excludedForms;
    }

    /** A request with no filters — any name from the pool. */
    public static @NotNull NickRequest any() {
        return ANY;
    }

    public static @NotNull Builder builder() {
        return new Builder();
    }

    /** The theme asked for, or {@code null} when any theme will do. */
    public @Nullable NickTheme theme() {
        return theme;
    }

    /** Forms the caller would rather not receive. Never null; possibly empty. */
    public @NotNull Set<NickForm> excludedForms() {
        return excludedForms;
    }

    /** Whether this request narrows anything at all. */
    public boolean isAny() {
        return theme == null && excludedForms.isEmpty();
    }

    public static final class Builder {

        private @Nullable NickTheme theme;
        private final Set<NickForm> excludedForms = EnumSet.noneOf(NickForm.class);

        private Builder() {
        }

        /** Ask for names on one theme. Passing {@code null} clears it. */
        public @NotNull Builder theme(@Nullable NickTheme theme) {
            this.theme = theme;
            return this;
        }

        /** Rule out names carrying any of these forms. Additive across calls. */
        public @NotNull Builder excludeForms(@NotNull NickForm... forms) {
            for (NickForm form : forms) {
                if (form != null) excludedForms.add(form);
            }
            return this;
        }

        /** Rule out names carrying any of these forms. Additive across calls. */
        public @NotNull Builder excludeForms(@NotNull Collection<NickForm> forms) {
            for (NickForm form : forms) {
                if (form != null) excludedForms.add(form);
            }
            return this;
        }

        public @NotNull NickRequest build() {
            if (theme == null && excludedForms.isEmpty()) return ANY;
            return new NickRequest(theme, Collections.unmodifiableSet(EnumSet.copyOf(excludedForms)));
        }
    }
}
