# 🛰 Mission Control – Apollo1053 has landed!

## 💡 Introduction
Welcome to the International Space Research Institute! As a software engineer at the institute, you will contribute to developing a software solution for managing future space missions.
Our institute owns several types of Spacecraft. The missions you have been assigned to consist of manipulating the current fleet of Lander-type ships. Within these missions, each lander will extract recorded temperatures from the planet it is on.
Your goal is to create a solution that helps manage the entire fleet of landers, as well as storing and manipulating the collected data in real time.

## 💼 Work Environment Description
Good news: there is already a Java project created for implementing this solution, but this project needs adjustments. All that colleagues have managed to do so far was to define the 2 classes Spacecraft and Lander and extract the necessary attributes for each class. Thus, Spacecraft has the name and weight (expressed in kilograms) of a ship as attributes, while Lander contains the name of the site where the lander is scheduled to land, as well as a counter that will monitor if the lander has landed and, at the same time, a vector with the temperatures recorded during the mission.
Our colleagues from the system department have prepared a landers.csv file with data about the institute's current fleet of landers.

## 👨‍💻 Software Requirements
To complete this software application, the following requirements need to be implemented:

* To begin with, we want to ensure that our solution has a solid foundation in terms of OOP concepts. Considering that Lander is a type of Spacecraft, implement the necessary methods to ensure that our project meets the principles of encapsulation and inheritance. Don't forget to test these methods in main!

* Using the landers.csv file, read the data and create Lander objects
  * Hint: we consider that the landers have not landed yet

* Implement an abstract method in the Spacecraft class called land() which will serve to change the value of the hasLanded field of the Lander class

* After a discussion with other departments, it is necessary to add a way to calculate the average temperature recorded by a lander up to the current moment. We need a solution that will make software engineers implement this functionality for other types of institute vessels as well (a kind of "contract"). So, to do this, use a different method of abstraction than the one used in the previous point 😉

* For landers that have landed, write data related to their mission status in a .txt file, following the structure below:
  ```
  Name LandingSite AverageTemperature
  ```
  Keep in mind that each piece of information belonging to a lander must be written on the same line.
  * Optional: try to add the vector of temperatures recorded so far by each lander, according to the structure:
    ```
    Name LandingSite AverageTemperature TemperatureReadings
    ```

* Implement serialization and deserialization methods for Lander objects. It is sufficient to serialize/deserialize a single object.

* Using JCF concepts, create a data structure that stores Lander objects in ascending order according to weight. Write the elements of this collection to a binary file.

* Using the binary file created in the previous point, display the second lightest Lander

* Before submitting the project, there is still one functionality to implement. It has been established that we need a way to manage how many active missions we have on each celestial body. To help us, the system team has provided the landers.csv file where we are given site allocations on each celestial body. Once these allocations are read and data analysis is completed, implement a way for this summary to be exported to a file that will be used in the next press release regarding mission status.
  * Hint: to facilitate implementation, you can use one of the collections from JCF and the formula below:
    ```
    code = code + 31 * letter + avgTemp
    ```

Good luck! 🚀
