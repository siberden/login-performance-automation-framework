package utils;

public class PerformanceContext {

    private static final ThreadLocal<Long> apiStart = new ThreadLocal<>();
    private static final ThreadLocal<Long> apiDuration = new ThreadLocal<>();

    private static final ThreadLocal<Long> uiStart = new ThreadLocal<>();
    private static final ThreadLocal<Long> uiDuration = new ThreadLocal<>();

    public static void startApiTimer() {
        apiStart.set(System.currentTimeMillis());
    }

    public static void endApiTimer() {
        apiDuration.set(System.currentTimeMillis() - apiStart.get());
    }

    public static Long getApiDuration() {
        return apiDuration.get();
    }

    public static void startUiTimer() {
        uiStart.set(System.currentTimeMillis());
    }

    public static void endUiTimer() {
        uiDuration.set(System.currentTimeMillis() - uiStart.get());
    }

    public static Long getUiDuration() {
        return uiDuration.get();
    }

    public static void clear() {
        apiStart.remove();
        apiDuration.remove();
        uiStart.remove();
        uiDuration.remove();
    }
}
