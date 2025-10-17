select ri.REST_ID, ri.REST_NAME, ri.FOOD_TYPE, ri.FAVORITES, ri.ADDRESS, round(avg(rr.REVIEW_SCORE), 2) as "SCORE"
from rest_info ri
    join rest_review rr
        on ri.rest_id = rr.rest_id
where ri.address like '서울%'
group by rest_id
order by 6 desc, 4 desc