# practices-microservice


================================================================
Source Building
================================================================

1. Checkout the practices-microservice source code:

    cd ~
    git clone https://github.com/benson-git/practices-microservice.git practices-microservice

    git checkout master
    or: git checkout -b -0.0.1

2. Import the practices-microservice source code to eclipse project:

    cd ~/practices-microservice
    mvn eclipse:eclipse
    Eclipse -> Menu -> File -> Import -> Exsiting Projects to Workspace -> Browse -> Finish

3. Build the practices-microservice binary package:

    cd ~/dubbo
    mvn clean install -Dmaven.test.skip
    cd practices-microservice/target
    ls