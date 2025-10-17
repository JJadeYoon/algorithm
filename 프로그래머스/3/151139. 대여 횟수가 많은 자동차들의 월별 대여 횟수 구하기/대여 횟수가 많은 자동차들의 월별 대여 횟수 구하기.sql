select
    extract(month from c1.start_date) as "MONTH",
    c1.CAR_ID,
    count(*) as "RECORDS"
from car_rental_company_rental_history c1
where c1.car_id in (
    select c2.car_id
    from car_rental_company_rental_history c2
    where c2.start_date >= '2022-08-01' and c2.start_date < '2022-11-01'
    group by c2.car_id
    having count(*) >= 5
) and c1.start_date >= '2022-08-01'
  and c1.start_date < '2022-11-01'
group by extract(month from c1.start_date), car_id
having count(*) > 0
order by 1, 2 desc;