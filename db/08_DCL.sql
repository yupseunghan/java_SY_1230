#사용자 추가
# CREATE USER '아이디'@'호트스명' IDENTIFIED BY '비밀번호';
#'아이디' : 사용자 께정명
#'호스트명' : 접근 권한
# -LOCALHOST : 내부에서만 가능 => 다른 PC에서 해당 DB에 접근이 불가능
# -% : 외부에서도 접근 가능
CREATE USER 'community_admin'@'%'identified BY 'admin';

#사용자 조회
SELECT USER, HOST FROM MYSQL.USER;

#사용자 비번 변셩
#SET PASSWORD FOR '아이디'@'호스트명' ='새비밀번호';
SET PASSWORD FOR 'community_admin'@'%'='admin123';

#사용자 삭ㄱ제
# DROP USER '아이디'@'호스트명';
DROP USER 'community_admin'@'%';

CREATE USER 'community_admin'@'%'identified BY 'admin';

#권한 부여
# - 사용자에 특정 DB에 대한 권한을 부여. 테이블 추가/수정/삭제, 
#데이터 추가/수정/삭제/조회등
# - SELECT/INSERT/UPDATE/DELETE/CREATE/ALTER/DROP/REFERECES/ALL PRIVILEGES(모둔 권한)
#GRANT 권한 ON DB명.테이블명 TO '아이디'@'호스트명';
GRANT select ON comunity.* to 'community_admin'@'%';
GRANT ALL PRIVILEGES ON comunity.* to 'community_admin'@'%';

#권한 제거
#REVOKE 권한 ON DB명.테이블명 FROM '아이디'@'호스트명';
REVOKE INSERT ON COMUNITY.* FROM 'community_admin'@'%';

#권환 확인
SHOW GRANTS FOR 'community_admin'@'%'; 