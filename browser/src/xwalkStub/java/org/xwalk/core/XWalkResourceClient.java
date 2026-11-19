// STUB: Crosswalk 23.53.589.4 artifacts are no longer downloadable (download.01.org is gone).
// No-op replacement so the project compiles. XWalk ("Alt") engine modes do NOT work in this build.
package org.xwalk.core;

import android.net.http.SslError; import android.webkit.ValueCallback; import android.webkit.WebResourceResponse;
public class XWalkResourceClient {
    public XWalkResourceClient(XWalkView v) {}
    public void onReceivedSslError(XWalkView v, ValueCallback<Boolean> cb, SslError e) {}
    public void onReceivedLoadError(XWalkView v, int code, String d, String url) {}
    public void onLoadStarted(XWalkView v, String url) {} public void onLoadFinished(XWalkView v, String url) {}
    public void onProgressChanged(XWalkView v, int p) {}
    public WebResourceResponse shouldInterceptLoadRequest(XWalkView v, String url) { return null; }
    public XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView v, XWalkWebResourceRequest r) { return null; }
    public boolean shouldOverrideUrlLoading(XWalkView v, String url) { return false; }
}
