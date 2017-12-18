Installation Instructions
=========================

Installation Summary

1. Install Java and ensure that the JAVA_HOME environment variable is set :
2. Install Tomcat
3. Set up an admin user for Tomcat
4. Deploy the .war archives of the HSLynk applications via the Tomcat administrative UI OR
5. Copy the .war archives of the HSLynk applications to the


 Installation Details
 --------------------

 1. Instructions on setting up and properly configuring the JAVA_HOME environment for your environment can found here : [Instructions](https://docs.oracle.com/cd/E19182-01/820-7851/inst_cli_jdk_javahome_t/)
 2. Instructions on installing and setting up Tomcat are as below :
  To install Tomcat on Windows or Mac, refer [Here](https://www.ntu.edu.sg/home/ehchua/programming/howto/Tomcat_HowTo.html#zz-2.)
  , To install Tomcat on Ubuntu or other Linux variants, refer [here](https://www.ntu.edu.sg/home/ehchua/programming/howto/Ubuntu_HowTo.html#tomcat)
  3. Once Tomcat is installed, move to the installation directory of Tomcat and edit the file "$TOMCAT_HOME\conf\tomcat-users.xml". Add a new entry to the list of users with the role assigned as "manager-gui".
  Example Entry :  ` <user username="tomcat" password="s3cret" roles="manager-gui"/> `
  4. To deploy and application to the Tomcat installation, Start tomcat and access the Tomcat admin GUI in your browser as follows :
  http://localhost:8080/manager/html . *PS : Assuming you are running Tomcat on locahost. Change the IP to the appropriate IP otherwise*
5. Under the "War File to Deploy section", Click the "Choose File" button and navigate to the .war file that you want to deploy
6. Alternatively, Copy the .war file to the "webapp" folder of the Tomcat installation, and restart Tomcat. The application will be deployed upon startup
