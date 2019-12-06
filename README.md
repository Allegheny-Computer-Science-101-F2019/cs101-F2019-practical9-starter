# cs101-F2019-practical9-starter

## Table of Contents

* [Table of Contents](#table-of-contents)
* [Introduction](#introduction)
* [Continuous Learning](#continuous-learning)
* [System Commands](#system-commands)
  + [Using Docker](#using-docker)
  + [Using Gradle](#using-gradle)
* [Expected Program Output](#expected-program-output)
* [Automated Checks with GatorGrader](#automated-checks-with-gatorgrader)
* [Downloading Project Updates](#downloading-project-updates)
* [Using Travis CI](#using-travis-ci)
* [System Requirements](#system-requirements)
* [Reporting Problems](#reporting-problems)
* [Receiving Assistance](#receiving-assistance)
* [Project Assessment](#project-assessment)

## Introduction

This assignment requires a programmer to understand the methods in a `WordCount`
program that is inspired by the source code segment in Section 10.1.2 of the
textbook. With that said, the provided source code combines the `Tree` and
`HashMap` data structures to implement a more comprehensive solution. Your job
for this assignment is to run the program and study its output. Then, you are
responsible for adding comments to the source code that demonstrate you
understand how the `WordCount` program uses both a `Tree` and a `HashMap` to
produce the expected output. You should also add the correct output statements
to the program's source code. Students who are interested in doing so are
encouraged to write extra Java methods that can, for instance, print out the
word that is most frequently found in the input file. Additionally, you are
invited to run the `WordCount` program with a different input file. Finally,
as verified by [Checkstyle](https://github.com/checkstyle/checkstyle), the
source code for all of the Java classes must adhere to all of the requirements
in the [Google Java Style
Guide](https://google.github.io/styleguide/javaguide.html). The source code in
the submitted Java source code files must also pass additional tests set by
the [GatorGrader tool](https://github.com/gkapfham/gatorgrader). More details
about the GatorGrader checks are included later in this document and in the
assignment sheet.

## Continuous Learning

If you have not done so already, please read all of the relevant [GitHub
Guides](https://guides.github.com/) that explain how to use many of the features
that GitHub provides. In particular, please make sure that you have read the
following GitHub guides: [Mastering
Markdown](https://guides.github.com/features/mastering-markdown/), [Hello
World](https://guides.github.com/activities/hello-world/), and [Documenting Your
Projects on GitHub](https://guides.github.com/features/wikis/). Each of these
guides will help you to understand how to use both [GitHub](http://github.com) and
[GitHub Classroom](https://classroom.github.com/).

Students who want to learn more about how to use
[Docker](https://www.docker.com) should review the [Docker
Documentation](https://docs.docker.com/). Students are also encouraged to review
the documentation for their text editor, which is available for text editors
like [Atom](https://atom.io/docs) and [VS
Code](https://code.visualstudio.com/docs). You should also review the [Git
documentation](https://git-scm.com/doc) to learn more about how to use the Git
command-line client. In addition to talking with the instructor and technical
leader for your course, students are encouraged to search
[StackOverflow](https://stackoverflow.com/) for answers to their technical
questions.

Please read all the content and study all the technical diagrams and source code
segments in Sections 8.1 through 8.3 and 10.1 through 10.2. Finally, please see
the course instructor or one of the teaching assistants or tutors if you have
questions about any of these reading assignments.

## System Commands

This project invites students to enter system commands into a terminal window.
This assignment uses [Docker](https://www.docker.com) to deliver programs, such
as `gradle` and the source code and packages needed to run
[GatorGrader](https://github.com/GatorEducator/gatorgrader), to a students'
computer, thereby eliminating the need for a programmer to install them on their
development workstation. Individuals who do not want to install Docker can
optionally install of the programs mentioned in the [Project
Requirements](#requirements) section of this document.

### Using Docker

Once you have installed [Docker
Desktop](https://www.docker.com/products/docker-desktop), you can use the
following `docker run` command to start `gradle grade` as a containerized
application, using the [DockaGator](https://github.com/GatorEducator/dockagator)
Docker image available on
[DockerHub](https://cloud.docker.com/u/gatoreducator/repository/docker/gatoreducator/dockagator).

```bash
docker run --rm --name dockagator \
  -v "$(pwd)":/project \
  -v "$HOME/.dockagator":/root/.local/share \
  gatoreducator/dockagator
```

The aforementioned command will use `"$(pwd)"` (i.e., the current directory) as
the project directory and `"$HOME/.dockagator"` as the cached GatorGrader
directory. Please note that both of these directories must exist, although only
the project directory must contain something. Generally, the project directory
should contain the source code and technical writing of this assignment, as
provided to a student through GitHub. Additionally, the cache directory should
not contain anything other than directories and programs created by DockaGator,
thus ensuring that they are not otherwise overwritten during the completion of
the assignment. To ensure that the previous command will work correctly, you
should create the cache directory by running the command `mkdir
$HOME/.dockagator`. If the above `docker run` command does not work correctly on
the Windows operating system, you may need to instead run the following command
to work around limitations in the terminal window:

```bash
docker run --rm --name dockagator \
  -v "$(pwd):/project" \
  -v "$HOME/.dockagator:/root/.local/share" \
  gatoreducator/dockagator
```

If that Docker command does not work correctly, then you should first consider
writing the command on a single line in your terminal window and then replacing
`$(pwd)` and `$HOME` with the fully qualified name of the directory that those
variables represent. Students who are stuck on this step should explain to the
course instructor what they have already tried and what challenges they
currently face.

Here are some additional commands that you may need to run when using Docker:

* `docker info`: display information about how Docker runs on your workstation
* `docker images`: show the Docker images installed on your workstation
* `docker container list`: list the active images running on your workstation
* `docker system prune`: remove many types of "dangling" components from your workstation
* `docker image prune`: remove all "dangling" docker images from your workstation
* `docker container prune`: remove all stopped docker containers from your workstation
* `docker rmi $(docker images -q) --force`: remove all docker images from your workstation

### Using Gradle

Since the above `docker run` command uses a Docker image that, by default, runs
`gradle grade` and then exits the Docker container, you may want to instead run
the following command so that you enter an "interactive terminal" that will
allow you to repeatedly run commands within the Docker container.

```bash
docker run -it --rm --name dockagator \
  -v "$(pwd)":/project \
  -v "$HOME/.dockagator":/root/.local/share \
  gatoreducator/dockagator /bin/bash
```

Once you have typed this command, you can use the [GatorGrader
tool](https://github.com/GatorEducator/gatorgrader) in the Docker container by
typing the command `gradle grade` in your terminal. Running this command will
produce a lot of output that you should carefully inspect. If GatorGrader's
output shows that there are no mistakes in the assignment, then your source code
and writing are passing all of the automated baseline checks. However, if the
output indicates that there are mistakes, then you will need to understand what
they are and then try to fix them.

You can also complete several important Java programming tasks by using the
`gradle` tool. For instance, you can compile (i.e., create bytecode from the
program's source code if it is correct) the program using the command `gradle
build`. Here are some other commands that you can type:

* `gradle grade`: run the [GatorGrader](https://github.com/GatorEducator/gatorgrader) tool to check your work
* `gradle clean`: clean the project of all the derived files
* `gradle check`: check the quality of the code using Checkstyle
* `gradle build`: create the bytecode from the Java source code
* `gradle run`: run the Java program in the command-line
* `gradle cleanTest`: clean the JUnit test suite of derived files
* `gradle test`: run the JUnit test suite and display the results
* `gradle tasks`: display details about the Gradle system

To run one of these commands, you must be in the main (i.e., "home base")
directory for this assignment where the `build.gradle` file is located.

## Expected Program Output

Typing the command `gradle run` in the Docker container produces the following
output for the instructor's version of this assignment. Finally, please note
that this laboratory assignment invites you to run a comprehensive JUnit test
suite of a Java class in a different package. While this test suite does not
produce any output, you should carefully inspect its tests so that you
understand their strategy. In particular, it is critically important that you
study and understand every test case in `TestDoublyLinkedList`.

```
Reading and tracking the words in the file ...
... Finished reading and tracking the words in the file.

Analysis of the words in the file ...

(key, value) pairs sorted by key:

{a=4, already=1, append=1, associated=3, associates=1, be=1, combining=1, create=1, either=1, example=1, for=2, function=1, given=2, if=2, is=3, it=1, key=2, mapped=1, mapping=1, may=1, method=1, msg=1, multiple=1, non=1, not=1, null=3, of=2, or=3, otherwise=1, remapping=1, removes=1, replaces=1, result=1, results=1, specified=1, string=1, the=6, this=1, to=2, use=1, value=4, values=1, when=1, with=4}

(key, value) pairs sorted by value and key:

[already=1, append=1, associates=1, be=1, combining=1, create=1, either=1, example=1, function=1, it=1, mapped=1, mapping=1, may=1, method=1, msg=1, multiple=1, non=1, not=1, otherwise=1, remapping=1, removes=1, replaces=1, result=1, results=1, specified=1, string=1, this=1, use=1, values=1, when=1, for=2, given=2, if=2, key=2, of=2, to=2, associated=3, is=3, null=3, or=3, a=4, value=4, with=4, the=6]

... Finished the analysis of the words in the file.
```

## Automated Checks with GatorGrader

In addition to meeting all of the requirements outlined in the assignment sheet,
your submission must pass the following checks that
[GatorGrader](https://github.com/GatorEducator/gatorgrader) automatically
assesses:

- The WordCount.java in src/main/java/practicalnine/count has at least 20 single-line Java comment(s)
- The WordCount.java in src/main/java/practicalnine/count has exactly 0 of the `Add Your Name Here` fragment
- The WordCount.java in src/main/java/practicalnine/count has exactly 0 of the `TODO` fragment
- The WordCount.java in src/main/java/practicalnine/count has exactly 1 of the `package practicalnine` fragment
- The WordCount.java in src/main/java/practicalnine/count has exactly 1 of the `public static void` fragment
- The command `gradle -q --console plain run` executes correctly
- The command `gradle build` executes correctly
- The file WordCount.java exists in the src/main/java/practicalnine/count directory
- The repository has at least 5 commit(s)!

If [GatorGrader's](https://github.com/GatorEducator/gatorgrader) automated
checks pass correctly, the tool will produce the output like the following in
addition to returning a zero exit code (which you can access by typing the
command `echo $?`).

```
        ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
        ┃ Passed 9/9 (100%) of checks for cs101-F2019-practical9! ┃
        ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
```

## Downloading Project Updates

If GatorGrader's maintainers push updates to this sample assignment and you
received it through GitHub Classroom and you would like to also receive these
updates, then you can type this command in the main directory for this
assignment:

```
git remote add download git@github.com:Allegheny-Computer-Science-101-F2019/cs101-F2019-practical9-starter.git
```

You should only need to type this command once; running the command additional
times may yield an error message but will not negatively influence the state of
your Git repository. Now, you are ready to download the updates provided by the
GatorGrader maintainers by typing this command:

```
git pull download master
```

This second command can be run whenever the maintainers needs to provide you
with new source code for this assignment. However, please note that, if you have
edited the files that we updated, running the previous command may lead to Git
merge conflicts. If this happens, you may need to manually resolve them with the
help of the instructor or a student technical leader. Finally, please note that
the [Gradle plugin](https://github.com/GatorEducator/gatorgradle) for
[GatorGrader](https://github.com/GatorEducator/gatorgrader) will automatically
download the newest version of GatorGrader.

## Using Travis CI

This assignment uses [Travis CI](https://travis-ci.com/) to automatically run
[GatorGrader](https://github.com/GatorEducator/gatorgrader) and additional
checking programs every time you commit to your GitHub repository. The checking
will start as soon as you have accepted the assignment &mdash; thus creating your own
private repository &mdash; and the course instructor and/or GitHub enables Travis for
it. If you are using Travis for the first time, you will need to authorize
Travis CI to access the private repositories that you created on GitHub. If you
do not see either a yellow &#9679; or a green &#x2714; or a red &#x2717; in your
listing of commits, then please ask the instructor to see whether or not
Travis CI was correctly enabled.

## System Requirements

We developed this assignment to work with the following software and versions:

- Docker Desktop
- Operating Systems
  - Linux
  - MacOS
  - Windows 10 Pro
  - Windows 10 Enterprise
- Programming Language Tools
  - Gradle 5.4
  - MDL 0.5.0
  - OpenJDK 11.0.4
  - JUnit 4.9.0
  - Proselint 0.10.2
  - Python 3.6 or 3.7

## Reporting Problems

If you have found a problem with this assignment's provided source code or
documentation, then you can go to the [Computer Science 101 Fall 2019 Practical
9](https://github.com/Allegheny-Computer-Science-101-F2019/cs101-F2019-practical9-starter)
repository and [raise an
issue](https://github.com/Allegheny-Computer-Science-101-F2019/cs101-F2019-practical9-starter/issues).
If you have found a problem with the [GatorGrader
tool](https://github.com/GatorEducator/gatorgrader) and the way that it checks
your assignment, then you can also [raise an
issue](https://github.com/GatorEducator/gatorgrader/issues) in that repository.
To ensure that your issue is properly resolved, please provide as many details
as is possible about the problem that you experienced. If you discover a problem
with the assignment sheet for this project, then please raise an issue in the
GitHub repository that provides the assignment sheets for your course.

Whenever possible, individuals who find, and use the appropriate GitHub issue
tracker to correctly document, a mistake in any aspect of this assignment will
receive free [GitHub stickers](https://octodex.github.com/) and extra credit
towards their grade for the project.

## Receiving Assistance

If you are having trouble completing any part of this project, then please talk
with either the course instructor or a student technical leader during the
course session. Alternatively, you may ask questions in the Slack workspace for
this course. Finally, you can schedule a meeting during the course instructor's
office hours.

## Project Assessment

Taking inspiration from the principles of [specification-based
grading](http://rtalbert.org/return-to-specs-grading-calculus/), the grade that
a student receives on this practical assignment is based on the following:

- **Travis CI Build Status**: Since additional checks on the source code and/or
  technical writing may be encoded in Travis CI's actions and, moreover, all of
  the GatorGrader checks are also run in Travis CI, students will receive a
  checkmark grade if their last before-the-deadline build passes and a green
  &#x2714; appears in their GitHub commit log instead of a red &#x2717;.
  Students are encouraged to repeatedly revise their source code in an attempt
  to get their Travis CI build to pass.

All grades for this project will be reported through a student's GitHub
repository using either messages in the GitHub commit log or issues raised in
the issue tracker. Students should ask questions about their grade for this
project in GitHub so as to facilitate an effective conversation about the
submitted deliverables.
