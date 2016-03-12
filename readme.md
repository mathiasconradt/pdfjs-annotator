# PdfJs Annotator

PdfJs-Annotator is a proof of concept project that integrates AnnotatorJs (http://annotatorjs.org/) with the PdfJs (https://mozilla.github.io/pdf.js/) library.
It uses a simple Spring Boot application and a MySql database containing one table in the backend to persist annotations.
MIT License applies (http://opensource.org/licenses/MIT).

## Used libaries and frameworks, licenses
* PdfJS (Apache License 2.0, http://www.apache.org/licenses/LICENSE-2.0)
* Annotator v1.2.10 (Dual licensed under the MIT and GPLv3 licenses, https://github.com/okfn/annotator/)
* jQuery v2.1.4 (MIT License, https://tldrlegal.com/license/mit-license)
* Spring Boot 1.2.3 (Apache License 2.0, https://github.com/spring-projects/spring-boot/blob/master/LICENSE.txt)

Thanks to the authors and contributors of those libraries and frameworks.

## Project Setup

### Clone the project

`git clone git@bitbucket.org:mathiasconradt/pdfjs-annotator.git`

### Create database pdfjs_annotator 

Create a MySql database named pdfjs_annotator:

`CREATE DATABASE pdfjs_annotator CHARACTER SET utf8 COLLATE utf8_bin;`

### Create database schema 

Create the database schema in the just created pdfjs_annotator database:

`
SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS 'annotation';
CREATE TABLE 'annotation' (
  'id' varchar(255) COLLATE utf8_bin NOT NULL,
  'annotator_schema_version' varchar(255) COLLATE utf8_bin DEFAULT NULL,
  'consumer' varchar(255) COLLATE utf8_bin DEFAULT NULL,
  'created' datetime DEFAULT NULL,
  'quote' longtext COLLATE utf8_bin,
  'end' varchar(255) COLLATE utf8_bin DEFAULT NULL,
  'end_offset' int(11) DEFAULT NULL,
  'start' varchar(255) COLLATE utf8_bin DEFAULT NULL,
  'start_offset' int(11) DEFAULT NULL,
  'tags' tinyblob,
  'text' longtext COLLATE utf8_bin,
  'updated' datetime DEFAULT NULL,
  'uri' varchar(2000) COLLATE utf8_bin DEFAULT NULL,
  'user' varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY ('id')
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
SET FOREIGN_KEY_CHECKS = 1;
`

### Adjust database connection (optional) 

Database connection properties for the project are defined in `/src/main/resources/application.properties`.

It assumes username `root` and password `root`. Adjust it to your own local MySql server.

## Starting the project

Make sure you have Gradle installed. If not, download it from here http://gradle.org, then add the gradle/bin folder to your environment PATH.

You can start the project with: `gradle run`

The embedded Tomcat starts up (make sure port 8080 isn't in use by anything else). 
You can then open a web browser and point it to: `http://localhost:8080/web/viewer`

You should then see a default dummy pdf and you should be able to annotate it by marking a word or sentence with the mouse.

![IMAGE](https://bitbucket.org/mathiasconradt/pdfjs-annotator/downloads/pdfjs-annotator.png)

### Loading a different pdf

You can load any other pdf by specifying a url parameter `file`, which would then take the pdf by that name from the folder `/src/main/resources/static/web`.

Example: `http://localhost:8080/web/viewer?file=example.pdf`

## Questions

For any questions, you can contact me.

E-Mail: mathias.conradt@gmail.com

Twitter: https://twitter.com/mathiasconradt

Stackoverflow: http://stackoverflow.com/users/241475/mathias-conradt?tab=profile