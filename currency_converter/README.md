<h1 align="center">Currency Converter - Alura Challenge</h1>

![App_Logo](https://github.com/JODACHSE/Oracle_Gr6_ONE/assets/119604665/c6d4df72-5d62-4649-b5c7-2390d58600fb)

## Table of Contents
  1. [Description](#description)
  2. [Principal features](#principal-features)
  3. [What you will find in this java project](#what-you-will-find-in-this-java-project)
  4. [Benefits of the project](#benefits-of-the-project)
  5. [Credits](#credits)

## Description
  This program developed in Java allows the user to convert currencies between different currencies through queries of external web services such as the ExchangeRate-API and to maintain a historical record of the conversions made through the implementation of storage systems, in this case local.

## Principal features
  * Programming Language: Alura's back-end course is focused on teaching through Java. Using this robust language has several advantages, including its portability, performance, and wide range of available APIs and libraries. Being scalable and able to integrate with modern technologies, Java becomes a very effective choice for applications of this type.
  * Gson Integration: Gson is a Java library that facilitates conversion between Java objects and JSON notation, which is useful for handling data received from APIs in JSON format.
  * Conversion History: Implementation of a storage system (local) that records conversions performed by users, along with details such as the amount converted and the currencies involved.

## What you will find in this java project
### Main Settings
  The `.vscode/settings.json` file contains the Java project settings. It sets:
  * Path to the JDK installation directory.
  * Project source paths where source files are located.
  * Output path where compiled (binary) files are generated.
  * External libraries referenced by the project.

### Libreary
  The `lib/gson-2.11.0.jar` file is an essential library (developed by Google) for Java projects that need to interact with JSON data in an efficient and robust way, offering powerful tools to convert Java objects to JSON and vice versa effectively and with high performance.

### Proyect Sources
  * The `src/consoleUtils.java` code provides utilities to clear the console by using an attribute to run after a specified time (in seconds) and perform a countdown (in seconds) before displaying information.

  * The `src/ConversionHistory.java` code demonstrates the use of the GSON library to handle JSON data in Java. The ConversionHistory class manages a history of currency conversions, allowing new conversions to be added, the history to be printed, and saving/loading from a JSON file for data persistence. The Conversion class models a single conversion with its associated details.

  * The `src/CurrencyConverter` class facilitates the conversion of a specific amount using a conversion rate, calculating the result of the conversion and returning it as a double number.

  * The `src/CurrencyConverterApi.java` code creates a simple command-line interface for users to perform currency conversions, view a history of completed conversions, and exit the application in a controlled manner.

  * The `src/CurrencyConverterApi.java` code implements a service for obtaining currency exchange rates through an external API. Implements a currency exchange rate retrieval service via an external API. The code is responsible for making HTTP requests to a currency exchange rate API (ExchangeRate-API), extracting the exchange rate between two specific currencies from the response JSON, and handling potential errors during the process.

## Benefits of the project
  * Accessibility: Allows users to perform currency conversions quickly and efficiently.
  * Historical Record: Facilitates tracking of conversions performed, which can be useful for accounting or analysis purposes.
  * Integration with External APIs: Take advantage of updated information from external services to ensure the accuracy of exchange rates.

## Credits
  This project was made possible thanks to the support and resources provided by Alura and Oracle.
  For the development of the code for this project, the following tools and sources of reference were used:
  * ChatGPT from OpenAI: For support during code generation and correction.
  * BlackBox: As an additional development and debugging tool.
  * Bing: For searching for additional information and references.
  I thank all of them for their contribution and support in the realization of this project.

  [Alura Latam](https://www.linkedin.com/company/alura-latam/)
  [Oracle](https://www.linkedin.com/company/oracle/)