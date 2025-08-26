-- 코드를 작성해주세요
select c.ITEM_ID, c.ITEM_NAME, c.RARITY  -- 자식 정보 출력
from ITEM_INFO p
    join ITEM_TREE it on p.ITEM_ID = it.PARENT_ITEM_ID
    join ITEM_INFO c on it.ITEM_ID = c.ITEM_ID
where p.RARITY = 'RARE'  -- 부모가 RARE
order by c.ITEM_ID desc  -- 자식 ID 기준