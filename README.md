Create a web application for managing your own travel telegram bot.
1) The Telegram bot gives the user reference information about the entered city. For example, the user enters: "Moscow", the chatbot responds: "Don't forget to visit Red Square. Well, you can not go to the TSUM)))".
2) City data should be stored in a database.
3) Manage city data (add new cities and information about them, change and delete any information) via REST webservices.

Technologies used :

* Spring Boot 2.3.4
* Spring MVC
* Spring Data
* Hibernate
* H2
* JUnit 4
* Maven
* IntelliJ IDEA

To launch the application, download it and type in the command line: java-jar TelegramBotResliv-1.0-SNAPSHOT.jar

After the launch, you can start communicating with the bot. You can find it by the name TestCityInfoBot.

The following cities will be immediately available: Minsk, Moscow, Kiev, Washington.

Bot name: TestCityInfoBot

Bot token: 1753052561:AAFzN34j69GEJTg-7pG4roSzAAnUxT1rwFU

To test the REST Webservices functionality, you can run https://github.com/LugomVl/AngularTg.
