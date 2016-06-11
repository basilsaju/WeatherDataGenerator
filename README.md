# WeatherDataGenerator

This is a project to generate sample data for testing weather models. 
The output is of the following format:
city|latitude,longitude,altitude|timestamp|temperature|pressure|humidity|condition

inputs:
  1. location file location: city,latitude,longitude,altitude.
  2. min-max file location: city, season, minTemp, maxTemp, minPressure, maxPressure, minHumidity, maxHumidity.
  3. output file location.

###Logic Used:
A random date is generated from which season is chosen. From the input file, other parameters like temperature, pressure, humidity are randomly generated within the range specified by the input file. Condition is calculated from the rule specified that takes temperature, pressure, humidity and season into account.

###Build:
mvn clean install
