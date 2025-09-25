select mp.MEMBER_NAME, rr1.REVIEW_TEXT, date_format(rr1.review_date, '%Y-%m-%d') as "REVIEW_DATE"
from member_profile mp
join rest_review rr1 on mp.member_id = rr1.member_id
and mp.member_id = (
          select rr2.member_id 
            from rest_review rr2
        group by rr2.member_id
        order by count(*) desc
        limit 1)
order by 3, 2;