// STUB: Crosswalk 23.53.589.4 artifacts are no longer downloadable (download.01.org is gone).
// No-op replacement so the project compiles. XWalk ("Alt") engine modes do NOT work in this build.
package org.xwalk.core;

public class XWalkUIClient {
    public enum ConsoleMessageType { DEBUG, ERROR, LOG, INFO, WARNING, TIP }
    public XWalkUIClient(XWalkView v) {}
    public boolean onConsoleMessage(XWalkView v, String m, int line, String src, ConsoleMessageType t) { return false; }
}
