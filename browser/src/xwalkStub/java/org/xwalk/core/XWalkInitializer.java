// STUB: Crosswalk 23.53.589.4 artifacts are no longer downloadable (download.01.org is gone).
// No-op replacement so the project compiles. XWalk ("Alt") engine modes do NOT work in this build.
package org.xwalk.core;

import android.content.Context;
public class XWalkInitializer {
    public interface XWalkInitListener { void onXWalkInitStarted(); void onXWalkInitCancelled(); void onXWalkInitFailed(); void onXWalkInitCompleted(); }
    private final XWalkInitListener l;
    public XWalkInitializer(XWalkInitListener l, Context c) { this.l = l; }
    public boolean initAsync() { l.onXWalkInitFailed(); return false; }
    public boolean isXWalkReady() { return false; }
}
