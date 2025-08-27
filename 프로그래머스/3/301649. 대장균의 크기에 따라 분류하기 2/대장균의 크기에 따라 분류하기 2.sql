-- 코드를 작성해주세요
select ID,
    case
        when ntile(4) over (order by SIZE_OF_COLONY desc) = 1 then 'CRITICAL'
        when ntile(4) over (order by SIZE_OF_COLONY desc) = 2 then 'HIGH'
        when ntile(4) over (order by SIZE_OF_COLONY desc) = 3 then 'MEDIUM'
        else 'LOW'
    end as COLONY_NAME
from ECOLI_DATA
order by ID;