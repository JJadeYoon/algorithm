select ii.ITEM_ID, ii.ITEM_NAME, ii.RARITY
from item_info ii
    left join item_tree it
        on it.parent_item_id = ii.item_id
where it.item_id is null
order by 1 desc;