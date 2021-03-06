<p align="center">
  <img src="https://github.com/gzeinnumer/MyLibUtils/blob/master/preview/bg.jpg"/>
</p>

<h1 align="center">
    EasySpannableText
</h1>

<p align="center">
    <a><img src="https://img.shields.io/badge/Version-1.0.0-brightgreen.svg?style=flat"></a>
    <a><img src="https://img.shields.io/badge/ID-gzeinnumer-blue.svg?style=flat"></a>
    <a><img src="https://img.shields.io/badge/Java-Suport-green?logo=java&style=flat"></a>
    <a><img src="https://img.shields.io/badge/kotlin-Suport-green?logo=kotlin&style=flat"></a>
    <a href="https://github.com/gzeinnumer"><img src="https://img.shields.io/github/followers/gzeinnumer?label=follow&style=social"></a>
    <br>
    <p>Simple SpannableString Builder.</p>
</p>

---
# Content List
* [Download](#download)
* [Feature List](#feature-list)
* [Tech stack and 3rd library](#tech-stack-and-3rd-library)
* [Usage](#usage)
* [Version](#version)
* [Contribution](#contribution)

---
# Download
Add maven `jitpack.io` and `dependencies` in `build.gradle (Project)` :
```gradle
// build.gradle project
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}

// build.gradle app/module
dependencies {
  ...
  implementation 'com.github.gzeinnumer:EasySpannableText:version'
}
```

---
# Feature List
- [x] [Customize Text Style in TextView]()
- [x] [Text Style With CallBack]()

---
# Tech stack and 3rd library
- []()

---
# Usage

### **Customize Text Style in TextView**
```java
int size = 2;
int color = ContextCompat.getColor(this, R.color.purple_500);

CharSequence sequence = new SpannableBuilder()
       .text(Typeface.NORMAL,"text\n")
       .textColor(Typeface.BOLD,"textColor\n", color)
       .textSize(Typeface.ITALIC,"textSize\n", size)
       .textSizeColor(Typeface.BOLD_ITALIC,"textSizeColor\n", size, color)
       .build();
textView.setText(sequence); //or textView.setText(sequence, TextView.BufferType.SPANNABLE);
```
`Typeface` optional value
- `Typeface.NORMAL`
- `Typeface.BOLD`
- `Typeface.ITALIC`
- `Typeface.BOLD_ITALIC`

<p align="center">
  <img src="https://github.com/gzeinnumer/MyLibUtils/blob/master/preview/bg.jpg" width="300"/>
</p>

#
### **Text Style With CallBack**

add 1 parameter in function `.text()`,`.textColor()`,`.textSize()`,`.textSizeColor()`. and add `setMovementMethod()` after `setText()` like this.
```java
int size = 2;
int color = ContextCompat.getColor(this, R.color.purple_500);

CharSequence sequence = new SpannableBuilder()
        .text(Typeface.NORMAL, "text\n", new SpannableCallBack() {
            @Override
            public void onClick() {
                Toast toast = Toast.makeText(MainActivity.this, "Tekan 1", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();
            }
        })
        .textColor(Typeface.BOLD, "textColor\n", color, new SpannableCallBack() { ... })
        .textSize(Typeface.ITALIC, "textSize\n", size, new SpannableCallBack() { ... })
        .textSizeColor(Typeface.BOLD_ITALIC, "textSizeColor\n", size, color, new SpannableCallBack() { ... })
        .build();
textView.setText(sequence); //or textView.setText(sequence, TextView.BufferType.SPANNABLE);
textView.setMovementMethod(LinkMovementMethod.getInstance());
```
`Typeface` optional value
- `Typeface.NORMAL`
- `Typeface.BOLD`
- `Typeface.ITALIC`
- `Typeface.BOLD_ITALIC`

---
# Example Code/App

[]()

---
# Version
- **1.0.0**
  - First Release

---
# Contribution
You can sent your constibution to `branch` `open-pull`.

### Fore More [All My Library](https://github.com/gzeinnumer#my-library-list)

---

```
Copyright 2021 M. Fadli Zein
```
