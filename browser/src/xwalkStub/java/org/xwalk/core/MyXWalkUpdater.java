// STUB: Crosswalk 23.53.589.4 artifacts are no longer downloadable (download.01.org is gone).
// No-op replacement so the project compiles. XWalk ("Alt") engine modes do NOT work in this build.
package org.xwalk.core;

import android.content.Context;
public class MyXWalkUpdater {
    public interface XWalkUpdateListener { void onXWalkUpdateCancelled(); }
    private final XWalkUpdateListener l;
    public MyXWalkUpdater(XWalkUpdateListener l, Context c) { this.l = l; }
    public void setXWalkApkUrl(String u) {}
    public boolean updateXWalkRuntime() { l.onXWalkUpdateCancelled(); return false; }
}
