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

```bash
git clone --recurse-submodules https://github.com/yuliskov/SmartTubeLegacy.git && cd SmartTubeLegacy
git apply patches/SmartTubeLegacy.patch
git -C SharedModules apply ../patches/SharedModules.patch
git -C MediaServiceCore apply ../patches/MediaServiceCore.patch
git -C MediaServiceCore/SharedModules apply ../../patches/MediaServiceCore-SharedModules.patch
# copy ./localrepo from this tree, or rebuild it from exoplayer-amazon-port amazon/r2.10.6 + patches/exo-amazon-r2.10.6.patch
echo "sdk.dir=$ANDROID_HOME" > local.properties
JAVA_HOME=/path/to/jdk8 bash ./gradlew :smartyoutubetv:assembleOrigDebug
```

Install: `adb install SYTV_Orig_v6.17.739_d.apk`
