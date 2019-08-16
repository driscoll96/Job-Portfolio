# CoolCreativeAardvarks

## API and React Interface

Set Up:
* Download and extract files in folder found at: 
  * https://github.ccs.neu.edu/CS5500SUMMER2019/CoolCreativeAardvarks/tree/API
* Then go back to the directory to the zip file's location and enter these commands:
    * "cd ski-app"
    * "npm install serve -g"
    * "npm run build"
    
How to use:
* In your computers terminal, change the directory to the zip file's location
* Then enter the following commands: (runs API server)
  * "cd target"
  * "java -jar CoolCreativeAardvarks-0.0.1-SNAPSHOT.jar"
* Then go back to the directory to the zip file's location and enter these commands: (runs React web server)
  * "serve -s build"
* Go to your browser and navigate to "http://localhost:5000"
* Happy Skiing!!

Known Issues:
- DB is only loaded with Friday, Saturday, Sunday data
- DB is not automatically loaded with data generated

Relevant Documents:
- To use with other SkiResorts, follow the format of "LiftConnections.csv"
