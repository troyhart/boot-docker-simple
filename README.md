## deploy locally from command line

From the project root open a command terminal and enter the following gradle build command:

    $ ./gradlew bootRun

See the application running: [http://localhost:8080](http://localhost:8080)

## eclipse

For development I recommend [spring tools suite (STS)](https://spring.io/tools). Included in the STS packaged version of eclipse
there is a Boot Dashboard view. From here you can start and stop the deployment. The devtools
plugin will then manage hot swapping so most of the changes you make will be immediately visible
in the browser.

Once you are satisfied, you can build a docker image, which will publish to docker hub.

## build docker image

Use the gradle build task `buildDocker` to build the docker image. From the project root, execute the following command:

    $ ./gradlew buildDocker

Run the docker image:

    $ docker run -p 8080:8080 -t troyhart/boot-docker-simple