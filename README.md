Kotlin for Android
=============

Helps not to write boilerplate code with instantiating abstract or interfaces instances.
The purpose of the library is to save time of writing code using Android SDK wrapping as much as possible
common functionality.

Linking to Android project
--------------------------

1. Create regular or use existing Android project in IDEA
2. Select `File` from menu and click on `Project Structure...`
3. Select `Libraries` section and add new Java library
4. Choose the source `src` folder of kotlinAndroidLib and click `Ok`
5. Choose category `sources` and click `Ok`
6. Select and name the library `kotlinAndroidLib`
7. Add new file to the library `^N` and choose classes.jar of kotlinAndroidLib
8. Add import to your kotlin files in the android project `import android.kotlin.*`

Usage
-----

* `findViewById` replacement:

    val `name of View` = findView<`type of View`>(`resource Id`)

    val myButton = findView<Button>(R.id.my_button)

* setOnClickListener for Views:

    myButton?.setOnClickListener { /* code here */ }

or

    myButton?.setOnClickListener { view -> /* code here with view argument */ }

