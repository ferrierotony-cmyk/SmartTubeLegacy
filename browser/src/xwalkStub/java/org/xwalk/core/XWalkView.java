// STUB: Crosswalk 23.53.589.4 artifacts are no longer downloadable (download.01.org is gone).
// No-op replacement so the project compiles. XWalk ("Alt") engine modes do NOT work in this build.
package org.xwalk.core;

import android.content.Context; import android.os.Bundle; import android.util.AttributeSet; import android.webkit.ValueCallback; import android.widget.FrameLayout; import java.util.Map;
public class XWalkView extends FrameLayout {
    public static final int RELOAD_NORMAL = 0, RELOAD_IGNORE_CACHE = 1;
    public XWalkView(Context c) { super(c); }
    public XWalkView(Context c, AttributeSet a) { super(c, a); }
    public void addJavascriptInterface(Object o, String n) {}
    public void evaluateJavascript(String s, ValueCallback<String> cb) {}
    public void setInitialScale(int p) {}
    public void loadUrl(String u) {}
    public void loadUrl(String u, Map<String, String> h) {}
    public void load(String u, String content) {}
    public void load(String u, String content, Map<String, String> h) {}
    public void reload(int mode) {}
    public void onHide() {} public void onShow() {} public void onDestroy() {}
    public void pauseTimers() {} public void resumeTimers() {}
    public void clearCache(boolean d) {}
    public String getUrl() { return null; } public String getOriginalUrl() { return null; }
    public XWalkSettings getSettings() { return new XWalkSettings(); }
    public boolean saveState(Bundle b) { return false; } public boolean restoreState(Bundle b) { return false; }
    public void setUIClient(XWalkUIClient c) {} public void setResourceClient(XWalkResourceClient c) {}
}
