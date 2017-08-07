# SecurityUtils
Some android security utils like a root checker, adblock checker, app blocker...

## Usage:

### Adding the depencency

Add this to your root *build.gradle* file:

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Now add the dependency to your app build.gradle file:

```
compile 'com.github.marcoscgdev:SecurityUtils:1.0.1'
```

### Using the functions

 - Root detector
 
 It returns a boolean value.
 
 ```java
 boolean isDeviceRooted = RootDetector.isRootPresent();
 ```
 
 ---
 
 - AdBlock detector
 
 It returns a boolean value.
 
 ```java
 boolean isAdBlockEnabled = AntiAdBlocker.isAdBlockerPresent(boolean hasAds);
 ```
 
 The "hasAds" boolean is useful if you have two app versions: One with ads and another one without ads.
 
 The AntiAdBlocker will only check if the device has an AdBlocker active if the "hasAds" boolean is set to true.
 
 ---
 
  - App blocker
  
  Coming soon...

---
>See the *sample project* to clarify any queries you may have.

---

## License

```
Copyright 2017 Marcos Calvo García

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
