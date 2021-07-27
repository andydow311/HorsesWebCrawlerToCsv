import java.io.FileWriter

import akka.actor.{ActorSystem, Props}

object ActorApp extends App{

  val filePath = "/Users/andydowell/dashboard_for_horses/appoires/horse_and_race/"
  val lowerLimit = "0"
  val upperLimit = "10"
  val fileName = filePath + lowerLimit + "_to_" + upperLimit+"_horses.csv"

  writeHorseTitleRaceToCSV(fileName)

  //partone Create System
  val webCrawlingSystem = ActorSystem("crawl")

  //partThree instatiate Actors
  val masterOne = webCrawlingSystem.actorOf(Props[Worker], "one")
  val masterTwo = webCrawlingSystem.actorOf(Props[Worker], "two")
  val masterThree = webCrawlingSystem.actorOf(Props[Worker], "three")
  val masterFour = webCrawlingSystem.actorOf(Props[Worker], "four")
  val masterFive = webCrawlingSystem.actorOf(Props[Worker], "five")
  val masterSix = webCrawlingSystem.actorOf(Props[Worker], "six")
  val masterSeven = webCrawlingSystem.actorOf(Props[Worker], "seven")
  val masterEight = webCrawlingSystem.actorOf(Props[Worker], "eight")
  val masterNine = webCrawlingSystem.actorOf(Props[Worker], "nine")
  val masterTen = webCrawlingSystem.actorOf(Props[Worker], "ten")
  val masterEleven = webCrawlingSystem.actorOf(Props[Worker], "eleven")
  val masterTwelve = webCrawlingSystem.actorOf(Props[Worker], "twelve")
  val masterThirteen = webCrawlingSystem.actorOf(Props[Worker], "thirteen")
  val masterFourteen = webCrawlingSystem.actorOf(Props[Worker], "fourteen")
  val masterFifteen = webCrawlingSystem.actorOf(Props[Worker], "fifteen")
  val masterSixteen = webCrawlingSystem.actorOf(Props[Worker], "sixteen")
  val masterSeventeen = webCrawlingSystem.actorOf(Props[Worker], "seventeen")
  val masterEightteen = webCrawlingSystem.actorOf(Props[Worker], "eightteen")
  val masterNineteen = webCrawlingSystem.actorOf(Props[Worker], "nineteen")
  val masterTwenty = webCrawlingSystem.actorOf(Props[Worker], "twenty")


//  //partFour communicate
  Range(lowerLimit.toInt,upperLimit.toInt).map(n => {
    val datatoBePassesdToWorkers = ("%07d".format(n), fileName)
    if(n % 20 == 0){
      masterOne ! datatoBePassesdToWorkers
    } else if(n % 20 == 1){
      masterTwo ! datatoBePassesdToWorkers
    }else if(n % 20 == 2){
      masterThree ! datatoBePassesdToWorkers
    } else if(n % 20 == 3) {
      masterFour ! datatoBePassesdToWorkers
    }else if(n % 20 == 4){
      masterFive ! datatoBePassesdToWorkers
    } else if(n % 20 == 5) {
      masterSix ! datatoBePassesdToWorkers
    }else if(n % 20 == 6){
      masterSeven ! datatoBePassesdToWorkers
    } else if(n % 20 == 7) {
      masterEight ! datatoBePassesdToWorkers
    } else if(n % 20 == 8) {
      masterNine ! datatoBePassesdToWorkers
    } else if(n % 20 == 9) {
      masterTen ! datatoBePassesdToWorkers
    }else if(n % 20 == 10) {
      masterEleven ! datatoBePassesdToWorkers
    }else if(n % 20 == 11) {
      masterTwelve ! datatoBePassesdToWorkers
    }else if(n % 20 == 12) {
      masterThirteen ! datatoBePassesdToWorkers
    }else if(n % 20 == 13) {
      masterFourteen ! datatoBePassesdToWorkers
    }else if(n % 20 == 14) {
      masterFifteen ! datatoBePassesdToWorkers
    }else if(n % 20 == 15) {
      masterSixteen ! datatoBePassesdToWorkers
    }else if(n % 20 == 16) {
      masterSeventeen ! datatoBePassesdToWorkers
    }else if(n % 20 == 17) {
      masterEightteen ! datatoBePassesdToWorkers
    }else if(n % 20 == 18) {
      masterNineteen ! datatoBePassesdToWorkers
    } else{
      masterTwenty ! datatoBePassesdToWorkers
    }
  })

  Thread.sleep(2000000)
  webCrawlingSystem.terminate



  //write title to CSV
  def writeHorseTitleRaceToCSV(filename:String): Unit = {
    val fw = new FileWriter(filename, true)
    try {
      fw.write(
        "ID,NAME,DOB,AGE OF HORSE,TRAINER,GENDER,SIRE,DAM,OWNER,DATE,POS,RAN,BHA,TYPE,COURSE,DISTANCE,GOING,CLASS,STARTING PRICE,POS_LABEL"+"\n"
      )
    }
    finally fw.close()
  }



}
