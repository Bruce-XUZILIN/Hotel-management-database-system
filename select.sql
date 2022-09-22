-- 1 
select *
from item

-- 2
select p.*
from borrow b
left join patrons p
on p.libraryCardID = b.libraryCardID
where TrueReturnDate is null
and ExpReturnDate < sysdate

-- 3
select b.libraryCardID,sum(cost) as sum
from borrow b, patrons p
where p.libraryCardID = b.libraryCardID
and b.checks = 0
group by b.libraryCardID;

-- 4
select b.libraryCardID,b.cost_Detail,b.cost
from borrow b, patrons p
where p.libraryCardID = b.libraryCardID
and b.checks = 1;

-- 5
select i.*
from borrow b,item i
where i.itemid = b.itemid
and TrueReturnDate is null
and ExpReturnDate < sysdate;


-- 6
select *
from request
where checks = 0;

-- 7
select sum(cost) as sum
from borrow b
where 
and b.TrueReturnDate > to_date('2012-03-01','yyyy-mm-dd')
and b.TrueReturnDate < to_date('2012-03-31','yyyy-mm-dd')

-- 8
select itemid,renewtimes,borrowtime
from item 

-- 9
select i.itemid,i.name,count(*) as borrowsum,sum(b.renewtimes) as renewsum
from borrow b,item i
where b.itemid = i.itemid
group by i.itemid,i.name


-- 10
INSERT INTO "SCOTT"."ITEM" (ITEMID, NAME, TYPE, PAYMENT, RENEWTIMES, BORROWTIME, AMOUNT, FINE) VALUES ('1', '1', '1', '1', '1', '1', '1', '1')
INSERT INTO "SCOTT"."ITEM" (ITEMID, NAME, TYPE, PAYMENT, RENEWTIMES, BORROWTIME, AMOUNT, FINE) VALUES ('2', '2', '2', '2', '2', '2', '2', '2')


INSERT INTO "SCOTT"."PATRONS" (LIBRARYCARDID, PATRONADDERSS, NAME, PHONENUMBER) VALUES ('1', '1', '1', '1')
INSERT INTO "SCOTT"."PATRONS" (LIBRARYCARDID, PATRONADDERSS, NAME, PHONENUMBER) VALUES ('2', '2', '2', '2')
INSERT INTO "SCOTT"."PATRONS" (LIBRARYCARDID, PATRONADDERSS, NAME, PHONENUMBER) VALUES ('3', '3', '3', '3')
INSERT INTO "SCOTT"."PATRONS" (LIBRARYCARDID, PATRONADDERSS, NAME, PHONENUMBER) VALUES ('4', '4', '4', '4')


INSERT INTO "SCOTT"."BORROW" (BORROWID, ITEMID, LIBRARYCARDID, STARTDATE, EXPRETURNDATE, RENEWTIMES, CHECKS, COST, COST_DETAIL) VALUES ('1', '1', '1', TO_DATE('2021-05-01 22:45:43', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2021-05-09 22:45:47', 'YYYY-MM-DD HH24:MI:SS'), '1', '1', '1', '1')
INSERT INTO "SCOTT"."BORROW" (BORROWID, ITEMID, LIBRARYCARDID, STARTDATE, EXPRETURNDATE, RENEWTIMES, CHECKS, COST, COST_DETAIL) VALUES ('2', '2', '2', TO_DATE('2021-01-12 22:45:52', 'YYYY-MM-DD HH2



insert into request(RequestID,itemid,LibrarycardID,RequestDetail,checks)
values(5, 1, 1, 'Can I buy this book',0)



