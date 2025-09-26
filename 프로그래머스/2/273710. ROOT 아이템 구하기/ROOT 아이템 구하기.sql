select c.ITEM_ID, c.ITEM_NAME
from item_info c
    join item_tree it on c.item_id = it.item_id
where it.parent_item_id is null
order by 1;