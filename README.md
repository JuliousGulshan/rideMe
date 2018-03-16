# rideMe
Report:

Android Studio Problems with Solution:

It was easy to install the android studio on mac but I was not familiar with the tool facilities in it. I have to download so many different packages in it to finish my build gradle properly. It was very hard for me to attach buttons in activity and creating new activity and connecting them with on click method. I saw udemy tutorials, google search to get my hands on android studio. All designing I learned from YouTube to make my application look more fancy and easy to use. Udemy tutorial was backbone for my project as it helps a lot to get the content so I can implement on my individual assignment. Emulator was very slow on my machine so I move to android phone. Whenever I do designing in .xml file in TEXT option I cannot able to see preview what I am writing. Then, I find out that on the right side of the screen we have preview option to see the current changes in designing while editing in .xml file of my layout.

Android Phone Connecting to Android Studio:

My Android phone was connecting to my machine but it was not showing up as connected device when I run my project. Then after searching about this issue, I figured out that I haven’t change my phone into developer mode by clicking 7 times on build number of my device. 

Coding Problems and Solutions:

List View problems:
 
I will highlight only my major problem that I faced in my project. In the start of my project, I created activity and try to fetch data from JSON file. But, I wasn’t able to fetch data because I didn’t write read each line of JSON string (code below).

while ((JSON_STRING = bufferedReader.readLine())! =null) {      stringBuilder.append(JSON_STRING+ "\n"); }

Now, data was getting fetched and I have to do parsing of data into a list view. I saw many tutorials about parsing and it is not working on my project. I was not attaching Adapter java file and contacts java file to Display list view. 

Map Activity problems:

In this activity, I have to create marker but it showing me error for using for-loop. Because, I was not creating separate 3 arrays for latitude, longitude and title as name of station. Before I create 3 arrays I have to split the position into objects and get the item in it as latitude and longitude so I can save these values in my arrays. I sliced positon into two items and try to contact for-loop array. Size to it and my loop was working. Then I assigned the values as latitude, longitude and name as title. I assigned camera zoom on Dublin manually to get view of all station in map.

Weather Activity:

Lastly, I want to add current Dublin weather for user of my application when clicked on marker title. I connected both activity by using onClickListener. The problem was to show weather icon in it, I learned from google search that how to add different cases for weather icon to display with the weather condition. And, it works absolutely fine according to weather condition.

GitHub Problem and Solution:

This is my first time that we have to upload our project to GitHub. As I am new user to GitHub somehow, I managed to push my project to GitHub using vcs in Android Studio. I am still beginner for GitHub and by watching tutorial for it I managed to commit changes and push in again as version 2.
 
Conclusion: 

In a nutshell, after completing my Dublin Bike project I am so confident about myself that I have ability to work on other project in future. My mentors and online tutorials plays a major role in completing my project. 
