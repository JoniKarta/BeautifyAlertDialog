# Beautify-Alert-Dialog

![JitPack](https://img.shields.io/jitpack/v/github/JoniKarta/BeautifyAlertDialog)
![GitHub last commit](https://img.shields.io/github/last-commit/JoniKarta/BeautifyAlertDialog?color=%23af6b58)
![GitHub repo size](https://img.shields.io/github/repo-size/JoniKarta/BeautifyAlertDialog?color=%23595b83)
![GitHub forks](https://img.shields.io/github/forks/JoniKarta/BeautifyAlertDialog?style=social)

Library for creating custom alert dialog which offers an adaptive UI support. 
It’s functionality is almost similar to the native AlertDialog.
Flexible and easy control over multiple part of the layout such as icon, buttons, messages and color such that you could  
customize the ui with multiple pre-built features.
The library also include animation for icons.


## Setup
Step 1. Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency:
```gradle
dependencies {
      implementation 'com.github.JoniKarta:BeautifyAlertDialog:1.0.4'
}
```
## Usage
![](Images/BeautifyDialog.gif)

###### Basic Alert Dialog:
```java

 new BeautifyAlertDialog
      .Builder(this)
      .setHeader("Are you root?")
      .setMessageContent("This action required root privileged are you sure you want to proceed")
      .setLeftButtonText("Yes")
      .setRightButtonText("No")
      .setImageAnimation(Animator.FLIP_FLOP)
      .setIcon("https://cdn.pixabay.com/photo/2014/10/26/14/36/light-bulb-503881_960_720.jpg")
      .setOnConfirmListener(BeautifyCompleteDialog.Builder::dismiss)
      .setOnCancelListener(BeautifyCompleteDialog.Builder::dismiss)
      .show();
```

###### Basic Success Dialog:
```java

BeautifyCompleteDialog.Builder dialog = new BeautifyCompleteDialog.Builder(this);
dialog.setHeader("Saved successfully")
     .setMessageContent("All you data saved successfully")
     .setImageAnimation(Animator.ROTATE)
     .setIcon(R.drawable.success)
     .setOnSuccessClickListener(builder -> dialog.dismiss())
     .show();                 
```

###### Basic Custom Dialog With Inners Dialogs
```java                    

new BeautifyAlertDialog
    .Builder(this)
    .setHeader("Ticket Purchase")
    .setMessageContent("Would you like to buy the ticket?")
    .setLeftButtonText("Yes")
    .setRightButtonText("No")
    .setImageAnimation(Animator.FADE_IN)
    .setIcon(R.drawable.tickets)
    .setOnConfirmListener(beautifyCompleteDialog ->
           beautifyCompleteDialog
               .setIcon(R.drawable.success)
               .setMessageContent("Thanks see you there!")
               .setOnSuccessClickListener(builder -> beautifyCompleteDialog.dismiss())
               .show())
    .setOnCancelListener(beautifyCompleteDialog -> beautifyCompleteDialog
               .setIcon(R.drawable.sad)
               .setHeader("Tickets are out")
               .setMessageContent("Hope to see you next time!")
               .setOnSuccessClickListener(builder -> beautifyCompleteDialog.dismiss())
               .show())
    .show();
```

###### Basic Progress Bar:
```java

 BeautifyProgressBarDialog.Builder beautifyProgressBarDialog = new BeautifyProgressBarDialog.Builder(this);
 beautifyProgressBarDialog
    .setHeader("Loading...")
    .setMessageContent("All your imaginary data is downloading please wait until we finish")
    .setOnClickListener(new ProgressBarEventListener() {
          @Override
          public void onCancel() {
               beautifyProgressBarDialog.dismiss();
          }

          @Override
          public void onComplete(BeautifyCompleteDialog.Builder beautifyCompleteDialog) {
                 new Thread(() -> {
                      try {
                         Thread.sleep(2000); // Long running task
                         beautifyProgressBarDialog.dismiss();
                      } catch (InterruptedException e) {
                         e.printStackTrace();
                      }}).start();
                 }
    }).show();
```


## License

    Copyright 2020 Jonathan Karta

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

## Next Updates:
- [X] Progress Bar
- [X] New Animations 
