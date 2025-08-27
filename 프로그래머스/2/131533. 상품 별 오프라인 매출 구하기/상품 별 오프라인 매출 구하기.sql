-- 코드를 입력하세요
select PRODUCT_CODE, sum(os.SALES_AMOUNT) * p.PRICE as SALES
from PRODUCT p
    join OFFLINE_SALE os on p.PRODUCT_ID = os.PRODUCT_ID
group by p.PRODUCT_ID
order by 2 desc, 1 asc;