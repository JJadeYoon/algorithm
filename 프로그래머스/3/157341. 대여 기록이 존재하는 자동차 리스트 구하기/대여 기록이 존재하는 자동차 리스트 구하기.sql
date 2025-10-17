-- 코드를 입력하세요
select distinct ch.CAR_ID
from car_rental_company_rental_history ch
    join car_rental_company_car cc
        on ch.car_id = cc.car_id
where cc.car_type = '세단'
    and ch.start_date >= '2022-10-01'
order by 1 desc;