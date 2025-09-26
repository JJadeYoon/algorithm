select CAR_ID, round(avg(datediff(end_date, start_date) + 1), 1) as "AVERAGE_DURATION"
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
having avg(datediff(end_date, start_date) + 1) >= 7
order by 2 desc, 1 desc;