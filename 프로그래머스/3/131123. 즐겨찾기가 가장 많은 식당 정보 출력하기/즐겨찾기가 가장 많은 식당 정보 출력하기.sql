-- 코드를 입력하세요

select r1.FOOD_TYPE, r1.REST_ID, r1.REST_NAME, r1.FAVORITES
from rest_info r1
where r1.favorites = (
    select max(r2.favorites)
    from rest_info r2
    where r1.food_type = r2.food_type
)
order by 1 desc
