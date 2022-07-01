SELECT USER
FROM DUAL;
--==>> SCOTT

SELECT *
FROM TAB;

-- ���� ���̺� ����
DROP TABLE TBL_MEMBER;
--==>> Table TBL_MEMBER��(��) �����Ǿ����ϴ�.

-- ������ ����
PURGE RECYCLEBIN;
--==>> RECYCLEBIN��(��) ��������ϴ�.

-- ���� ������ ����
DROP SEQUENCE MEMBERSEQ;
--==>> Sequence MEMBERSEQ��(��) �����Ǿ����ϴ�.


--------------------------------------------------------------------------------

--�� �ǽ� ���̺� ����(TBL_MEMBER)
CREATE TABLE TBL_MEMBER
( SID   NUMBER
, NAME  VARCHAR2(30)
, TEL   VARCHAR2(40)
, CONSTRAINT MEMBER_SID_PK PRIMARY KEY(SID)
);
--==>> Table TBL_MEMBER��(��) �����Ǿ����ϴ�.


--�� ������ ����
CREATE SEQUENCE MEMBERSEQ
NOCACHE;
--==>> Sequence MEMBERSEQ��(��) �����Ǿ����ϴ�.


--�� ������ �Է� ������ ����
INSERT INTO TBL_MEMBER(SID, NAME, TEL)
VALUES(MEMBERSEQ.NEXTVAL, '���̻�','010-1111-1111');
--> �� �� ����
INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXTVAL, '���̻�','010-1111-1111')
;
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.

--�� ���� ������ �߰� �Է�
INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXTVAL, '������','010-2222-2222')
;
INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXTVAL, '�̽ÿ�','010-3333-3333')
;
INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXTVAL, '������','010-4444-4444')
;
INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXTVAL, '�̾Ƹ�','010-5555-5555')
;
--==>> 1 �� ��(��) ���ԵǾ����ϴ�. * 4


--�� ���̺� ��ü ��ȸ ������ ����(����Ʈ Ȯ��)
SELECT SID, NAME, TEL
FROM TBL_MEMBER
ORDER BY SID;
--> �� �� ����
SELECT SID, NAME, TEL FROM TBL_MEMBER ORDER BY SID
;
--==>>
/*
1	���̻�	010-1111-1111
2	������	010-2222-2222
3	�̽ÿ�	010-3333-3333
4	������	010-4444-4444
5	�̾Ƹ�	010-5555-5555
*/


--�� �ο� �� Ȯ�� ������ ����
SELECT COUNT(*) AS COUNT
FROM TBL_MEMBER;
--> �� �� ����
SELECT COUNT(*) AS COUNT FROM TBL_MEMBER
;
--==>> 5

--�� Ŀ��
COMMIT;
--==>> Ŀ�� �Ϸ�.