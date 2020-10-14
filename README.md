# DBDproject
personal Project
---
[1. IntelliJ + gradle + jdbc +mysql ]
	1. gradle, jdk8 프로젝트 생성
	2. build.gradle의 의존성추가
	```
	compile("mysql:mysql-connector-java:8.0.21") 
	```
	3. auth 디렉토리 만들어서 mysql.auth 추가
	4. mysql 스키마, 계정 만들어서 해당 정보 mysql.auth의 추가
	5. mysql.auth 정보와 DB정보연결할 DB접속정보클래스(DatabaseAuthInformation.java) 추가 	
	6. Test_tb 테이블과 TestDAO 만들어서 예제5코드(insert sql문) 추가
	```java
	[타임존 에러발생]
	[해결방법](https://irerin07.tistory.com/14)
	mysql 데이터 소스 url 맨뒤에 "스키마이름?" 뒤에
	useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
	추가
	```