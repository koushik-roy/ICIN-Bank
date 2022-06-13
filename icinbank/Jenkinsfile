pipeline {
    agent any
//    parameters {
//        string(name: 'MYSQL_ROOT_PASSWORD', defaultValue: 'devadeep', description: 'MySQL password')
//        string(name: 'MYSQL_ROOT_USER', defaultValue: 'root', description: 'MySQL password')
//        string(name: 'MYSQL_DATABASE', defaultValue: 'bootdb', description: 'MySQL database')
////        string(name: 'MYSQL_USER', defaultValue: 'root', description: 'MySQL username')
//    }
    stages {
        stage ("Initialize Jenkins Env") {
         steps {
            bat '''
            echo "PATH = ${PATH}"
            echo "M2_HOME = ${M2_HOME}"
            '''
         }
        }
        stage('Download Code') {
            steps {
               echo 'checking out'
               checkout scm
            }
        }
        stage('Build Application'){
            steps {
                echo 'Building...'
                bat 'mvn clean install -Dmaven.test.skip=true'
            }
        }
        stage('Build Docker Image') {
            steps {
                echo 'Building Docker image'
                bat 'docker build -t usermysql .'
            }
        }
        stage('Pull MySQL Image') {
            steps {
                echo 'Pulling mysql image'
                bat 'docker pull mysql:8.0.23'
            }
        }
        stage('Run MySQL server to run as Docker container') {
            steps {
                echo 'Running mysql image and giving warmup time of approx 4 minutes'
                bat 'docker run --name mysqlstandalone -e MYSQL_DATABASE=bootdb -e MYSQL_ROOT_PASSWORD=devadeep -e MYSQL_ROOT_USER=root -d mysql:8.0.23'
                bat 'ping -n 400 127.0.0.1>NUL'
            }
        }
        stage('Deploy and Run Bank Application container') {
            steps {
                echo 'Starting application container'
                bat 'docker run -d -p 7070:8080 --name usermysql --link mysqlstandalone:mysql usermysql'
//               bat 'docker container logs -f usermysql'
                 bat 'ping -n 90 127.0.0.1>NUL'
                 echo 'Started application container on port 7070'
				 bat 'docker exec -i mysqlstandalone mysql -uroot -pdevadeep -e "SHOW DATABASES;"'
				bat 'docker exec -i mysqlstandalone mysql -uroot -pdevadeep -e "SHOW TABLES FROM bootdb;"'
				bat 'docker exec -i  mysqlstandalone mysql -uroot -pdevadeep < insert.sql'
				bat 'docker exec -i mysqlstandalone mysql -uroot -pdevadeep -e "SELECT * FROM bootdb.role;"'
//				 bat 'ping -n 300 127.0.0.1>NUL'
            }
        }
        stage('Execute Test1'){
            steps {
                echo 'Testing Started'
                bat 'mvn test -Dtest=ICINBanksignuptest'
            }
        }
		stage('Execute Test2'){
            steps {
                echo 'Testing Started'
                bat 'mvn test -Dtest=ICINBankwithdrawtest'
            }
        }
		
		stage('Execute Test3'){
            steps {
                echo 'Testing Started'
                bat 'mvn test -Dtest=ICINBanktransfertest'
            }
        }
		stage('Execute Test4'){
            steps {
                echo 'Testing Started'
                bat 'mvn test -Dtest=ICINBankrequesttest'
            }
        }
		stage('Execute Test5'){
            steps {
                echo 'Testing Started'
                bat 'mvn test -Dtest=ICINBankadmintest'
            }
        }
		stage('Issue Admin Acess from user created through test execution'){
            steps {
                echo 'Issuing Admin Access'
                bat 'docker exec -i  mysqlstandalone mysql -uroot -pdevadeep < update.sql'
				bat 'docker exec -i  mysqlstandalone mysql -uroot -pdevadeep -e "SELECT * FROM bootdb.user_role;"'
            }
        }
//		stage('Clean docker containers and images'){
//		steps{
//		     echo 'Stopping application container and database after 5 minutes'
//		     bat "docker stop usermysql && docker rm usermysql && docker stop mysqlstandalone && docker rm mysqlstandalone && docker rmi usermysql && docker rmi mysql:8.0.23"
//			}
//        }
//       stage('Create Database') {
//            steps {
//                echo 'Running Database Image'
//            //    sh 'docker kill bankmysql 2> /dev/null'
//            //    sh 'docker kill cloudbank 2> /dev/null'
//            //    sh 'docker rm bankmysql 2> /dev/null'
//            //    sh 'docker rm cloudbank 2> /dev/null'
//                sh 'docker stop bootdb || true && docker rm bootdb || true'
//                sh 'docker run --detach --name=mysqldbnew --env="MYSQL_ROOT_PASSWORD=${MYSQL_ROOT_PASSWORD}" -p 3306:3306 mysql:8.0.23'
//                sh 'sleep 20'
//            //  sh 'docker exec -i bankmysql mysql -uroot -proot < sql_dump/onlinebanking.sql'
//                sh 'docker exec -i mysqldbnew mysql -uroot -p${MYSQL_ROOT_PASSWORD} < sql_dump/bootdb.sql'
//            }
//        }
//        stage('Deploy and Run') {
//            steps {
//                echo 'Running Application'
//                sh 'docker stop cloudbank || true && docker rm cloudbank || true'
//                sh 'docker run --detach --name=cloudbank -p 8888:8888 --link mysqlsqldbnew:localhost -t devadeepdeb/icinbank:1'
//            }
//        }
    }
}