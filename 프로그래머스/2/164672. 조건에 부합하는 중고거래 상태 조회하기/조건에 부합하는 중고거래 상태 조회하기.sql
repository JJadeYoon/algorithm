-- 코드를 입력하세요
select
    BOARD_ID,
    WRITER_ID,
    TITLE,
    PRICE,
    case
        when status = 'SALE' then '판매중'
        when status = 'RESERVED' then '예약중'
        else '거래완료'
    end as "STATUS"
from used_goods_board
where created_date = '2022-10-05'
order by 1 desc;