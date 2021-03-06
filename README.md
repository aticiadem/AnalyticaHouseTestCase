# AnalyticaHouse

This repository made for AnalyticaHouse Test Case Application with using Jetpack Compose. Datas is coming from [here][1].

Libraries Used
--------------
* [Architecture][10] - A collection of libraries that help you design robust, testable, and maintainable apps.
  * [Lifecycles][11] - Create a UI that automatically responds to lifecycle events.
  * [Navigation][12] - Handle everything needed for in-app navigation.
  * [ViewModel][13] - Easily schedule asynchronous tasks for optimal execution.
  * [LiveData][14] - Build data objects that notify views when the underlying database changes.
  * [Room][15] - Access your app's SQLite database with in-app objects and compile-time checks.
* [UI][20] - Details on why and how to use UI Components in your apps - together or separate
  * [Jetpack Compose][21] - A basic unit of composable UI.
* Third party and miscellaneous libraries
  * [Retrofit][30] for turns your HTTP API into a Java interface
  * [Gson][31] for convert Java Objects into their JSON representation
  * [Hilt][32] for [dependency injection][33]

Architecture
--------------
The app uses [MVVM architecture][10] to have a unidirectional flow of data, separation of concern, testability, and a lot more.

![Architecture](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)

App GIF
--------------
<p align="center">
  <img src="https://user-images.githubusercontent.com/58858983/139599848-d8722c62-e929-4d29-902e-c4325d8c5d08.gif" alt="GIF" />
</p>


LICENSE
--------------
MIT License

Copyright (c) 2021 Adem ATİCİ

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

[1]: https://www.balldontlie.io/#introduction
[10]: https://developer.android.com/jetpack/compose/architecture
[11]: https://developer.android.com/jetpack/compose/lifecycle
[12]: https://developer.android.com/jetpack/compose/navigation
[13]: https://developer.android.com/jetpack/compose/state#viewmodel-state
[14]: https://developer.android.com/reference/kotlin/androidx/compose/runtime/livedata/package-summary
[15]: https://developer.android.com/training/data-storage/room
[20]: https://developer.android.com/jetpack/compose/tutorial
[21]: https://developer.android.com/jetpack/compose
[30]: https://square.github.io/retrofit/
[31]: https://github.com/google/gson
[32]: https://developer.android.com/training/dependency-injection/hilt-android
[33]: https://developer.android.com/training/dependency-injection
