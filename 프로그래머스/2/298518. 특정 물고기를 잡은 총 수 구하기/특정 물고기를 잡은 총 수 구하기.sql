-- 코드를 작성해주세요
select count(*) as FISH_COUNT
from FISH_INFO fi 
    join FISH_NAME_INFO fn
        on fi.FISH_TYPE = fn.FISH_TYPE
where fn.FISH_NAME in ('BASS', 'SNAPPER');