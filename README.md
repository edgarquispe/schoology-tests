#Schoology-test

###Environment requirements
* Java 11+
* Chrome or Firefox browser.
* Gradle.

###Run automated tests
You can use the following command to execute the automated tests:
By default it will be run in Chrome.

```shell script
gradle clean runFeatures
```

###Configuration
Please see as example the config.json.dist and create a new config.json file
Don't forget to create two accounts as Instructor and one account as Student

* "browser" -> you can specify the following values {"CHROME", "FIREFOX", "HEADLESS"}
* "threadCount" -> you can specify the number of threads to run in parallel the automated tests.

Configuration example:
```shell script
  "browser": "headless",
  "threadCount": "2",
  "credentials": {
    "Instructor01": {
      "username": "myaccount01@gmail.com",
      "password": "P@ssw0rd"
    },
    "Instructor02": {
      "username": "myaccount02@gmail.com",
      "password": "P@ssw0rd"
    },
    "Student01": {
      "username": "myaccount03@gmail.com",
      "password": "P@ssw0rd"
    }
  }
```
