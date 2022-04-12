# spring batch

## BatchAutoConfiguration

* 스프링 배치가 초기화 될 떄 자동으로 실행되는 설정 클래스
* Job 을 수행하는 JobLauncherApplicationRunner 빈을 생성ㅠ

## 실행법

* `JobParameters` 값 넣을 때
```shell
java -jar batch.jar name=user1 seq(long)=2L date(date)=2021/02/02 age(double)=12.2
```
