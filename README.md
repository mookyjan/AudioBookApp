# Audio-Book-App

### Structure of the code ###
Simple Android Application written in Kotlin.
This project follows Clean Architecture with MVVM with Clean Architecture Design


# Main libraries used

* Data Binding
* Dagger2
* RxJava2
* Retrofit2
* Timber
* Room
* Junit
* Mockito
* Espresso
* Coil
* Navigation Component
* sdp library (for universal screen resolution)
* shimmer effect lib
* Android Architecture component Jetpack


# Modules


* `data/` : contains the code to access to the data (repository pattern)
* `domain/` : contains the business logic and the usecases
* `app` : Presentation layer, contains the UI 

this project consist of one screen. on the first screen showing the list of Audio Book list and
on clicking the book will go to the Book details page and will shows all the details about the book.
and for the simplicity of this project many things have been kept simple
like 
* ErrorHandling, 
* Internet connectivity and 
* Design of the app is also kept sample and can be improved much more
* Swipe to Refresh can be used to refresh data by force (DONE IN room_db branch)


comments are written with every function that what it will do.

also TODO are given in the area which we can improve more.


##TODO
* improving the design
* Setup for Room Database (DONE IN room_db branch)
* add more unit test cases
* improve the audio player to play the book in background
* Shimmer effect setup




