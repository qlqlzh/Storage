-- 자동으로 1씩 증가하는 시퀀스를 만든다.
CREATE SEQUENCE guestbook_idx_seq;
-- 자동으로 1씩 증가하는 시퀀스를 제거한다.
DROP SEQUENCE guestbook_idx_seq;

-- SEQUENCE를 1부터 다시 시작되게 하려면 아래와 같이 실행하면 된다.
DELETE FROM GUESTBOOK;
DROP SEQUENCE guestbook_idx_seq;
CREATE SEQUENCE guestbook_idx_seq;

INSERT into guestbook(idx, name, password, memo, ip) VALUES (guestbook_idx_seq.nextval, '홍길동', '1111', '1등 입니다.', '192.168.100.101');
INSERT into guestbook(idx, name, password, memo, ip) VALUES (guestbook_idx_seq.nextval, '임꺽정', '2222', '2등 입니다.', '192.168.100.102');
INSERT into guestbook(idx, name, password, memo, ip) VALUES (guestbook_idx_seq.nextval, '장길산', '3333', '3등 입니다.', '192.168.100.103');
INSERT into guestbook(idx, name, password, memo, ip) VALUES (guestbook_idx_seq.nextval, '일지매', '4444', '4등 입니다.', '192.168.100.104');

SELECT * FROM GUESTBOOK;

SELECT COUNT(*) FROM GUESTBOOK;
SELECT * FROM GUESTBOOK WHERE idx = 1;

SELECT COUNT(*) FROM GUESTBOOK WHERE memo LIKE '%1등%';
SELECT COUNT(*) FROM GUESTBOOK WHERE name LIKE '%길%';
SELECT COUNT(*) FROM GUESTBOOK WHERE memo LIKE '%둘리%' or name LIKE '%둘리%';

COMMIT;
