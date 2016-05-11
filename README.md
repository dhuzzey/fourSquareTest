# fourSquareTest

## Approach

I decided to restrict the search to a minimum of three characters as the user very rarely wants to search on one letter.
I also had a delayed to use a handler checking to see if the user was finished typing their search. If not the runnable is reset and volley queue is cleared. This was to stop high frequency of network calls.


## Main Libraries Used:
Gson
Volley
Dagger