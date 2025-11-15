-- 코드를 입력하세요
select b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, to_char(r.CREATED_DATE, 'YYYY-MM-DD') as "CREATED_DATE"
from used_goods_board b
    join used_goods_reply r 
        on b.board_id = r.board_id
where b.created_date >= date '2022-10-01'
    and b.created_date < date '2022-11-01'
order by r.CREATED_DATE, b.TITLE;