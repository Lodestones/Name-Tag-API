package gg.lode.nametagapi;

/**
 * Official API of the Name Tag Plugin
 * This interface allows access to certain internals of the world border plugin.
 *
 * @author John Aquino
 */
public class NameTagAPI {

    private static INameTagAPI api;

    /**
     * Internal use of the API for Name Tag to use.
     * DO NOT TOUCH!!
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
