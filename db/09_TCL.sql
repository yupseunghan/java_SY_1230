#TCL
#트랜잭션 제어 언어
#트랙잭션 : DB 상태를 변화 시키기 위해 수행하는 작업 단위
#STRAT TRANSACTION/BEGIN/BEGIN WORL : 트랙잭션을 시작
#SAVEPOINT 저장명 : 임시로 저장할 위치를 지정
#ROLLBACK TO 저장명 : 저장명전까지 상태로 되돌림
#ROLLBACK : 트랙잭션 시작 전까지 상태로 되돌림
#COMMIT : 지금까지 했던 작업을 반영함
use STUDENT;
SELECT* FROM SCORE;
START transaction;
UPDATE SCORE SET SC_SCORE =90 WHERE SC_NUM=1;
savepoint S1;
UPDATE SCORE SET SC_SCORE =90 WHERE SC_NUM=2;
savepoint S2;
ROLLBACK TO S1;
ROLLBACK TO S2;
ROLLBACK;
COMMIT;