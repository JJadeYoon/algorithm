with recursive gens as (
    select id, parent_id, 1 as gen
    from ecoli_data
    where parent_id is null
    
    union all
    
    select e.id, e.parent_id, g.gen + 1
    from gens g
        join ecoli_data e on g.id = e.parent_id
)

select ID from gens where gen = 3 order by 1;