# HorsesWebCrawlerToCsv

The aim of this project is to build up a data set on horses. It is coded as an Akka Actor system using Scala.
Actors use the open source Jsoup library to crawl web sites and collect data on horses and their recent racing form.
There are 3 inputs (in ActorApp) to this project:

1. filePath - a String;
2. lowerLimit - an integer; and,
3. upperLimit - an interger.

The upper and lower limits are used to generate urls which are then crawled to obtain information about horses and their recent race history.
This data is then stored in a csv file which will be located in the local folder the filepath string points to and will be named depending upon the lower and upper limit values input.

For example, suppose a user used the following inputs:

1. filepath - "c:/user/docs/";
2. lowerLimit - "0"; and,
3. upperLimit - "15".

The project would generate https://www.sportinglife.com/racing/profiles/horse/0000000, https://www.sportinglife.com/racing/profiles/horse/0000001, ....., https://www.sportinglife.com/racing/profiles/horse/0000013, https://www.sportinglife.com/racing/profiles/horse/0000014
and collect horse and race data. It will store this data as a csv file "0_to_10_horses.csv" locally in the folder "c:/user/docs/0_to_10_horses.csv"