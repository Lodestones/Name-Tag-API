package gg.lode.nametagapi;

/**
 * Copyright 2025 - Lodestone Services LLC
 * <p>
 * This interface allows access to certain internals of the NickAPI plugin.
 *
 * @author John Aquino
 */
public class NameTagAPI {

    private static INameTagAPI api;

    /**
     * Internal use of the API for Name Tag to use.
     * @param api {@link INameTagAPI}
     */
    public static void setApi(INameTagAPI api) {
        NameTagAPI.api = api;
    }

    /**
     * Retrieves the API that Name Tag uses.
     */
    public static INameTagAPI getApi() {
        return api;
    }

}
