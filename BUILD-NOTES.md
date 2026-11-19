# Building SmartTubeLegacy in 2026

Output: `SYTV_Orig_v6.17.739_d.apk` (variant `origDebug`, debug-signed, minSdk 17, targetSdk 26).

The project doesn't build as published. JCenter, Bintray and Intel's Crosswalk server (download.01.org) are
gone, and the git submodule pins have drifted away from the parent code. These are the changes that got it building:

| Problem | Fix |
|---|---|
| `com.amazon.android:exoplayer:2.10.6` + `extension-okhttp` (JCenter only, gone) | Built from source: `github.com/amzn/exoplayer-amazon-port`, branch `amazon/r2.10.6`. AARs + hand-written POMs live in `./localrepo`, which is registered first in `build.gradle`. Bumping to 2.13.3 (on Maven Central) does **not** work: 89 compile errors from API changes. |
| `org.xwalk:xwalk_*_library:23.53.589.4` (Crosswalk, gone everywhere) | No-op stubs in `browser/src/xwalkStub/java/org/xwalk/core/`. The 3 forked Crosswalk internals (`MyXWalk*.java`) are renamed to `*.java.disabled`. |
| `com.algolia.instantsearch:voice:1.0.0-beta02` (gone) | `1.1.0` from Maven Central. |
| `com.itkacher.okhttpprofiler:okhttpprofiler:1.0.5` (gone) | Same lib/version via JitPack: `com.github.itkacher:OkHttpProfiler:1.0.5`. |
| `sharedutils.locale.LangHelper` missing at the pinned SharedModules commit (renamed upstream) | Switched to `LocaleUpdaterHelper` (same API) and made it `public`. |
| ExoPlayer repo needs dead `com.novoda:bintray-release` plugin | Removed; publishing was disabled anyway. |

All source changes are in `patches/` (one per repo/submodule, including the ExoPlayer clone).

## What does NOT work in this build

* **"1080 Alt" / "4K Alt" (XWalk engine) modes.** The stubs make init fail, and the activity closes. Use the **Main** (WebView) modes.
* No release build. Release signing keys aren't in the repo, so this is debug-signed. Installing it over an official build will fail on signature mismatch; uninstall first.
* Whether it actually plays video in 2026 is untested. The app wraps YouTube's TV web UI, which has changed many times since 2021.

## Reproduce

Requirements: JDK 8, Android SDK (`platforms;android-28`, `build-tools;28.0.3`), network access to
`dl.google.com`, `maven.google.com`, `jitpack.io`, Maven Central and `services.gradle.org`.

From this fork (the main-repo fixes are already merged, so only the submodule patches are needed):

```bash
git clone --recurse-submodules https://github.com/ferrierotony-cmyk/SmartTubeLegacy.git && cd SmartTubeLegacy
git -C SharedModules apply ../patches/SharedModules.patch
git -C MediaServiceCore apply ../patches/MediaServiceCore.patch
git -C MediaServiceCore/SharedModules apply ../../patches/MediaServiceCore-SharedModules.patch
echo "sdk.dir=$ANDROID_HOME" > local.properties
JAVA_HOME=/path/to/jdk8 bash ./gradlew :smartyoutubetv:assembleOrigDebug
```

From yuliskov's original repo instead, also run `git apply patches/SmartTubeLegacy.patch` (after copying `patches/`
and `localrepo/` over from this fork) before the submodule patches.

Install: `adb install SYTV_Orig_v6.17.739_d.apk`

## Test results (2026-11-19)

| Test | Result |
|---|---|
| Fresh clone of this fork + the steps above | **Pass.** APK builds. |
| Unit tests (`testOrigDebugUnitTest`, `sharedutils`, `common`, `youtubeapi`) | **Fail, all suites.** Every test dies inside Robolectric 4.3.1's own setup (`Configuration.getLocales not mocked`) before any test code runs, including in modules these fixes barely touch. That's the old test harness, not the app. Many tests also hit live 2021-era YouTube APIs. |
| Install + launch on an Android 7.1 x86 emulator | **Pass.** Installs, launches into "1080 Main" (WebView) mode, shows the first-run consent dialog, accepts D-pad (TV remote) input, no crashes. |
| Actual YouTube playback | **Not tested.** The test emulator had no internet access. Unverified on real hardware. |

Side note from testing: with no network, the app reloads the page roughly 4 times a second, forever
(`ControllerEventListener: onReceiveError called: reloading tab...`). That's original behavior, not something these fixes introduced.

