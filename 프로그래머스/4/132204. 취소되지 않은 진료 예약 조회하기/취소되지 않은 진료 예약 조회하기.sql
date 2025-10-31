-- 코드를 입력하세요
select a.APNT_NO, p.PT_NAME, p.PT_NO, a.MCDP_CD, d.DR_NAME, a.APNT_YMD
from appointment a
    join patient p on a.pt_no = p.pt_no
    join doctor d on a.mddr_id = d.dr_id
where a.mcdp_cd = 'CS'
    and a.apnt_ymd like ('2022-04-13%')
    and a.apnt_cncl_yn = 'N'
order by 6;