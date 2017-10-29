# README

This project contains the skeleton for testing Amazon search and filter functionality.  It also 
has the helper methods to store Articles and sort them according to the instructions.  It uses a POM design pattern to separate the test case implementation from the test case itse.f 

## Setup

This project uses Selenium, JUnit and JUnitParams to work, although it also needs TestNG libraries 
to compile the libraries already included.  These jars must be included in the BuildPath.

Also, in order to run it one must modify the 'CHROME_DRIVER_PATH' and 'FIREFOX_DRIVER_PATH' in the
helpers.Properties class, as well as download chromedriver and geckodriver for the host operating system.

One must also modify the test params in the /data/params.csv file in order to prepare the test to run more variations.