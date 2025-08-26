-- 코드를 작성해주세요
select p.ID, count(c.ID) as CHILD_COUNT
from ECOLI_DATA p
    left join ECOLI_DATA c
        on c.PARENT_ID = p.ID
group by p.ID
order by p.ID;