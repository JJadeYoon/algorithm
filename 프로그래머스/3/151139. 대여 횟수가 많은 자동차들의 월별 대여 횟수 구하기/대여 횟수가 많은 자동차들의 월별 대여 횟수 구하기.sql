with OverFive as (
    select car_id
    from car_rental_company_rental_history
    where start_date >= '2022-08-01' and start_date < '2022-11-01'
    group by car_id
    having count(*) >= 5
)
select extract(month from start_date) as "MONTH", CAR_ID, count(*) as "RECORDS"
from car_rental_company_rental_history
where car_id in (select car_id from OverFive) and start_date >= '2022-08-01' and start_date < '2022-11-01'
group by extract(month from start_date), car_id
order by 1 asc, 2 desc;