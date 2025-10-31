-- 코드를 입력하세요
select 
    USER_ID,
    NICKNAME, 
    concat_ws(' ', city, STREET_ADDRESS1, STREET_ADDRESS2) as "전체주소",
    insert(insert(tlno, 4, 0, '-'), 9, 0, '-') as "전화번호"
from used_goods_user u
where u.user_id in (select b.writer_id
                    from used_goods_board b
                    group by b.writer_id
                    having count(*) >= 3)
order by 1 desc;
