-- 코드를 입력하세요
select ao.ANIMAL_ID, ao.NAME
from ANIMAL_INS ai 
    right join ANIMAL_OUTS ao
        on ai.ANIMAL_ID = ao.ANIMAL_ID
where ai.ANIMAL_ID is null
order by 1