-- 코드를 입력하세요
select ii.ingredient_type as 'INGREDIENT_TYPE', sum(total_order) as 'TOTAL_ORDER'
from FIRST_HALF fh join ICECREAM_INFO ii
    on fh.FLAVOR = ii.FLAVOR
group by ii.ingredient_type
order by 2
