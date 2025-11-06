with recursive gens as (
    select id, parent_id, 1 as gen
    from ecoli_data
    where parent_id is null
    
    union all
    
    select e.id, e.parent_id, g.gen + 1
    from ecoli_data e
    join gens g on g.id = e.parent_id
) 

select count(*) as "COUNT", gen as "GENERATION"
from gens gs
left join ecoli_data ed on gs.id = ed.parent_id
where ed.parent_id is null
group by gs.gen
order by 2;