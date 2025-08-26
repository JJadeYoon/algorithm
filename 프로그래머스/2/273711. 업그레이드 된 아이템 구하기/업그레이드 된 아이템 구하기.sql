-- 코드를 작성해주세요
select pr.ITEM_ID, pr.ITEM_NAME, pr.RARITY
from ITEM_INFO ch 
    left join ITEM_TREE it
        on ch.ITEM_ID = it.PARENT_ITEM_ID
    join ITEM_INFO pr
        on it.ITEM_ID = pr.ITEM_ID
where ch.RARITY = 'RARE'
order by ITEM_ID desc