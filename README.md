# DongDong2
# 10th week
## Team composition 
* 201935008 권민우
* 201935113 이한슬
* 201935114 이현석
* 201935125 정규원

## Progress
* Set the role for each member
* Development planning
* Data Survey for Development


# 11th week
## Progress
* Create an admin app to get the RSSI and distance values for each classroom
* Make the values received from the admin app integrate in firebase

## Completed task
* Admin app testing
After selecting the floor and room using the spinner, press the start button to find the Rssi value of the GC_free_WiFi and display the distance.

![wiki1](https://github.com/GC-IOT-TermProject-11/AdminTool/assets/101577272/65ed912a-0560-4755-8843-68f56fd4b4a1)
* Integrate Firebase
Integrate with Firebase to test if the values in your app are being updated correctly.

![firebase](https://github.com/GC-IOT-TermProject-11/AdminTool/assets/101577272/5a1acfc2-81b8-416c-a83e-9f1896d48489)


# 12th week
## Progress
* Fingerprinting on the 4th and 5th floors of the AI building
* Convert json file to csv file

## Completed task
* Fingerprinting on the 4th and 5th floors of the AI building
Fingerprinting was performed 30 times on the fourth floor from 401 to 435 and on the fifth floor from 501 to 532.

* Each data is stored in the Firebase realtime DB.

![db](https://github.com/GC-IOT-TermProject-11/AdminTool/assets/101577272/8b545613-c6ac-4a1a-b066-827dd481bfe6)


* Convert json file(firebase) to csv file using Python

![json](https://github.com/GC-IOT-TermProject-11/AdminTool/assets/101577272/6123f25c-cd91-4298-baf1-04e6f3e09084)
![csv](https://github.com/GC-IOT-TermProject-11/AdminTool/assets/101577272/cc0eac74-11ca-4ac8-bb42-3bd4bb549f0f)


# 13th week
## Progress
* Complete current location prediction model

* Model evaluation

## Compeleted task
* We trained a random forest model using a dataset that contains the BSSID (Basic Service Set Identifier) values and RSSI (Received Signal Strength Indicator) values of all gc_free_wifi networks measured 30 times in each classroom from the current location.

Our Model accuracy is 96%
![accur](https://github.com/GC-IOT-TermProject-11/AdminTool/assets/101577272/eccf60e7-5ead-4077-b885-46bcc9ec231c)

When the values measured in room 413 were used as a test set and inputted into the model, the predicted values were returned accurately and correctly.
![test](https://github.com/GC-IOT-TermProject-11/AdminTool/assets/101577272/28924a51-56c8-4628-9b16-755cdf7c75b4)
![res](https://github.com/GC-IOT-TermProject-11/AdminTool/assets/101577272/264c91b6-6f32-4eca-93a6-569c0bde2dbb)



> 
