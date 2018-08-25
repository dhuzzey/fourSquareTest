# fourSquareTest

I was give a test integrating with foursqaure and I decided to also have a little play with ViewModels and RxJava
## Approach

I decided to restrict the search to a minimum of three characters as the user very rarely wants to search on one letter.
I also added a delay to the handler checking to see if the user was finished typing their search query. If not the runnable is reset and volley queue is cleared. This was to stop high frequency of network calls.


## Main Libraries Used:
Gson
Retrofit
RXJava
Dagger