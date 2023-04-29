# **Cute CBS (Cat, Bird, Shibes)**

## Table of Contents

1. [App Overview](#App-Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
1. [Build Notes](#Build-Notes)

## App Overview

### Description 

**A scrollable list of random dog, cat, bird photos. The user can choose up to 3 of those image categories, and new images can be displayed if the app is refreshed.**

### App Evaluation

**Mobile:**  
-This is more than a website because  cute images would be displayed without clutter of ads  and such a feature would be free.  

**Story:**
-I think people would respond well to an app that displays only images of cute animals.  However, it may not be clear that one could use it for more than inspiration.

**Market:**
-If this app were to go live, there might not be a lot of users due to competition. We would need a fair amount of advertisement.
-I think this app would be popular like how Pinterest is but more niche. 
-I think artists would use this app for inspiration and a regular user would use this app for good vibes and happiness.

**Habit:** 
-The user would open the app and use it often because of the random images each time the app is refreshed. The user will always see something new when the app is refreshed, and that is addicting.
-The user could use the app to create something, it's more of an app for inspiration. You can not create something on this app.

**Scope:**
-I am already familiar with how the API works. However, as a group, we could have some difficulty getting this completed because coordinating meetings is difficult due to differences in timezones and school schedules. We would need to work on a scaled-down version of this app with not too many complicated features.
-Even though this might not be the most polished app, I think it would still be interesting to build.
-This product's purpose is to display random images of dogs, cats, or birds in a vertical list that is scrollable.  Other features would only help to enhance the app.

## Product Spec

### 1. User Features (Required and Optional)

Required Features
-
- Able to display any variety of Cats, Birds, Shibes
- Able to refresh the images to get new ones (swipe up?)
- User can choose which animals they want to see after opening the app (tick boxes)


Optional Features:
-
- Able to rank animals with local and global rankings
- Able to see owner of animal and posible more photos on user's page


Chosen API
-
- https://shibe.online/  : https://shibe.online/api/birds , https://shibe.online/api/cats , https://shibe.online/api/shibes

* Using API to get the 3 animal images
* Can display file name


User Interaction
-
- Able to display any variety of Cats, Birds, Shibes
>* After the user chooses up to 3 animals to view, the app will make a call to the API
>Then random images will be displayed in a list.
- Able to refresh the images to get new ones (swipe up?)
>* After reaching the bottom of the page of generated pictures, have an onSwipeLisenser so that once a swipe is detected the fetching from the API restarts
- User can choose which animals they want to see after opening the app (tick boxes)
>* User will click on unshaded buttons, that will turn shaded, to choose up to 3 animals to view on the app.


Wireframing 
-


![Screen Shot 2023-04-19 at 9 33 32 AM](https://user-images.githubusercontent.com/32886451/233708346-d1102ea5-161f-4ed3-92b3-b6182c99d7c4.png)

## Build Notes

Here's a place for any other notes on the app, it's creation 
process, or what you learned this unit!  

We have come a long way, and the process of building an app with a team from idea to end product was challenging but very informative.

For Milestone 2, include **2+ GIFs** of the build process here!

![MilestoneFinal](https://user-images.githubusercontent.com/92275246/235288132-22462008-1978-48ff-884a-a7781fc68a5d.gif)


![gif process 1 with float button](https://user-images.githubusercontent.com/120623425/235278022-6dc298b7-c5f8-47bb-b541-86985600f432.gif)
 
## License

Copyright **2023** **Sofia Nguyen, Donna Prince, Eliott Schaffer**

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.





