select fi.ID, fn.FISH_NAME, fi.LENGTH
from fish_info fi join fish_name_info fn on fi.fish_type = fn.fish_type
where fi.length = (select max(fi1.length) 
                   from fish_info fi1 
                   where fi.fish_type = fi1.fish_type
                     and fi.length is not null
                     and fi.length > 10)
order by fi.id;