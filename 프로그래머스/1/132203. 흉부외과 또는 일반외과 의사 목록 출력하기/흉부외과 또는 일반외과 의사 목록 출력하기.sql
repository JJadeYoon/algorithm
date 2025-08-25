-- 코드를 입력하세요
select d.DR_NAME, d.DR_ID, d.MCDP_CD, date_format(d.HIRE_YMD, '%Y-%m-%d') as HIRE_YMD
from DOCTOR d
where d.MCDP_CD = 'CS' or d.MCDP_CD = 'GS'
order by d.HIRE_YMD desc, d.DR_NAME asc;