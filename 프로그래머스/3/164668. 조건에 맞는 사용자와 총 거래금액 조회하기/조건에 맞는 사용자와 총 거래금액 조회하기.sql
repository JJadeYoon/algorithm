select u.USER_ID, u.NICKNAME, sum(b.price) as "TOTAL_SALES"
from USED_GOODS_USER u join USED_GOODS_BOARD b on b.writer_id = u.user_id
where b.status = 'DONE'
group by u.user_id
having sum(b.price) >= 700000
order by 3;