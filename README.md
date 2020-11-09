# DBDproject
##personal Project
### skill :  IntelliJ + gradle + jdbc +mysql
---
[1. **basicProject** : test_tb테이블 레코드 검색 & 삽입]
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
	```java
	[select에서 Resultset.getInt("id")부분에서 ID를 못찾았다는 오류]
	[해결]
	String queryString = "select id,value from test_tb where id > 50"; 에서
	id 컬럼을 선택하지 않았었음
	```
9. 정리
---
![슬라이드1](https://user-images.githubusercontent.com/60174144/96840160-0dd1ef00-1485-11eb-8b96-6f8816fbff67.PNG)

[2. busProject]
---
1. **[1]**과정과 기본설정 동일
2. 구현 할 내용 
	```
	○ 주어진 예제 테이블
		버스(차량번호, 년식, 유지보수예정일, 유형)- PK : 차량번호 , FK : 유형(버스유형참조)
		버스유형(유형, 최대탑승인원)- PK : 유형 , FK : 없음
		직원(직원번호, 이름, 주소, 전화번호, 급여, 업무)- PK : 직원번호 , FK : 없음
		운전기사(직원번호, 교통위반티켓수, 운전면허종료일, 총운행거리)- PK : 직원번호 , FK : 직원번호(직원)
		노선(노선명, 출발정류장, 도착정류장)- PK : 노선명 , FK : 출발정류장(정류장 참조))
		운행스케쥴(노선명, 요일, 출발시간, 도착시간, 경유코드) // 노선마다 월,화,수,목,금,토,일 별로있음 - PK : 노선명,요일 ,FK : 없음 , 경유코드는 단순히 경유테이블 참조
		운행이력(노선명, 요일, 년도, 주, 기사, 운행버스) //주: week - PK : 년도,주,기사,운행버스 , FK : 노선명,요일(운행스케줄참조) , 기사(운전기사참조), 노선명(노선참조), 운행버스(버스유형참조)
		정류장(정류장명, 주소)- PK : 정류장명 , FK : 없음
		경유(경유코드, 정류장명, 도착시간, 출발시간) - PK : 경유코드,정류장명,도착시간 , FK : 정류장명(정류장참조)
		// 경유코드는 경유정류장별로 정류장에 버스가 도착하는 시간과 그 정류장에서 도착하는 시간정보를 코드값으로

	○ 제목 : 버스 운행스케쥴 조회 프로그램
	 - 입력: 승차정류장명, 하차정류장명, 시간(t0)
	 - 출력: <노선명, 요일, 출발시간(t1), 도착시간(t2)>의 리스트
	○ 조건
 	 1. 입력값의 t0보다 크거나 같은 t1을 가진 운행스케줄에 대해 
	 2. 입력값인 승차정류장명이 출발정류장 OR 경유지 이고 하차정류장명이 경유지 OR 도착정류지 이면 검색 
	 2. 노선별로 (월~일) 최대 7개의 스케줄 출력
	 3. 예제 테이블중 프로그램의 필요한 테이블 생성 : 노선, 운행스케줄, 경유
	 4. 시간 컬럼의 데이터 값은 float

	예) 경부선하행 노선/월요일 운행스케줄이 대전과 동대구를 경유한다고 가정
	입력 : 서울/부산 [or 대전/부산 or 대전/부산 or 대전/동대구] 10.10
	출력 : <결부선하행,요일,출발시간,도착시간>의 List 
	(여기서 출발시간은 10.10보다 크다)
	```
3. 구현 내용 
	1. VO 클래스
	```
	RouteInfo.java
	ScheduleInfo.java
	ViaInfo.java
	```
	2. DAO 클래스
	```java
	- BusRouteDAO.java -> BusRouteDAOImpl.java 
	  //노선 테이블생성 (테스트완료)
	  public void createTable()
	  //노선 등록 (테스트완료)
   	  public void createRoute(RouteInfo routeInfo);
	  
	- BusScheduleDAO.java -> BusScheduleDAOImpl.java
	  //운행스케줄 테이블생성 (테스트완료)
	  public void createTable()
	  //운행스케줄 등록 (테스트완료)
	  public void createSchecdule(ScheduleInfo scheduleInfo);
	  //운행스케줄 검색 (테스트완료)
	  public List<ScheduleInfo> searchSchedule(String onStation, String offStation, float time);
	  
	- ViaBusDAO.java -> ViaBusDAOImpl.java
	  //노선 테이블생성 (테스트완료)
	  public void createTable()
	  //경유지 등록 (테스트완료)
	  public void createVia(ViaInfo viaInfo);
	```
	3. 메인SQL **운행스케줄 검색**
	```SQL
	**입력(인자): 승차정류장명, 하차정류장명, 시간(t0)
	**MySQL
	with bus (routeName, day, arrivelStation, arrivelTime, transitCode, startTime ) as 
	   (select D.routeName , D.day, R.arrivelStation, D.arrivelTime, D.transitCode, 
		   (case 
		   when (R.departureStation = '승차정류장명' AND D.departureTime >= '시간(t0)') then D.departureTime
		   else V.departureTime
          		   end)
	   from busschedule as D, busroute as R, viabus as V 
	   Where D.routeName = R.routeName AND D.transitCode = V.transitCode AND
        	   ((R.departureStation = '승차정류장명' AND D.departureTime >= '시간(t0)') 
       	   OR (V.station = '승차정류장명' AND V.departureTime >= '시간(t0)'))) 
	select distinct B.routeName, B.day, round(B.startTime,2) as departureTime, round((case 
		when (B.arrivelStation ='하차정류장명') then B.arrivelTime
		else V.arrivelTime
        		end),2) as arrivelTime, B.transitCode
	from bus as B,viabus as V
	where B.transitCode = V.transitCode AND B.startTime <> V.departureTime
	AND (B.arrivelStation ='하차정류장명' OR V.station = '하차정류장명');
	
	**설명
	1) 운행스케줄 테이블과 경유테이블과 노선테이블을 노선명, 경유코드에 대해 조인연산
	2) 해당 테이블에서 승차정류장명이 노선의 출발지와 같고 출발시간이 주어진 시간보다 크거나
	3) 해당 테이블에서 승차정류장명이 경유지 정류장명과 같고 출발시간보다 큰 튜플을 검색
	4) 해당 튜플에 대해 노선명, 요일, 도착치, 도착시간, 경유코드, 출발시간를 선택
	5) 여기서 출발시간은 승차정류장명이 노선의 출발지와 같다면 해당 출발시간, 경유지의 정류장명과 같다면 경유지의 출발시간을 선택
	-> 노선의 출발지를 선택하지 않은 이유는 승차정류장명이 선택된 후에는 불필요한 컬럼이기 때문
	6) 위 테이블을 bus라는 임시테이블로 생성
	7) 임시테이블 bus와 경유테이블을 경유코드에 대해 조인연산
	8) 해당 테이블에 대해 bus의 출발시간과 경유테이블의 출발시간이 같이않은 튜플을 검색,
	-> 시간이 같은 경우는 임시테이블 bus에서 선택된 경유지와 동일하므로 조인결과에 필요없는 튜플이다.
	9) 검색된 튜플에 대해 하자정류장명이 노선의 도착지와 같거나 경유지의 정류명과 같은 튜플 선택
	10) 해당 튜플의 대해 노선명,요일,출발시간,도착시간,경유코드을 선택
	11) 여기서 도착시간은 하자정류장명이 노선의 도착지와 같다면 해당 도착시간, 경유지의 정류명과 같다면 경유지의 도착시간을 선택
	12) 여기서 출발시간, 도착시간은 반올림하는 함수인 round()를 사용
	```
	4. Main.java : recode 넣고 프로그램 실행
	5. DatabaseAuthInformation.java : DB정보연결할 DB접속정보클래스 (busDB 설정완료)

4. 정리
---

![슬라이드2](https://user-images.githubusercontent.com/60174144/96840206-1e826500-1485-11eb-976c-2adf5daba3f9.PNG)
