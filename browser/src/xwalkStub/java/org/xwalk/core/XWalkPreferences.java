// STUB: Crosswalk 23.53.589.4 artifacts are no longer downloadable (download.01.org is gone).
// No-op replacement so the project compiles. XWalk ("Alt") engine modes do NOT work in this build.
package org.xwalk.core;

public class XWalkPreferences {
    public static final String REMOTE_DEBUGGING = "remote-debugging", ANIMATABLE_XWALK_VIEW = "animatable-xwalk-view";
    public static void setValue(String k, boolean v) {} public static void setValue(String k, int v) {} public static void setValue(String k, String v) {}
}
