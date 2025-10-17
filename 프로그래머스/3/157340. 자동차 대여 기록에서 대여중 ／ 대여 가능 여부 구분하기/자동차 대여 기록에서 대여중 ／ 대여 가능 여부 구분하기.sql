select distinct
    c1.CAR_ID,
    case
        when exists (
            select 1
            from car_rental_company_rental_history c2
            where c2.car_id = c1.car_id
              and c2.start_date <= '2022-10-16'
              and c2.end_date >= '2022-10-16'
        ) then "대여중"
        else "대여 가능"
        end as "AVAILABILTY"
from car_rental_company_rental_history c1
order by 1 desc;