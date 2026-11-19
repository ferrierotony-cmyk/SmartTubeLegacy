// STUB: Crosswalk 23.53.589.4 artifacts are no longer downloadable (download.01.org is gone).
// No-op replacement so the project compiles. XWalk ("Alt") engine modes do NOT work in this build.
package org.xwalk.core;

public class XWalkCookieManager {
    public void setCookie(String url, String v) {} public String getCookie(String url) { return null; }
    public void setAcceptCookie(boolean a) {} public void removeAllCookie() {} public void flushCookieStore() {}
}
