// STUB: Crosswalk 23.53.589.4 artifacts are no longer downloadable (download.01.org is gone).
// No-op replacement so the project compiles. XWalk ("Alt") engine modes do NOT work in this build.
package org.xwalk.core;

public class XWalkSettings {
    public enum LayoutAlgorithm { NORMAL, SINGLE_COLUMN, NARROW_COLUMNS, TEXT_AUTOSIZING }
    public void setLayoutAlgorithm(LayoutAlgorithm a) {}
    public LayoutAlgorithm getLayoutAlgorithm() { return LayoutAlgorithm.NORMAL; }
    public boolean getAllowContentAccess() { return false; }
    public boolean getAllowFileAccess() { return false; }
    public boolean getAllowFileAccessFromFileURLs() { return false; }
    public boolean getAllowUniversalAccessFromFileURLs() { return false; }
    public boolean getBlockNetworkImage() { return false; }
    public boolean getBlockNetworkLoads() { return false; }
    public boolean getBuiltInZoomControls() { return false; }
    public int getCacheMode() { return 0; }
    public boolean getDatabaseEnabled() { return false; }
    public int getDefaultFixedFontSize() { return 0; }
    public int getDefaultFontSize() { return 0; }
    public boolean getDomStorageEnabled() { return false; }
    public boolean getJavaScriptCanOpenWindowsAutomatically() { return false; }
    public boolean getJavaScriptEnabled() { return false; }
    public boolean getLoadWithOverviewMode() { return false; }
    public boolean getLoadsImagesAutomatically() { return false; }
    public boolean getMediaPlaybackRequiresUserGesture() { return false; }
    public boolean getSaveFormData() { return false; }
    public int getTextZoom() { return 0; }
    public boolean getUseWideViewPort() { return false; }
    public String getUserAgentString() { return null; }
    public void setAllowContentAccess(boolean v) {}
    public void setAllowFileAccess(boolean v) {}
    public void setAllowFileAccessFromFileURLs(boolean v) {}
    public void setAllowUniversalAccessFromFileURLs(boolean v) {}
    public void setBlockNetworkImage(boolean v) {}
    public void setBlockNetworkLoads(boolean v) {}
    public void setBuiltInZoomControls(boolean v) {}
    public void setCacheMode(int v) {}
    public void setDatabaseEnabled(boolean v) {}
    public void setDefaultFixedFontSize(int v) {}
    public void setDefaultFontSize(int v) {}
    public void setDomStorageEnabled(boolean v) {}
    public void setJavaScriptCanOpenWindowsAutomatically(boolean v) {}
    public void setJavaScriptEnabled(boolean v) {}
    public void setLoadWithOverviewMode(boolean v) {}
    public void setLoadsImagesAutomatically(boolean v) {}
    public void setMediaPlaybackRequiresUserGesture(boolean v) {}
    public void setSaveFormData(boolean v) {}
    public void setSupportMultipleWindows(boolean v) {}
    public void setSupportZoom(boolean v) {}
    public void setTextZoom(int v) {}
    public void setUseWideViewPort(boolean v) {}
    public void setUserAgentString(String v) {}
    public boolean supportMultipleWindows() { return false; }
    public boolean supportZoom() { return false; }
}
