## eclipse

For development I recommend spring tools suite. Included in the STS packaged version of eclipse
there is a Boot Dashboard view. From here you can start and stop the deployment. The devtools
plugin will then manage hot swapping so most of the changes you make will be immediately visible
in the browser.

Once you are satisfied, you can build a docker image, which will publish to docker hub.

## Docker

Use the gradle build task `buildDocker` to build the docker image. From the project root, execute the following command:

    $ ./gradlew buildDocker

Run the docker image:

    $ docker run -p 8080:8080 -t troyhart/boot-docker-simple