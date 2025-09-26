select ri.REST_ID, ri.REST_NAME, ri.FOOD_TYPE, ri.FAVORITES, ri.ADDRESS, 
    round(avg(rr.review_score), 2) as "REVIEW_SCORE"
from REST_INFO ri
    join REST_REVIEW rr
        on ri.rest_id = rr.rest_id
where ri.address like ('서울%')
group by ri.rest_id
order by 6 desc, 4 desc;