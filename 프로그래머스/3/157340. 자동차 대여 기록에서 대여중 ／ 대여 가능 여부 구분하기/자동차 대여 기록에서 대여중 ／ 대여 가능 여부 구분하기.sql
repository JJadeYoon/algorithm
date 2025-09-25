select distinct h2.car_id as "CAR_ID",
    case
        when exists (
            select 1
            from car_rental_company_rental_history h1
            where h1.car_id = h2.car_id 
                and h1.start_date <= '2022-10-16' and h1.end_date >= '2022-10-16'
        ) then '대여중'
        else '대여 가능'
    end as "AVAILABILITY"
from car_rental_company_rental_history h2
order by car_id desc;