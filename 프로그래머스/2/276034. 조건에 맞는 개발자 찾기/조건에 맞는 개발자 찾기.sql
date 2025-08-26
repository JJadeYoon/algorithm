-- 코드를 작성해주세요
select d.ID, d.EMAIL, d.FIRST_NAME, d.LAST_NAME
from DEVELOPERS d
WHERE d.SKILL_CODE & (select CODE from SKILLCODES where NAME = 'Python')
    or d.SKILL_CODE & (select CODE from SKILLCODES where NAME = 'C#')
order by ID;