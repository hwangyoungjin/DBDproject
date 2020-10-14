# DBDproject
personal Project
---
[1. IntelliJ + gradle + jdbc +mysql 으로 test_tb테이블 레코드 검색 & 삽입]
---
1. gradle, jdk8 프로젝트 생성
2. build.gradle의 의존성추가
	```
	compile group: 'mysql', name: 'mysql-connector-java', version: '8.0.21'
	```
3. auth 디렉토리 만들어서 mysql.auth 추가
4. mysql 스키마, 계정 만들어서 해당 정보 mysql.auth의 추가
5. mysql.auth 정보와 DB정보연결할 DB접속정보클래스(DatabaseAuthInformation.java) 추가 **학교제공파일** 	
6. Test_tb 테이블과 TestDAO 만들어서 예제5코드(select sql문) 추가
	```java
	[타임존 에러발생]
	[해결방법](https://irerin07.tistory.com/14)
	mysql 데이터 소스 url 맨뒤에 "스키마이름?" 뒤에
	useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
	추가
	[설명]
	=>DB 연결에대해
	• Unicode를사용하고
	• DB 서버에정의된Time Zone을사용하며(Client에서시간을보정하지않으며)
	• DB 서버의Time Zone은UTC로설정함
	```
7. 예제5코드(insert sql문) 추가
8. 테스트 레코드 삽입 + 검색 테스트 완료